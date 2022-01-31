import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.AsyncTask;
import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.bless.BlessSelectMemberActivity;
import com.tencent.mobileqq.activity.shortvideo.SendVideoActivity;
import com.tencent.mobileqq.data.MessageForBlessPTV;
import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoActivity;
import java.util.concurrent.atomic.AtomicLong;

public class bkps
  extends AsyncTask<Void, Void, Integer>
{
  private static AtomicLong jdField_a_of_type_JavaUtilConcurrentAtomicAtomicLong = new AtomicLong(0L);
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private ProgressDialog jdField_a_of_type_AndroidAppProgressDialog;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private biih jdField_a_of_type_Biih;
  private bkpt jdField_a_of_type_Bkpt;
  private blck jdField_a_of_type_Blck = new blck();
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean;
  private String c;
  private String d;
  private String e;
  
  public bkps(bkpt parambkpt, boolean paramBoolean1, boolean paramBoolean2, biih parambiih)
  {
    this.jdField_e_of_type_JavaLangString = "";
    this.jdField_a_of_type_Bkpt = parambkpt;
    this.jdField_a_of_type_Long = jdField_a_of_type_JavaUtilConcurrentAtomicAtomicLong.getAndIncrement();
    this.jdField_e_of_type_JavaLangString = ("MediaCodecSendTask_[mSessionId=" + this.jdField_a_of_type_Long + "]");
    this.jdField_a_of_type_Boolean = paramBoolean1;
    this.jdField_b_of_type_Boolean = paramBoolean2;
    this.jdField_a_of_type_Biih = parambiih;
  }
  
  private int a()
  {
    this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_Bkpt.jdField_a_of_type_JavaLangString;
    a("cacheDir=" + this.jdField_a_of_type_JavaLangString, null);
    if (!bbdx.b(this.jdField_a_of_type_Bkpt.jdField_c_of_type_JavaLangString))
    {
      a("video file empty! path=" + this.jdField_a_of_type_Bkpt.jdField_c_of_type_JavaLangString, null);
      return -300;
    }
    if (!bbdx.b(this.jdField_a_of_type_Bkpt.jdField_f_of_type_JavaLangString))
    {
      a("thumb file empty! path=" + this.jdField_a_of_type_Bkpt.jdField_f_of_type_JavaLangString, null);
      return -301;
    }
    Intent localIntent = this.jdField_a_of_type_Bkpt.jdField_a_of_type_AndroidAppActivity.getIntent();
    this.jdField_b_of_type_Int = localIntent.getIntExtra("param_entrance", 0);
    this.jdField_c_of_type_JavaLangString = localIntent.getStringExtra("bless_ptv_mp4_path");
    this.jdField_d_of_type_JavaLangString = localIntent.getStringExtra("fake_id");
    int i = blcj.a(this.jdField_a_of_type_Bkpt.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_Blck);
    if (i != 0)
    {
      a("MediaMetadataUtils: errcode=" + i, null);
      return i;
    }
    i = this.jdField_a_of_type_Blck.a[3];
    this.jdField_a_of_type_Int = (((int)bkly.a(this.jdField_a_of_type_Bkpt.jdField_l_of_type_Int, i) + 500) / 1000);
    if ((this.jdField_a_of_type_Bkpt.jdField_c_of_type_Int <= 0) || (this.jdField_a_of_type_Bkpt.jdField_d_of_type_Int <= 0))
    {
      i = this.jdField_a_of_type_Blck.a[2];
      this.jdField_a_of_type_Bkpt.jdField_c_of_type_Int = this.jdField_a_of_type_Blck.a[0];
      this.jdField_a_of_type_Bkpt.jdField_d_of_type_Int = this.jdField_a_of_type_Blck.a[1];
      if ((i == 90) || (i == 270))
      {
        this.jdField_a_of_type_Bkpt.jdField_c_of_type_Int = this.jdField_a_of_type_Bkpt.jdField_d_of_type_Int;
        this.jdField_a_of_type_Bkpt.jdField_d_of_type_Int = this.jdField_a_of_type_Blck.a[0];
      }
    }
    return b();
  }
  
  private void a()
  {
    a("cancleProgressDailog", null);
    try
    {
      if (this.jdField_a_of_type_AndroidAppProgressDialog != null)
      {
        this.jdField_a_of_type_AndroidAppProgressDialog.cancel();
        this.jdField_a_of_type_AndroidAppProgressDialog = null;
      }
      return;
    }
    catch (Exception localException) {}
  }
  
  private void a(Context paramContext, int paramInt)
  {
    a("showProgressDialog", null);
    try
    {
      if (this.jdField_a_of_type_AndroidAppProgressDialog != null) {
        a();
      }
      for (;;)
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(paramInt);
        if (this.jdField_a_of_type_AndroidAppProgressDialog.isShowing()) {
          break;
        }
        this.jdField_a_of_type_AndroidAppProgressDialog.show();
        return;
        this.jdField_a_of_type_AndroidAppProgressDialog = new ProgressDialog(paramContext, 2131755791);
        this.jdField_a_of_type_AndroidAppProgressDialog.setCancelable(true);
        this.jdField_a_of_type_AndroidAppProgressDialog.setCanceledOnTouchOutside(false);
        this.jdField_a_of_type_AndroidAppProgressDialog.show();
        this.jdField_a_of_type_AndroidAppProgressDialog.setContentView(2131559386);
        this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidAppProgressDialog.findViewById(2131371557));
      }
      return;
    }
    catch (Throwable paramContext)
    {
      a("showProgressDialog", paramContext);
    }
  }
  
  private void a(String paramString, Throwable paramThrowable)
  {
    if (QLog.isColorLevel())
    {
      if (paramThrowable != null) {
        QLog.d(this.jdField_e_of_type_JavaLangString, 2, "[@] " + paramString, paramThrowable);
      }
    }
    else {
      return;
    }
    QLog.d(this.jdField_e_of_type_JavaLangString, 2, "[@] " + paramString);
  }
  
  /* Error */
  private int b()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 45	bkps:jdField_a_of_type_Bkpt	Lbkpt;
    //   4: getfield 98	bkpt:jdField_f_of_type_JavaLangString	Ljava/lang/String;
    //   7: aload_0
    //   8: getfield 45	bkps:jdField_a_of_type_Bkpt	Lbkpt;
    //   11: getfield 231	bkpt:jdField_a_of_type_Double	D
    //   14: aload_0
    //   15: getfield 45	bkps:jdField_a_of_type_Bkpt	Lbkpt;
    //   18: getfield 233	bkpt:jdField_b_of_type_Double	D
    //   21: invokestatic 238	bbef:a	(Ljava/lang/String;DD)Z
    //   24: pop
    //   25: new 240	java/io/File
    //   28: dup
    //   29: aload_0
    //   30: getfield 45	bkps:jdField_a_of_type_Bkpt	Lbkpt;
    //   33: getfield 98	bkpt:jdField_f_of_type_JavaLangString	Ljava/lang/String;
    //   36: invokespecial 243	java/io/File:<init>	(Ljava/lang/String;)V
    //   39: astore_2
    //   40: new 245	java/io/FileInputStream
    //   43: dup
    //   44: aload_0
    //   45: getfield 45	bkps:jdField_a_of_type_Bkpt	Lbkpt;
    //   48: getfield 98	bkpt:jdField_f_of_type_JavaLangString	Ljava/lang/String;
    //   51: invokespecial 246	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   54: astore_1
    //   55: aload_0
    //   56: aload_1
    //   57: aload_2
    //   58: invokevirtual 249	java/io/File:length	()J
    //   61: invokestatic 255	com/tencent/qphone/base/util/MD5:toMD5Byte	(Ljava/io/InputStream;J)[B
    //   64: invokestatic 261	com/qq/taf/jce/HexUtil:bytes2HexStr	([B)Ljava/lang/String;
    //   67: putfield 263	bkps:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   70: aload_1
    //   71: ifnull +7 -> 78
    //   74: aload_1
    //   75: invokevirtual 266	java/io/FileInputStream:close	()V
    //   78: aload_0
    //   79: getfield 263	bkps:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   82: invokestatic 272	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   85: ifeq +23 -> 108
    //   88: aload_0
    //   89: ldc_w 274
    //   92: aconst_null
    //   93: invokespecial 86	bkps:a	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   96: sipush -302
    //   99: ireturn
    //   100: astore_1
    //   101: aload_1
    //   102: invokevirtual 277	java/io/IOException:printStackTrace	()V
    //   105: goto -27 -> 78
    //   108: aload_0
    //   109: getfield 263	bkps:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   112: ldc_w 279
    //   115: invokestatic 284	dov/com/tencent/mobileqq/shortvideo/ShortVideoUtils:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   118: astore_1
    //   119: aload_0
    //   120: getfield 45	bkps:jdField_a_of_type_Bkpt	Lbkpt;
    //   123: getfield 98	bkpt:jdField_f_of_type_JavaLangString	Ljava/lang/String;
    //   126: aload_1
    //   127: invokestatic 287	bbdx:c	(Ljava/lang/String;Ljava/lang/String;)Z
    //   130: ifeq +13 -> 143
    //   133: aload_0
    //   134: getfield 45	bkps:jdField_a_of_type_Bkpt	Lbkpt;
    //   137: aload_1
    //   138: putfield 98	bkpt:jdField_f_of_type_JavaLangString	Ljava/lang/String;
    //   141: iconst_0
    //   142: ireturn
    //   143: aload_1
    //   144: invokestatic 93	bbdx:b	(Ljava/lang/String;)Z
    //   147: ifne -6 -> 141
    //   150: aload_0
    //   151: new 53	java/lang/StringBuilder
    //   154: dup
    //   155: invokespecial 54	java/lang/StringBuilder:<init>	()V
    //   158: ldc_w 289
    //   161: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   164: aload_0
    //   165: getfield 45	bkps:jdField_a_of_type_Bkpt	Lbkpt;
    //   168: getfield 98	bkpt:jdField_f_of_type_JavaLangString	Ljava/lang/String;
    //   171: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   174: ldc_w 291
    //   177: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   180: aload_1
    //   181: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   184: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   187: aconst_null
    //   188: invokespecial 86	bkps:a	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   191: sipush -301
    //   194: ireturn
    //   195: astore_1
    //   196: aconst_null
    //   197: astore_1
    //   198: goto -128 -> 70
    //   201: astore_2
    //   202: goto -132 -> 70
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	205	0	this	bkps
    //   54	21	1	localFileInputStream	java.io.FileInputStream
    //   100	2	1	localIOException	java.io.IOException
    //   118	63	1	str	String
    //   195	1	1	localFileNotFoundException1	java.io.FileNotFoundException
    //   197	1	1	localObject	java.lang.Object
    //   39	19	2	localFile	java.io.File
    //   201	1	2	localFileNotFoundException2	java.io.FileNotFoundException
    // Exception table:
    //   from	to	target	type
    //   74	78	100	java/io/IOException
    //   40	55	195	java/io/FileNotFoundException
    //   55	70	201	java/io/FileNotFoundException
  }
  
  protected Integer a(Void... paramVarArgs)
  {
    long l = System.currentTimeMillis();
    int i = a();
    if (i != 0) {
      return Integer.valueOf(i);
    }
    a("doInBackground total:time=" + (System.currentTimeMillis() - l) / 1000.0D, null);
    return Integer.valueOf(0);
  }
  
  void a(Intent paramIntent)
  {
    paramIntent.putExtra("mediacodec_encode_enable", true);
    paramIntent.putExtra("file_video_source_dir", this.jdField_a_of_type_JavaLangString);
    paramIntent.putExtra("thumbfile_send_path", this.jdField_a_of_type_Bkpt.jdField_f_of_type_JavaLangString);
    paramIntent.putExtra("thumbfile_send_width", this.jdField_a_of_type_Bkpt.jdField_c_of_type_Int);
    paramIntent.putExtra("thumbfile_send_height", this.jdField_a_of_type_Bkpt.jdField_d_of_type_Int);
    paramIntent.putExtra("thumbfile_md5", this.jdField_b_of_type_JavaLangString);
    paramIntent.putExtra("file_send_duration", this.jdField_a_of_type_Int);
    paramIntent.putExtra("video_mood_content", this.jdField_a_of_type_Bkpt.jdField_g_of_type_JavaLangString);
    paramIntent.putExtra("video_mood_priv", this.jdField_a_of_type_Bkpt.jdField_e_of_type_Int);
    paramIntent.putExtra("video_mood_privUinList", this.jdField_a_of_type_Bkpt.jdField_a_of_type_JavaUtilArrayList);
    paramIntent.putExtra("enable_edit_video", this.jdField_a_of_type_Bkpt.jdField_a_of_type_Boolean);
    paramIntent.putExtra("video_topic_id", this.jdField_a_of_type_Bkpt.jdField_i_of_type_JavaLangString);
    paramIntent.putExtra("video_topic_sync_qzone", this.jdField_a_of_type_Bkpt.jdField_b_of_type_Boolean);
    paramIntent.putExtra("video_new_fake_vid", this.jdField_a_of_type_Bkpt.jdField_j_of_type_JavaLangString);
    paramIntent.putExtra("video_sync_to_story", this.jdField_a_of_type_Bkpt.jdField_c_of_type_Boolean);
    paramIntent.putExtra("extra_key_font_id", this.jdField_a_of_type_Bkpt.jdField_f_of_type_Int);
    paramIntent.putExtra("extra_key_font_format_type", this.jdField_a_of_type_Bkpt.jdField_g_of_type_Int);
    paramIntent.putExtra("extra_key_font_url", this.jdField_a_of_type_Bkpt.jdField_h_of_type_JavaLangString);
    paramIntent.putExtra("sv_encode_max_bitrate", axim.r);
    paramIntent.putExtra("sv_encode_min_bitrate", axim.s);
    if ((this.jdField_a_of_type_Bkpt.jdField_i_of_type_Int > 0) && (this.jdField_a_of_type_Bkpt.jdField_h_of_type_Int > 0)) {
      blbz.a("sv_filter_mediacodec_fps", this.jdField_a_of_type_Bkpt.jdField_h_of_type_Int * 1000 / this.jdField_a_of_type_Bkpt.jdField_i_of_type_Int);
    }
    paramIntent.putExtra("dynamic_text", this.jdField_a_of_type_Bkpt.jdField_k_of_type_JavaLangString);
    String str = this.jdField_a_of_type_Bkpt.jdField_a_of_type_AndroidAppActivity.getIntent().getStringExtra("forward_source_to_qzone");
    if (!TextUtils.isEmpty(str)) {
      paramIntent.putExtra("forward_source_to_qzone", str);
    }
    if (!TextUtils.isEmpty(this.jdField_a_of_type_Bkpt.jdField_l_of_type_JavaLangString)) {
      paramIntent.putExtra("widgetinfo", this.jdField_a_of_type_Bkpt.jdField_l_of_type_JavaLangString);
    }
  }
  
  protected void a(Integer paramInteger)
  {
    int j = 0;
    a();
    if (((this.jdField_a_of_type_Bkpt.jdField_a_of_type_AndroidAppActivity instanceof SplashActivity)) || ((this.jdField_a_of_type_Bkpt.jdField_a_of_type_AndroidAppActivity instanceof EditVideoActivity))) {}
    for (int i = 0;; i = 1)
    {
      if (paramInteger.intValue() == 0)
      {
        paramInteger = new Intent();
        a(paramInteger);
        if (this.jdField_a_of_type_Bkpt.jdField_a_of_type_Ahua != null)
        {
          this.jdField_a_of_type_Bkpt.jdField_a_of_type_Ahua.a(this.jdField_a_of_type_Bkpt.jdField_a_of_type_AndroidAppActivity, paramInteger);
          if (i != 0) {
            this.jdField_a_of_type_Bkpt.jdField_a_of_type_AndroidAppActivity.finish();
          }
          this.jdField_a_of_type_Bkpt.jdField_a_of_type_AndroidAppActivity = null;
          return;
        }
        paramInteger.putExtra("uin", this.jdField_a_of_type_Bkpt.jdField_d_of_type_JavaLangString);
        paramInteger.putExtra("uintype", this.jdField_a_of_type_Bkpt.jdField_b_of_type_Int);
        paramInteger.putExtra("troop_uin", this.jdField_a_of_type_Bkpt.jdField_e_of_type_JavaLangString);
        paramInteger.putExtra("file_send_business_type", 2);
        a("onPostExecute(), MediaCodecSendTask is to start  SendVideoActivity,mVideoCacheDir = " + this.jdField_a_of_type_JavaLangString, null);
        paramInteger.putExtra("ab_test_send_btn_click_time", this.jdField_a_of_type_Bkpt.jdField_a_of_type_AndroidAppActivity.getIntent().getLongExtra("ab_test_send_btn_click_time", 0L));
        paramInteger.putExtra("video_send_aio_key_is_qim", this.jdField_a_of_type_Bkpt.jdField_d_of_type_Boolean);
        if (QLog.isColorLevel()) {
          QLog.d("MediaCodecSendTask", 2, "ISQIM MediaCodecSendTask#onPostExecute, isQIM = " + this.jdField_a_of_type_Bkpt.jdField_d_of_type_Boolean);
        }
        paramInteger.putExtra("param_key_redbag_type", this.jdField_a_of_type_Bkpt.jdField_j_of_type_Int);
        paramInteger.putExtra("special_video_type", this.jdField_a_of_type_Bkpt.jdField_k_of_type_Int);
        if ((this.jdField_a_of_type_Bkpt.jdField_d_of_type_JavaLangString != null) && (this.jdField_a_of_type_Bkpt.jdField_d_of_type_JavaLangString.equals(MessageForBlessPTV.BLESS_REQ_UIN)))
        {
          paramInteger.putExtra("bless_ptv_mp4_path", this.jdField_c_of_type_JavaLangString);
          paramInteger.setClass(this.jdField_a_of_type_Bkpt.jdField_a_of_type_AndroidAppActivity, BlessSelectMemberActivity.class);
          paramInteger.putExtra("param_type", 9003);
          paramInteger.putExtra("param_only_friends", true);
          paramInteger.putExtra("param_donot_need_contacts", true);
          paramInteger.putExtra("param_title", this.jdField_a_of_type_Bkpt.jdField_a_of_type_AndroidAppActivity.getString(2131690514));
          paramInteger.putExtra("param_done_button_wording", this.jdField_a_of_type_Bkpt.jdField_a_of_type_AndroidAppActivity.getString(2131691035));
          paramInteger.putExtra("param_exit_animation", 1);
          paramInteger.putExtra("param_entrance", this.jdField_b_of_type_Int);
          paramInteger.putExtra("param_blesstype", 2);
          paramInteger.putExtra("encode_type", 1);
          paramInteger.putExtra("fake_id", this.jdField_d_of_type_JavaLangString);
          this.jdField_a_of_type_Bkpt.jdField_a_of_type_AndroidAppActivity.startActivityForResult(paramInteger, 10007);
          i = j;
          j = i;
          label488:
          if (this.jdField_a_of_type_Biih == null) {
            break label629;
          }
          this.jdField_a_of_type_Biih.a();
        }
      }
      for (;;)
      {
        this.jdField_a_of_type_Bkpt.jdField_a_of_type_AndroidAppActivity = null;
        return;
        paramInteger.setClass(this.jdField_a_of_type_Bkpt.jdField_a_of_type_AndroidAppActivity, SendVideoActivity.class);
        paramInteger.putExtra("src_edited", this.jdField_b_of_type_Boolean);
        this.jdField_a_of_type_Bkpt.jdField_a_of_type_AndroidAppActivity.startActivity(paramInteger);
        break;
        bcql.a(this.jdField_a_of_type_Bkpt.jdField_a_of_type_AndroidAppActivity, ajya.a(2131706502), 0).b(this.jdField_a_of_type_Bkpt.jdField_a_of_type_AndroidAppActivity.getResources().getDimensionPixelSize(2131298865));
        j = i;
        if (!QLog.isColorLevel()) {
          break label488;
        }
        QLog.d(this.jdField_e_of_type_JavaLangString, 2, "" + paramInteger);
        j = i;
        break label488;
        label629:
        if (j != 0) {
          this.jdField_a_of_type_Bkpt.jdField_a_of_type_AndroidAppActivity.finish();
        }
      }
    }
  }
  
  protected void onPreExecute()
  {
    a(this.jdField_a_of_type_Bkpt.jdField_a_of_type_AndroidAppActivity, 2131695126);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bkps
 * JD-Core Version:    0.7.0.1
 */