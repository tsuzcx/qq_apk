import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.superplayer.api.SuperPlayerMgr;
import java.util.HashMap;

public class bbwd
{
  public int a;
  public long a;
  public bbwg a;
  public String a;
  public boolean a;
  public int b;
  public long b;
  public String b;
  public boolean b;
  public int c;
  public long c;
  public String c;
  public boolean c;
  public int d;
  public long d;
  public String d;
  public int e;
  public long e;
  public String e;
  public int f;
  public long f;
  public String f;
  public int g;
  public long g;
  public String g;
  public int h;
  public long h;
  private String h;
  public int i;
  public long i;
  private String i;
  public int j;
  public long j;
  public int k;
  public long k;
  public int l;
  public long l;
  public int m;
  public long m;
  private int n;
  public long n;
  private int o;
  private int p;
  private int q;
  
  public bbwd()
  {
    this.jdField_f_of_type_Int = -1;
    this.jdField_g_of_type_Int = -1;
    this.jdField_h_of_type_Int = -1;
    this.jdField_i_of_type_Int = -1;
  }
  
  public void a(boolean paramBoolean)
  {
    int i2 = 1;
    if ((paramBoolean) && (!this.jdField_a_of_type_Boolean)) {
      return;
    }
    this.jdField_e_of_type_Long = System.currentTimeMillis();
    this.jdField_a_of_type_JavaLangString = SuperPlayerMgr.getSDKVersion();
    this.jdField_b_of_type_Boolean = paramBoolean;
    if (this.jdField_a_of_type_Bbwg != null)
    {
      this.jdField_h_of_type_JavaLangString = this.jdField_a_of_type_Bbwg.jdField_c_of_type_JavaLangString;
      this.jdField_n_of_type_Int = this.jdField_a_of_type_Bbwg.jdField_a_of_type_Int;
      if (!this.jdField_a_of_type_Bbwg.jdField_b_of_type_Boolean) {
        break label782;
      }
      i1 = 0;
      this.p = i1;
      if (!this.jdField_a_of_type_Bbwg.jdField_b_of_type_Boolean) {
        break label787;
      }
      this.jdField_i_of_type_JavaLangString = this.jdField_a_of_type_Bbwg.jdField_a_of_type_JavaLangString;
      label100:
      if (!this.jdField_a_of_type_Bbwg.jdField_a_of_type_Boolean) {
        break label824;
      }
      i1 = 1;
      label112:
      this.o = i1;
      if (!this.jdField_a_of_type_Bbwg.jdField_c_of_type_Boolean) {
        break label829;
      }
    }
    label782:
    label787:
    label824:
    label829:
    for (int i1 = i2;; i1 = 0)
    {
      this.q = i1;
      this.jdField_m_of_type_Long = this.jdField_a_of_type_Bbwg.jdField_d_of_type_Long;
      if ((this.jdField_d_of_type_Long > 0L) && (this.jdField_e_of_type_Long > 0L)) {
        this.jdField_f_of_type_Long = (this.jdField_e_of_type_Long - this.jdField_d_of_type_Long);
      }
      if ((this.jdField_g_of_type_Long > 0L) && (this.jdField_h_of_type_Long > 0L)) {
        this.jdField_a_of_type_Long = (this.jdField_h_of_type_Long - this.jdField_g_of_type_Long);
      }
      HashMap localHashMap = new HashMap();
      localHashMap.put("param_playerVer", this.jdField_a_of_type_JavaLangString);
      localHashMap.put("param_isSuccessed", String.valueOf(this.jdField_b_of_type_Boolean));
      localHashMap.put("param_errCode", String.valueOf(this.jdField_c_of_type_Int));
      localHashMap.put("param_errModule", String.valueOf(this.jdField_b_of_type_Int));
      localHashMap.put("param_errType", String.valueOf(this.jdField_a_of_type_Int));
      localHashMap.put("param_errInfo", this.jdField_b_of_type_JavaLangString);
      localHashMap.put("param_fileID", this.jdField_h_of_type_JavaLangString);
      localHashMap.put("param_playType", String.valueOf(this.p));
      localHashMap.put("param_isLoop", String.valueOf(this.o));
      localHashMap.put("param_isMute", String.valueOf(this.q));
      localHashMap.put("param_busiType", bbwf.a(this.jdField_n_of_type_Int));
      localHashMap.put("param_playUrl", this.jdField_i_of_type_JavaLangString);
      localHashMap.put("param_firstBuffConsume", String.valueOf(this.jdField_a_of_type_Long));
      localHashMap.put("param_buffCount", String.valueOf(this.jdField_b_of_type_Long));
      localHashMap.put("param_buffTotalConsume", String.valueOf(this.jdField_c_of_type_Long));
      localHashMap.put("param_skipLotFrame", String.valueOf(this.jdField_c_of_type_Boolean));
      localHashMap.put("param_skipFramesCount", String.valueOf(this.jdField_d_of_type_Int));
      localHashMap.put("param_playerType", String.valueOf(this.jdField_e_of_type_Int));
      localHashMap.put("param_firsDecode", String.valueOf(this.jdField_f_of_type_Int));
      localHashMap.put("param_lastDecode", String.valueOf(this.jdField_g_of_type_Int));
      localHashMap.put("param_haStrategy", String.valueOf(this.jdField_h_of_type_Int));
      localHashMap.put("param_haErro", String.valueOf(this.jdField_i_of_type_Int));
      localHashMap.put("param_videoDuration", String.valueOf(this.jdField_i_of_type_Long));
      localHashMap.put("param_videoCodec", this.jdField_c_of_type_JavaLangString);
      localHashMap.put("param_videoProfile", this.jdField_d_of_type_JavaLangString);
      localHashMap.put("param_videoBitRate", String.valueOf(this.jdField_j_of_type_Long));
      localHashMap.put("param_audioCodec", this.jdField_e_of_type_JavaLangString);
      localHashMap.put("param_audioProfile", this.jdField_f_of_type_JavaLangString);
      localHashMap.put("param_audioSampleRate", String.valueOf(this.jdField_l_of_type_Long));
      localHashMap.put("param_audioChannels", String.valueOf(this.jdField_m_of_type_Int));
      localHashMap.put("param_audioBitRate", String.valueOf(this.jdField_k_of_type_Long));
      localHashMap.put("param_totalPlayTime", String.valueOf(this.jdField_f_of_type_Long));
      localHashMap.put("param_fileSize", String.valueOf(this.jdField_m_of_type_Long));
      localHashMap.put("param_decodeFFCost", String.valueOf(this.jdField_n_of_type_Long));
      localHashMap.put("param_videoHeight", String.valueOf(this.jdField_l_of_type_Int));
      localHashMap.put("param_videoWidth", String.valueOf(this.jdField_k_of_type_Int));
      localHashMap.put("param_containerFormat", this.jdField_g_of_type_JavaLangString);
      localHashMap.put("param_ismediacodec", String.valueOf(this.jdField_j_of_type_Int));
      axrn.a(BaseApplication.getContext()).a(null, "actVideoSDKPlay", this.jdField_b_of_type_Boolean, 0L, 0L, localHashMap, "");
      return;
      i1 = 1;
      break;
      if ((this.jdField_a_of_type_Bbwg.jdField_a_of_type_ArrayOfJavaLangString == null) || (this.jdField_a_of_type_Bbwg.jdField_a_of_type_ArrayOfJavaLangString.length <= 0)) {
        break label100;
      }
      this.jdField_i_of_type_JavaLangString = this.jdField_a_of_type_Bbwg.jdField_a_of_type_ArrayOfJavaLangString[0];
      break label100;
      i1 = 0;
      break label112;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     bbwd
 * JD-Core Version:    0.7.0.1
 */