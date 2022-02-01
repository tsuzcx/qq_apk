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
  public static final Long b = Long.valueOf(1L);
  public static final Long c = Long.valueOf(2L);
  public static final Long d = Long.valueOf(3L);
  public static final Long e = Long.valueOf(4L);
  public static final Long f = Long.valueOf(5L);
  public static final Long g = Long.valueOf(6L);
  private static Long s;
  private String A = "none";
  private int B = 0;
  private int C = 0;
  private int D = 0;
  private AEEditReportData E = new AEEditReportData();
  private int F = -1;
  private String G = "none";
  private String H = null;
  private String I = null;
  private long J = 0L;
  private long K = 0L;
  private long L = 0L;
  private long M = 0L;
  private boolean N;
  private boolean O = true;
  private long P = -1L;
  private long Q = -1L;
  private String R = "none";
  private long S = 0L;
  private long T = 1L;
  private long U = 1L;
  private String V = "none";
  private String W = "none";
  private String X = "#ffffff";
  private String Y = "";
  private String Z = "none";
  public String h;
  public String i;
  private HashMap<String, String> j = new HashMap();
  private String k;
  private boolean l = false;
  private String m;
  private boolean n;
  private final Map<String, String> o = new HashMap();
  private String p;
  private String q = "";
  private int r = -1;
  @AEBaseReportParam.EditPicFrom
  private int t;
  private long u;
  private long v = -1L;
  private String w = "none";
  private String x = "none";
  private int y = -1;
  private String z = "-1";
  
  static
  {
    Long localLong = Long.valueOf(-1L);
    s = localLong;
    a = localLong;
  }
  
  public static AEBaseReportParam a()
  {
    return AEBaseReportParam.SingletonHolder.a();
  }
  
  private HashMap<String, String> a(String paramString1, int paramInt, String paramString2)
  {
    HashMap localHashMap = new HashMap();
    int i1 = this.F;
    if ((i1 != 4) && (i1 != 5) && (i1 != 6) && (i1 != 7) && (i1 != 2)) {
      localHashMap.put("face_id", this.w);
    } else {
      localHashMap.put("face_id", this.x);
    }
    a(localHashMap);
    localHashMap.put("content_type", s.toString());
    localHashMap.put("MD5", paramString1);
    paramString1 = new DecimalFormat("0.00").format(this.B / 100.0F);
    String str = new DecimalFormat("0.00").format(this.C / 100.0F);
    localHashMap.put("beauty_value", paramString1);
    localHashMap.put("facial_value", str);
    if (!TextUtils.isEmpty(this.m)) {
      localHashMap.put("filter_id", this.m);
    } else {
      localHashMap.put("filter_id", "none");
    }
    paramString1 = new StringBuilder();
    paramString1.append("");
    paramString1.append(this.u);
    localHashMap.put("duration", paramString1.toString());
    localHashMap.put("cameraId", AEBaseDataUtil.a(FlowCameraConstant.b));
    if (s.longValue() == 1L) {
      localHashMap.put("resolution", AEDashboardUtil.a.d());
    } else if (s.longValue() == 2L) {
      localHashMap.put("resolution", AEDashboardUtil.a.g());
    } else {
      localHashMap.put("resolution", "none");
    }
    paramString1 = new StringBuilder();
    paramString1.append(this.t);
    paramString1.append("");
    localHashMap.put("pic_from", paramString1.toString());
    localHashMap.put("post_type", String.valueOf(paramInt));
    localHashMap.put("receive_type", paramString2);
    localHashMap.put("face_index", String.valueOf(this.y));
    localHashMap.put("face_from", this.z);
    localHashMap.put("face_tab", this.A);
    paramString1 = new StringBuilder();
    paramString1.append(this.F);
    paramString1.append("");
    localHashMap.put("face_type", paramString1.toString());
    paramInt = this.F;
    if ((paramInt != 4) && (paramInt != 5) && (paramInt != 6) && (paramInt != 7))
    {
      paramString1 = new StringBuilder();
      paramString1.append(this.w);
      paramString1.append(UserAction.getQIMEI());
      localHashMap.put("face_uin", paramString1.toString());
    }
    else
    {
      paramString1 = new StringBuilder();
      paramString1.append(this.x);
      paramString1.append(UserAction.getQIMEI());
      localHashMap.put("face_uin", paramString1.toString());
    }
    paramString1 = new JSONObject(this.o).toString();
    paramString2 = new StringBuilder();
    paramString2.append("getPostBtnParam---editJsonStr=");
    paramString2.append(paramString1);
    QLog.d("AEBaseReportParam", 1, paramString2.toString());
    localHashMap.put("edit_json", paramString1);
    return localHashMap;
  }
  
  private long ac()
  {
    return System.currentTimeMillis() - this.v;
  }
  
  private HashMap<String, String> b(String paramString1, String paramString2)
  {
    HashMap localHashMap = new HashMap(6);
    localHashMap.put("face_id", paramString1);
    localHashMap.put("face_tab", this.A);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.F);
    localStringBuilder.append("");
    localHashMap.put("face_type", localStringBuilder.toString());
    localHashMap.put("face_index", String.valueOf(this.y));
    localHashMap.put("face_from", paramString2);
    paramString2 = new StringBuilder();
    paramString2.append(paramString1);
    paramString2.append(UserAction.getQIMEI());
    localHashMap.put("face_uin", paramString2.toString());
    a(localHashMap);
    return localHashMap;
  }
  
  public HashMap<String, String> A()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("content_type", String.valueOf(this.E.v));
    localHashMap.put("red_point", String.valueOf(this.E.F));
    return localHashMap;
  }
  
  public void A(String paramString)
  {
    this.W = paramString;
  }
  
  public HashMap<String, String> B()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("video_id", this.E.d);
    return localHashMap;
  }
  
  public void B(String paramString)
  {
    this.X = paramString;
  }
  
  public void C()
  {
    this.H = null;
    this.I = null;
  }
  
  public void C(String paramString)
  {
    this.R = paramString;
  }
  
  public HashMap<String, String> D()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("music_id", this.E.n);
    localHashMap.put("music_list", this.E.z);
    localHashMap.put("video_id", this.E.d);
    String str;
    if (this.E.p) {
      str = "1";
    } else {
      str = "0";
    }
    localHashMap.put("is_recommend", str);
    localHashMap.put("recommend_index", String.valueOf(this.E.q));
    localHashMap.put("music_duration", String.valueOf(this.E.r));
    localHashMap.put("video_duration", String.valueOf(this.E.t));
    localHashMap.put("video_source", String.valueOf(this.E.u));
    return localHashMap;
  }
  
  public void D(String paramString)
  {
    this.Z = paramString;
  }
  
  public HashMap<String, String> E()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("music_id", this.E.n);
    localHashMap.put("video_id", this.E.d);
    localHashMap.put("lyric_status", String.valueOf(this.E.A));
    return localHashMap;
  }
  
  public HashMap<String, String> E(String paramString)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("filter_id", paramString);
    return localHashMap;
  }
  
  public HashMap<String, String> F()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("content_type", String.valueOf(this.E.v));
    localHashMap.put("video_id", this.E.d);
    localHashMap.put("video_source", String.valueOf(this.E.u));
    localHashMap.put("video_duration", String.valueOf(this.E.t));
    return localHashMap;
  }
  
  public HashMap<String, String> F(String paramString)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("text_content", paramString);
    A(paramString);
    return localHashMap;
  }
  
  public HashMap<String, String> G()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("color_type", this.E.B);
    localHashMap.put("text_item_id", this.E.C);
    localHashMap.put("common_color_list", String.valueOf(this.E.D));
    return localHashMap;
  }
  
  public HashMap<String, String> G(String paramString)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("emoticon_id", paramString);
    return localHashMap;
  }
  
  public HashMap<String, String> H()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("content_type", String.valueOf(this.E.v));
    return localHashMap;
  }
  
  public HashMap<String, String> H(String paramString)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("emoticon_id", this.R);
    if (TextUtils.isEmpty(paramString))
    {
      localHashMap.put("word_source", "none");
      return localHashMap;
    }
    localHashMap.put("word_source", paramString);
    return localHashMap;
  }
  
  public HashMap<String, String> I()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("content_type", s.toString());
    return localHashMap;
  }
  
  public HashMap<String, String> I(@NonNull String paramString)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("watermark_id", paramString);
    return localHashMap;
  }
  
  public HashMap<String, String> J()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("duration_first_frame", AEBaseDataUtil.a(Long.valueOf(this.K - this.J)));
    localHashMap.put("duration_bottom_bar", AEBaseDataUtil.a(Long.valueOf(this.L - this.J)));
    localHashMap.put("duration_photo_btn", AEBaseDataUtil.a(Long.valueOf(this.M - this.J)));
    String str;
    if (AEBaseDataUtil.d()) {
      str = "first_launch";
    } else if (this.N) {
      str = "cold_launch";
    } else {
      str = "warm_launch";
    }
    localHashMap.put("launch_type", str);
    return localHashMap;
  }
  
  public HashMap<String, String> J(@NonNull String paramString)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("gps", paramString);
    return localHashMap;
  }
  
  public HashMap<String, String> K()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("OpenGL", GLCapabilities.getGlesVersion());
    localHashMap.put("shader", String.valueOf(GLCapabilities.isFilamentShaderCompileSucceed()));
    return localHashMap;
  }
  
  public void L()
  {
    this.J = 0L;
    this.K = 0L;
    this.L = 0L;
    this.M = 0L;
    this.N = false;
  }
  
  public void M()
  {
    if (this.K == 0L) {
      this.K = System.currentTimeMillis();
    }
  }
  
  public void N()
  {
    if (this.L == 0L) {
      this.L = System.currentTimeMillis();
    }
  }
  
  public void O()
  {
    if (this.M == 0L) {
      this.M = System.currentTimeMillis();
    }
  }
  
  public boolean P()
  {
    long l1 = this.J;
    if (l1 > 0L)
    {
      long l2 = this.K;
      if (l2 > 0L)
      {
        long l3 = this.L;
        if (l3 > 0L)
        {
          long l4 = this.M;
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
  
  public void Q()
  {
    this.Q = System.currentTimeMillis();
  }
  
  public void R()
  {
    StringBuilder localStringBuilder = new StringBuilder(this.k);
    String str = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA).format(new Date());
    localStringBuilder.append(" ");
    localStringBuilder.append(str);
    this.Y = MD5.b(localStringBuilder.toString());
  }
  
  public String S()
  {
    if (this.k == null) {
      this.k = "none";
    }
    StringBuilder localStringBuilder = new StringBuilder(this.k);
    String str = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA).format(new Date());
    localStringBuilder.append(" ");
    localStringBuilder.append(str);
    return MD5.b(localStringBuilder.toString());
  }
  
  public HashMap<String, String> T()
  {
    long l1 = System.currentTimeMillis();
    long l2 = this.Q;
    HashMap localHashMap = new HashMap();
    localHashMap.put("duration", AEBaseDataUtil.a(Long.valueOf(l1 - l2)));
    return localHashMap;
  }
  
  public HashMap<String, String> U()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("duration", AEBaseDataUtil.a(Long.valueOf(this.S)));
    localHashMap.put("cutout_type", Long.toString(this.T));
    localHashMap.put("countdown_type", Long.toString(this.U));
    Object localObject = new DecimalFormat("0.00").format(this.B / 100.0F);
    String str = new DecimalFormat("0.00").format(this.C / 100.0F);
    localHashMap.put("beauty_value", localObject);
    localHashMap.put("facial_value", str);
    localObject = VideoFilterTools.a().c(0);
    if (localObject != null) {
      this.V = ((QIMFilterCategoryItem)localObject).a;
    } else {
      this.V = "none";
    }
    localHashMap.put("filter_id", this.V);
    localHashMap.put("cameraId", AEBaseDataUtil.a(FlowCameraConstant.b));
    localHashMap.put("emoticon_id", this.R);
    if (TextUtils.isEmpty(this.Z))
    {
      localHashMap.put("emo_sort_id", "none");
      return localHashMap;
    }
    localHashMap.put("emo_sort_id", this.Z);
    return localHashMap;
  }
  
  public HashMap<String, String> V()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("emoticon_id", this.R);
    if (TextUtils.isEmpty(this.Z))
    {
      localHashMap.put("emo_sort_id", "none");
      return localHashMap;
    }
    localHashMap.put("emo_sort_id", this.Z);
    return localHashMap;
  }
  
  public HashMap<String, String> W()
  {
    HashMap localHashMap = new HashMap();
    if (TextUtils.isEmpty(this.Z))
    {
      localHashMap.put("emo_sort_id", "none");
      return localHashMap;
    }
    localHashMap.put("emo_sort_id", this.Z);
    return localHashMap;
  }
  
  public HashMap<String, String> X()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("duration", AEBaseDataUtil.a(Long.valueOf(this.S)));
    localHashMap.put("cutout_type", Long.toString(this.T));
    localHashMap.put("countdown_type", Long.toString(this.U));
    Object localObject = new DecimalFormat("0.00").format(this.B / 100.0F);
    String str = new DecimalFormat("0.00").format(this.C / 100.0F);
    localHashMap.put("beauty_value", localObject);
    localHashMap.put("facial_value", str);
    localHashMap.put("cameraId", AEBaseDataUtil.a(FlowCameraConstant.b));
    localHashMap.put("emoticon_id", this.R);
    localHashMap.put("text_content", this.W);
    if (this.W.equals("none")) {
      localHashMap.put("text_color", "none");
    } else {
      localHashMap.put("text_color", this.X);
    }
    localObject = VideoFilterTools.a().c(0);
    if (localObject != null) {
      this.V = ((QIMFilterCategoryItem)localObject).a;
    } else {
      this.V = "none";
    }
    localHashMap.put("filter_id", this.V);
    if (this.Y.equals("")) {
      R();
    }
    localHashMap.put("MD5", this.Y);
    if (TextUtils.isEmpty(this.Z))
    {
      localHashMap.put("emo_sort_id", "none");
      return localHashMap;
    }
    localHashMap.put("emo_sort_id", this.Z);
    return localHashMap;
  }
  
  public HashMap<String, String> Y()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("duration", AEBaseDataUtil.a(Long.valueOf(this.S)));
    localHashMap.put("cutout_type", Long.toString(this.T));
    localHashMap.put("countdown_type", Long.toString(this.U));
    Object localObject = new DecimalFormat("0.00").format(this.B / 100.0F);
    String str = new DecimalFormat("0.00").format(this.C / 100.0F);
    localHashMap.put("beauty_value", localObject);
    localHashMap.put("facial_value", str);
    localHashMap.put("cameraId", AEBaseDataUtil.a(FlowCameraConstant.b));
    localHashMap.put("text_content", this.W);
    if (!localHashMap.containsKey("emoticon_id")) {
      localHashMap.put("emoticon_id", this.R);
    }
    localObject = VideoFilterTools.a().c(0);
    if (localObject != null) {
      this.V = ((QIMFilterCategoryItem)localObject).a;
    } else {
      this.V = "none";
    }
    localHashMap.put("filter_id", this.V);
    if (!localHashMap.containsKey("text_color")) {
      if (this.W.equals("none")) {
        localHashMap.put("text_color", "none");
      } else {
        localHashMap.put("text_color", this.X);
      }
    }
    if (this.Y.equals("")) {
      R();
    }
    localHashMap.put("MD5", this.Y);
    if (TextUtils.isEmpty(this.Z))
    {
      localHashMap.put("emo_sort_id", "none");
      return localHashMap;
    }
    localHashMap.put("emo_sort_id", this.Z);
    return localHashMap;
  }
  
  public HashMap<String, String> Z()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("emoticon_id", this.R);
    return localHashMap;
  }
  
  public HashMap<String, String> a(float paramFloat, String paramString)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("change_speed_type", String.valueOf(paramFloat));
    localHashMap.put("change_speed_opin", paramString);
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
    localHashMap.put("content_type", s.toString());
    localHashMap.put("face_id", this.w);
    a(localHashMap);
    return localHashMap;
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
    Object localObject = this.H;
    if ((localObject == null) || (!((String)localObject).equals(paramString)))
    {
      this.H = paramString;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(QQStoryContext.k().getAccount());
      ((StringBuilder)localObject).append(AEBaseDataUtil.a());
      this.I = MD5Utils.toMD5(((StringBuilder)localObject).toString());
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
  
  public HashMap<String, String> a(String paramString1, String paramString2, String paramString3)
  {
    HashMap localHashMap = new HashMap(2);
    localHashMap.put("face_id", paramString1);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString1);
    localStringBuilder.append(UserAction.getQIMEI());
    localHashMap.put("face_uin", localStringBuilder.toString());
    localHashMap.put("sys_race_id", paramString2);
    localHashMap.put("sys_race_level", paramString3);
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
  
  public void a(int paramInt)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[setDeviceLevel] level= ");
    ((StringBuilder)localObject).append(paramInt);
    QLog.d("AEBaseReportParam", 4, ((StringBuilder)localObject).toString());
    localObject = this.j;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(paramInt);
    ((HashMap)localObject).put("device_level", localStringBuilder.toString());
  }
  
  public void a(int paramInt, String paramString)
  {
    this.j.put("op_in", String.valueOf(paramInt));
    if ((paramString != null) && (!TextUtils.isEmpty(paramString)))
    {
      this.j.put("activity_id", paramString);
      return;
    }
    this.j.put("activity_id", "none");
  }
  
  public void a(long paramLong)
  {
    this.u = paramLong;
  }
  
  public void a(String paramString)
  {
    String str = this.p;
    if ((str != null) && (!str.equals(paramString)))
    {
      this.p = null;
      this.j.put("activity_id", "none");
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    this.p = paramString1;
    if ((paramString2 != null) && (!TextUtils.isEmpty(paramString2)))
    {
      this.j.put("activity_id", paramString2);
      return;
    }
    this.j.put("activity_id", "none");
  }
  
  public void a(Map<String, String> paramMap)
  {
    paramMap.put("sys_race_id", this.h);
    paramMap.put("sys_race_level", this.i);
  }
  
  public void a(boolean paramBoolean)
  {
    this.l = paramBoolean;
  }
  
  public void aa()
  {
    this.T = 1L;
    this.U = 1L;
  }
  
  public void ab()
  {
    this.E = new AEEditReportData();
  }
  
  public HashMap<String, String> b(int paramInt, String paramString)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("emoticon_id", paramString);
    localHashMap.put("emo_num", String.valueOf(paramInt));
    if (TextUtils.isEmpty(this.Z))
    {
      localHashMap.put("emo_sort_id", "none");
      return localHashMap;
    }
    localHashMap.put("emo_sort_id", this.Z);
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
  
  public void b()
  {
    String str = AEBaseDataUtil.a();
    this.j.put("operation_time", str);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("【operation_time】:");
    localStringBuilder.append(str);
    AEQLog.b("AEBaseReportParam", localStringBuilder.toString());
  }
  
  public void b(int paramInt)
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
    HashMap localHashMap = this.j;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(i1);
    localHashMap.put("sex", localStringBuilder.toString());
  }
  
  public void b(long paramLong)
  {
    s = Long.valueOf(paramLong);
  }
  
  public void b(String paramString)
  {
    this.j.put("recom_reason", paramString);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(" 【recom_reason】:");
    localStringBuilder.append(paramString);
    AEQLog.b("AEBaseReportParam", localStringBuilder.toString());
  }
  
  public void b(boolean paramBoolean)
  {
    this.n = paramBoolean;
  }
  
  public HashMap<String, String> c(long paramLong)
  {
    HashMap localHashMap = new HashMap();
    int i1 = this.F;
    if ((i1 != 4) && (i1 != 5) && (i1 != 6) && (i1 != 7) && (i1 != 2)) {
      localHashMap.put("face_id", this.w);
    } else {
      localHashMap.put("face_id", this.x);
    }
    localHashMap.put("content_type", s.toString());
    String str1 = new DecimalFormat("0.00").format(this.B / 100.0F);
    String str2 = new DecimalFormat("0.00").format(this.C / 100.0F);
    localHashMap.put("beauty_value", str1);
    localHashMap.put("facial_value", str2);
    if (!TextUtils.isEmpty(this.m)) {
      localHashMap.put("filter_id", this.m);
    } else {
      localHashMap.put("filter_id", "none");
    }
    localHashMap.put("duration", AEBaseDataUtil.a(Long.valueOf(System.currentTimeMillis() - paramLong)));
    localHashMap.put("cameraId", AEBaseDataUtil.a(FlowCameraConstant.b));
    if (s.longValue() == 1L)
    {
      localHashMap.put("resolution", AEDashboardUtil.a.d());
      return localHashMap;
    }
    if (s.longValue() == 2L)
    {
      localHashMap.put("resolution", AEDashboardUtil.a.g());
      return localHashMap;
    }
    localHashMap.put("resolution", "none");
    return localHashMap;
  }
  
  public void c(int paramInt)
  {
    this.D = paramInt;
  }
  
  public void c(@Nullable String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      this.k = paramString;
    } else {
      this.k = "none";
    }
    this.j.put("fromuin", this.k);
  }
  
  public void c(boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("EditJson--HasCut=");
    localStringBuilder.append(paramBoolean);
    AEQLog.a("AEBaseReportParam", localStringBuilder.toString());
    if (paramBoolean)
    {
      this.o.put("cut", "1");
      return;
    }
    this.o.remove("cut");
  }
  
  public boolean c()
  {
    return this.l;
  }
  
  public HashMap<String, String> d(long paramLong)
  {
    HashMap localHashMap = new HashMap();
    int i1 = this.F;
    if ((i1 != 4) && (i1 != 5) && (i1 != 6) && (i1 != 7) && (i1 != 2)) {
      localHashMap.put("face_id", this.w);
    } else {
      localHashMap.put("face_id", this.x);
    }
    a(localHashMap);
    localHashMap.put("content_type", s.toString());
    Object localObject = new DecimalFormat("0.00").format(this.B / 100.0F);
    String str = new DecimalFormat("0.00").format(this.C / 100.0F);
    localHashMap.put("beauty_value", localObject);
    localHashMap.put("facial_value", str);
    boolean bool = TextUtils.isEmpty(this.m);
    str = "none";
    if (!bool) {
      localHashMap.put("filter_id", this.m);
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
    localHashMap.put("cameraId", AEBaseDataUtil.a(FlowCameraConstant.b));
    localHashMap.put("face_index", String.valueOf(this.y));
    localHashMap.put("face_from", this.z);
    localHashMap.put("face_tab", this.A);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(this.F);
    ((StringBuilder)localObject).append("");
    localHashMap.put("face_type", ((StringBuilder)localObject).toString());
    if (this.F == 7)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(this.x);
      ((StringBuilder)localObject).append(UserAction.getQIMEI());
      localHashMap.put("face_uin", ((StringBuilder)localObject).toString());
    }
    else
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(this.w);
      ((StringBuilder)localObject).append(UserAction.getQIMEI());
      localHashMap.put("face_uin", ((StringBuilder)localObject).toString());
    }
    localHashMap.put("preview_view_size", AEDashboardUtil.a.a());
    localHashMap.put("configed_preview_resolution", AEDashboardUtil.a.b());
    localHashMap.put("configed_capture_resolution", AEDashboardUtil.a.c());
    localHashMap.put("render_resolution", AEDashboardUtil.a.e());
    if (s.longValue() == 1L) {
      localHashMap.put("resolution", AEDashboardUtil.a.d());
    } else if (s.longValue() == 2L) {
      localHashMap.put("resolution", AEDashboardUtil.a.g());
    } else {
      localHashMap.put("resolution", "none");
    }
    if (s.longValue() == 1L)
    {
      if (AEDashboardUtil.a.p) {
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
    localObject = AEMaterialManager.o();
    if (localObject == null) {
      localObject = str;
    } else {
      localObject = ((AEMaterialMetaData)localObject).m;
    }
    localHashMap.put("watermark_id", localObject);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(a().k());
    ((StringBuilder)localObject).append("");
    localHashMap.put("is_ai_btn", ((StringBuilder)localObject).toString());
    localHashMap.put("face_info", a().j());
    return localHashMap;
  }
  
  public void d()
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
    this.j.put("network_type", String.valueOf(i1));
    UserAction.setLogAble(false, false);
  }
  
  public void d(int paramInt)
  {
    this.r = paramInt;
  }
  
  public void d(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[setExperimentID] experimentID = ");
    localStringBuilder.append(paramString);
    QLog.d("AEBaseReportParam", 4, localStringBuilder.toString());
    if ((paramString != null) && (!TextUtils.isEmpty(paramString)))
    {
      this.j.put("expirement_id", paramString);
      return;
    }
    this.j.put("expirement_id", "none");
  }
  
  public void d(boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("EditJson--speedChanged=");
    localStringBuilder.append(paramBoolean);
    AEQLog.a("AEBaseReportParam", localStringBuilder.toString());
    if (paramBoolean)
    {
      this.o.put("swipe", "1");
      return;
    }
    this.o.remove("swipe");
  }
  
  public HashMap<String, String> e()
  {
    this.j.put("cameraId", AEBaseDataUtil.a(FlowCameraConstant.b));
    return this.j;
  }
  
  public HashMap<String, String> e(long paramLong)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("video_duration", String.valueOf(paramLong / 1000L));
    return localHashMap;
  }
  
  public void e(@AEBaseReportParam.EditPicFrom int paramInt)
  {
    this.t = paramInt;
  }
  
  public void e(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[setTabExperimentID] experimentID = ");
    localStringBuilder.append(paramString);
    QLog.d("AEBaseReportParam", 4, localStringBuilder.toString());
    if (TextUtils.isEmpty(paramString))
    {
      this.j.put("tab_expirement_id", "none");
      return;
    }
    this.j.put("tab_expirement_id", paramString);
  }
  
  public void e(boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("EditJson--enhanced=");
    localStringBuilder.append(paramBoolean);
    AEQLog.a("AEBaseReportParam", localStringBuilder.toString());
    if (paramBoolean)
    {
      this.o.put("is_enhance", "1");
      return;
    }
    this.o.remove("is_enhance");
  }
  
  public String f()
  {
    return this.w;
  }
  
  public HashMap<String, String> f(long paramLong)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("duration", AEBaseDataUtil.a(Long.valueOf(paramLong)));
    return localHashMap;
  }
  
  public HashMap<String, String> f(boolean paramBoolean)
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
  
  public void f(int paramInt)
  {
    this.y = paramInt;
  }
  
  public void f(String paramString)
  {
    this.w = paramString;
  }
  
  public void g(int paramInt)
  {
    this.F = paramInt;
  }
  
  public void g(long paramLong)
  {
    L();
    this.J = paramLong;
    this.N = this.O;
    this.O = false;
  }
  
  public void g(String paramString)
  {
    this.h = paramString;
  }
  
  public void g(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.T = 2L;
      return;
    }
    this.T = 1L;
  }
  
  public boolean g()
  {
    return this.n;
  }
  
  public void h()
  {
    AEQLog.a("AEBaseReportParam", "EditJson--resetEditInfo");
    this.o.clear();
  }
  
  public void h(int paramInt)
  {
    this.B = paramInt;
  }
  
  public void h(long paramLong)
  {
    this.S = paramLong;
  }
  
  public void h(String paramString)
  {
    this.i = paramString;
  }
  
  public void h(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.U = 2L;
      return;
    }
    this.U = 1L;
  }
  
  public void i()
  {
    this.q = "";
  }
  
  public void i(int paramInt)
  {
    this.C = paramInt;
  }
  
  public void i(String paramString)
  {
    this.x = paramString;
  }
  
  public String j()
  {
    return this.q;
  }
  
  public HashMap<String, String> j(int paramInt)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("duration", "-1");
    localHashMap.put("content_type", String.valueOf(this.E.v));
    localHashMap.put("MD5", this.E.d);
    Object localObject1 = (String)this.E.e.get(Integer.valueOf(paramInt));
    boolean bool = TextUtils.isEmpty((CharSequence)localObject1);
    String str = "none";
    if (bool) {
      localObject1 = "none";
    }
    localHashMap.put("filter_id", localObject1);
    localObject1 = (Float)this.E.f.get(Integer.valueOf(paramInt));
    if (localObject1 == null) {
      localObject1 = "none";
    } else {
      localObject1 = String.valueOf(((Float)localObject1).intValue());
    }
    localHashMap.put("filter_value", localObject1);
    Object localObject2 = (String)this.E.a.get(paramInt);
    localObject1 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2)) {
      localObject1 = "none";
    }
    localHashMap.put("color_type", localObject1);
    localObject2 = (String)this.E.c.get(paramInt);
    localObject1 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2)) {
      localObject1 = "none";
    }
    localHashMap.put("ai_color_frame_states", localObject1);
    localObject2 = (String)this.E.b.get(paramInt);
    localObject1 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2)) {
      localObject1 = "none";
    }
    localHashMap.put("text_item_id", localObject1);
    localHashMap.put("music_id", "none");
    localHashMap.put("sound_type", "0");
    localHashMap.put("video_id", this.E.d);
    localObject2 = (Integer)this.E.g.get(Integer.valueOf(paramInt));
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = Integer.valueOf(-1);
    }
    localHashMap.put("text_count", String.valueOf(localObject1));
    localHashMap.put("face_id", this.w);
    a(localHashMap);
    localObject1 = AEMaterialManager.o();
    if (localObject1 == null) {
      localObject1 = str;
    } else {
      localObject1 = ((AEMaterialMetaData)localObject1).m;
    }
    localHashMap.put("watermark_id", localObject1);
    return localHashMap;
  }
  
  public void j(String paramString)
  {
    this.m = paramString;
  }
  
  public int k()
  {
    return this.r;
  }
  
  public HashMap<String, String> k(int paramInt)
  {
    HashMap localHashMap = new HashMap();
    String str2 = (String)this.E.h.get(Integer.valueOf(paramInt));
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = "none";
    }
    localHashMap.put("template_id", str1);
    str2 = (String)this.E.i.get(Integer.valueOf(paramInt));
    str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = "none";
    }
    localHashMap.put("text_id", str1);
    return localHashMap;
  }
  
  public void k(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("EditJson--sticker=");
    localStringBuilder.append(paramString);
    AEQLog.a("AEBaseReportParam", localStringBuilder.toString());
    if (!TextUtils.isEmpty(paramString))
    {
      this.o.put("sticker", paramString);
      return;
    }
    this.o.remove("sticker");
  }
  
  public HashMap<String, String> l(int paramInt)
  {
    HashMap localHashMap = new HashMap();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.E.v);
    localStringBuilder.append("");
    localHashMap.put("content_type", localStringBuilder.toString());
    localHashMap.put("MD5", this.E.d);
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramInt);
    localStringBuilder.append("");
    localHashMap.put("pic_count", localStringBuilder.toString());
    if (g.equals(Long.valueOf(this.E.v)))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.E.w);
      localStringBuilder.append("");
      localHashMap.put("video_num", localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.E.x);
      localStringBuilder.append("");
      localHashMap.put("video_duration", localStringBuilder.toString());
    }
    return localHashMap;
  }
  
  public void l()
  {
    this.t = 0;
  }
  
  public void l(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("EditJson--text=");
    localStringBuilder.append(paramString);
    AEQLog.a("AEBaseReportParam", localStringBuilder.toString());
    if (!TextUtils.isEmpty(paramString))
    {
      this.o.put("text", paramString);
      return;
    }
    this.o.remove("text");
  }
  
  public HashMap<String, String> m(int paramInt)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("pic_scale", String.valueOf(paramInt));
    return localHashMap;
  }
  
  public void m()
  {
    this.v = System.currentTimeMillis();
  }
  
  public void m(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("EditJson--mark=");
    localStringBuilder.append(paramString);
    AEQLog.a("AEBaseReportParam", localStringBuilder.toString());
    if (!TextUtils.isEmpty(paramString))
    {
      this.o.put("mark", paramString);
      return;
    }
    this.o.remove("mark");
  }
  
  public AEEditReportData n()
  {
    return this.E;
  }
  
  public HashMap<String, String> n(int paramInt)
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
  
  public void n(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("EditJson--graffiti=");
    localStringBuilder.append(paramString);
    AEQLog.a("AEBaseReportParam", localStringBuilder.toString());
    if (!TextUtils.isEmpty(paramString))
    {
      this.o.put("graffiti", paramString);
      return;
    }
    this.o.remove("graffiti");
  }
  
  public HashMap<String, String> o()
  {
    return b(this.x, "3");
  }
  
  public void o(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("EditJson--music=");
    localStringBuilder.append(paramString);
    AEQLog.a("AEBaseReportParam", localStringBuilder.toString());
    if (!TextUtils.isEmpty(paramString))
    {
      this.o.put("music", paramString);
      return;
    }
    this.o.remove("music");
  }
  
  public HashMap<String, String> p()
  {
    return b(this.x, this.z);
  }
  
  public void p(String paramString)
  {
    this.q = paramString;
  }
  
  public HashMap<String, String> q()
  {
    return b(this.x, this.z);
  }
  
  public void q(String paramString)
  {
    this.z = paramString;
  }
  
  public HashMap<String, String> r()
  {
    HashMap localHashMap = new HashMap(1);
    localHashMap.put("face_id", AECameraPrefsUtil.a().b("camera_ad_op_id", "", 4));
    return localHashMap;
  }
  
  public void r(String paramString)
  {
    this.A = paramString;
  }
  
  public HashMap<String, String> s()
  {
    HashMap localHashMap = new HashMap(2);
    localHashMap.put("face_id", this.w);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.D);
    localStringBuilder.append("");
    localHashMap.put("is_sort_icon", localStringBuilder.toString());
    a(localHashMap);
    return localHashMap;
  }
  
  public HashMap<String, String> s(String paramString)
  {
    return b(paramString, this.z);
  }
  
  public HashMap<String, String> t()
  {
    HashMap localHashMap = new HashMap(1);
    localHashMap.put("face_id", this.w);
    a(localHashMap);
    return localHashMap;
  }
  
  public HashMap<String, String> t(String paramString)
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
  
  public HashMap<String, String> u()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("duration", AEBaseDataUtil.a(Long.valueOf(ac())));
    return localHashMap;
  }
  
  public HashMap<String, String> u(String paramString)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("filter_id", paramString);
    return localHashMap;
  }
  
  public HashMap<String, String> v()
  {
    Object localObject;
    if (TextUtils.isEmpty(this.I))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(QQStoryContext.k().getAccount());
      ((StringBuilder)localObject).append(AEBaseDataUtil.a());
      localObject = MD5Utils.toMD5(((StringBuilder)localObject).toString());
    }
    else
    {
      localObject = this.I;
    }
    return a((String)localObject, 1, "-1");
  }
  
  public HashMap<String, String> v(String paramString)
  {
    return b(paramString, "3");
  }
  
  public HashMap<String, String> w()
  {
    HashMap localHashMap = a().v();
    if (localHashMap != null) {
      localHashMap.remove("edit_json");
    }
    return localHashMap;
  }
  
  public HashMap<String, String> w(String paramString)
  {
    HashMap localHashMap = new HashMap(2);
    localHashMap.put("face_id", paramString);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append(UserAction.getQIMEI());
    localHashMap.put("face_uin", localStringBuilder.toString());
    return localHashMap;
  }
  
  public HashMap<String, String> x()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("face_id", this.w);
    localHashMap.put("face_tab", this.A);
    localHashMap.put("face_index", String.valueOf(this.y));
    localHashMap.put("face_uin", this.G);
    a(localHashMap);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(this.t);
    ((StringBuilder)localObject).append("");
    localHashMap.put("pic_from", ((StringBuilder)localObject).toString());
    localObject = new JSONObject(this.o).toString();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getDownloadBtnParam---editJsonStr=");
    localStringBuilder.append((String)localObject);
    QLog.d("AEBaseReportParam", 1, localStringBuilder.toString());
    localHashMap.put("edit_json", localObject);
    return localHashMap;
  }
  
  public HashMap<String, String> x(String paramString)
  {
    return AEBaseDataUtil.a(v(), b(paramString, "3"));
  }
  
  public HashMap<String, String> y()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("content_type", s.toString());
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.t);
    localStringBuilder.append("");
    localHashMap.put("pic_from", localStringBuilder.toString());
    return localHashMap;
  }
  
  public HashMap<String, String> y(String paramString)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("content_type", String.valueOf(this.E.v));
    localHashMap.put("filter_id", paramString);
    return localHashMap;
  }
  
  public HashMap<String, String> z()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("duration", String.valueOf(this.E.t));
    localHashMap.put("content_type", String.valueOf(this.E.v));
    localHashMap.put("MD5", this.E.d);
    Object localObject = this.E.l;
    boolean bool = TextUtils.isEmpty((CharSequence)localObject);
    String str1 = "none";
    if (bool) {
      localObject = "none";
    }
    localHashMap.put("filter_id", localObject);
    localHashMap.put("filter_value", String.valueOf((int)this.E.m));
    localHashMap.put("music_id", this.E.n);
    String str2 = (String)this.E.a.get(0);
    localObject = str2;
    if (TextUtils.isEmpty(str2)) {
      localObject = "none";
    }
    localHashMap.put("color_type", localObject);
    str2 = (String)this.E.b.get(0);
    localObject = str2;
    if (TextUtils.isEmpty(str2)) {
      localObject = "none";
    }
    localHashMap.put("text_item_id", localObject);
    localHashMap.put("sound_type", String.valueOf(this.E.o));
    localHashMap.put("text_count", String.valueOf(this.E.s));
    localHashMap.put("music_list", this.E.z);
    localHashMap.put("video_id", this.E.d);
    localHashMap.put("music_common_info", this.E.y);
    localHashMap.put("lyric_status", String.valueOf(this.E.A));
    if (this.E.p) {
      localObject = "1";
    } else {
      localObject = "0";
    }
    localHashMap.put("is_recommend", localObject);
    localHashMap.put("recommend_index", String.valueOf(this.E.q));
    localHashMap.put("music_duration", String.valueOf(this.E.r));
    localHashMap.put("video_duration", String.valueOf(this.E.t));
    localHashMap.put("video_source", String.valueOf(this.E.u));
    localHashMap.put("face_id", this.w);
    a(localHashMap);
    localHashMap.put("change_speed_type", String.valueOf(this.E.E));
    localObject = AEMaterialManager.o();
    if (localObject == null) {
      localObject = str1;
    } else {
      localObject = ((AEMaterialMetaData)localObject).m;
    }
    localHashMap.put("watermark_id", localObject);
    return localHashMap;
  }
  
  public void z(String paramString)
  {
    this.V = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.report.AEBaseReportParam
 * JD-Core Version:    0.7.0.1
 */