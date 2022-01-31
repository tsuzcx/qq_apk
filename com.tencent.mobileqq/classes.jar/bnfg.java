import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Message;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import dov.com.tencent.mobileqq.activity.richmedia.view.ExtendEditText;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class bnfg
  extends bmnh
  implements View.OnClickListener
{
  private int jdField_a_of_type_Int;
  private View jdField_a_of_type_AndroidViewView;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private CheckBox jdField_a_of_type_AndroidWidgetCheckBox;
  public RelativeLayout a;
  private bnfs jdField_a_of_type_Bnfs;
  private ExtendEditText jdField_a_of_type_DovComTencentMobileqqActivityRichmediaViewExtendEditText;
  private String jdField_a_of_type_JavaLangString = bkah.a(1);
  private boolean jdField_a_of_type_Boolean;
  
  public bnfg(@NonNull bnfs parambnfs)
  {
    super(parambnfs);
    this.jdField_a_of_type_Bnfs = parambnfs;
  }
  
  private void a(long paramLong) {}
  
  public static boolean a(int paramInt)
  {
    return (paramInt == 16) || (paramInt == 128);
  }
  
  private boolean a(String paramString)
  {
    try
    {
      long l = Long.valueOf(paramString).longValue();
      a(l);
      paramString = bjjo.a(l);
      if (paramString == null) {
        return false;
      }
      this.jdField_a_of_type_Bnfs.jdField_d_of_type_Int = paramString.jdField_a_of_type_Int;
      this.jdField_a_of_type_Bnfs.jdField_e_of_type_Int = paramString.b;
      this.jdField_a_of_type_Bnfs.jdField_d_of_type_JavaLangString = paramString.jdField_a_of_type_JavaLangString;
      int i = this.jdField_a_of_type_Bnfs.jdField_d_of_type_Int;
      if (i > 0) {
        return true;
      }
    }
    catch (Throwable paramString)
    {
      QLog.e("loadDefaultFontData", 1, "loadDefaultFontData Throwable, errMsg = " + paramString.getMessage());
    }
    return false;
  }
  
  private void j()
  {
    RelativeLayout localRelativeLayout1 = (RelativeLayout)a(2131365609);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)LayoutInflater.from(a()).inflate(2131562056, localRelativeLayout1, false));
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, aepi.a(50.0F, a()));
    RelativeLayout localRelativeLayout2 = this.jdField_a_of_type_AndroidWidgetRelativeLayout;
    if (this.jdField_a_of_type_Bnfs.i)
    {
      i = 0;
      localRelativeLayout2.setVisibility(i);
      localLayoutParams.addRule(12);
      if (bnle.jdField_e_of_type_Int <= 0) {
        break label110;
      }
    }
    label110:
    for (int i = bnle.jdField_e_of_type_Int;; i = aepi.a(60.0F, a()))
    {
      localLayoutParams.bottomMargin = i;
      localRelativeLayout1.addView(this.jdField_a_of_type_AndroidWidgetRelativeLayout, localLayoutParams);
      return;
      i = 8;
      break;
    }
  }
  
  private void k()
  {
    Typeface localTypeface = null;
    if (this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaViewExtendEditText == null) {
      return;
    }
    this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaViewExtendEditText.setTextEffect(this.jdField_a_of_type_Bnfs.jdField_e_of_type_JavaLangString);
    String str = bjjo.a(this.jdField_a_of_type_Bnfs.jdField_d_of_type_Int, null, null, null);
    if (TextUtils.isEmpty(str)) {
      this.jdField_a_of_type_Bnfs.jdField_d_of_type_Int = -1;
    }
    for (;;)
    {
      this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaViewExtendEditText.setTypeface(localTypeface);
      return;
      localTypeface = Typeface.createFromFile(str);
    }
  }
  
  /* Error */
  public String a(String paramString)
  {
    // Byte code:
    //   0: invokestatic 196	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   3: invokevirtual 202	com/tencent/qphone/base/util/BaseApplication:getContentResolver	()Landroid/content/ContentResolver;
    //   6: astore_2
    //   7: aload_2
    //   8: new 78	java/lang/StringBuilder
    //   11: dup
    //   12: invokespecial 81	java/lang/StringBuilder:<init>	()V
    //   15: ldc 204
    //   17: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   20: aload_1
    //   21: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   27: invokestatic 210	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   30: aconst_null
    //   31: ldc 212
    //   33: iconst_1
    //   34: anewarray 214	java/lang/String
    //   37: dup
    //   38: iconst_0
    //   39: aload_1
    //   40: aastore
    //   41: aconst_null
    //   42: invokevirtual 220	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   45: astore_1
    //   46: aload_1
    //   47: ifnull +212 -> 259
    //   50: aload_1
    //   51: invokeinterface 226 1 0
    //   56: ifeq +203 -> 259
    //   59: aload_1
    //   60: aload_1
    //   61: ldc 228
    //   63: invokeinterface 232 2 0
    //   68: invokeinterface 235 2 0
    //   73: astore_2
    //   74: aload_2
    //   75: invokestatic 177	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   78: ifne +174 -> 252
    //   81: new 214	java/lang/String
    //   84: dup
    //   85: aload_2
    //   86: invokevirtual 239	java/lang/String:getBytes	()[B
    //   89: ldc 241
    //   91: invokespecial 244	java/lang/String:<init>	([BLjava/lang/String;)V
    //   94: invokestatic 248	com/tencent/mobileqq/utils/SecurityUtile:b	(Ljava/lang/String;)Ljava/lang/String;
    //   97: astore_2
    //   98: invokestatic 251	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   101: ifeq +28 -> 129
    //   104: ldc 253
    //   106: iconst_2
    //   107: new 78	java/lang/StringBuilder
    //   110: dup
    //   111: invokespecial 81	java/lang/StringBuilder:<init>	()V
    //   114: ldc 255
    //   116: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   119: aload_2
    //   120: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   123: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   126: invokestatic 257	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   129: aload_2
    //   130: astore_3
    //   131: aload_1
    //   132: ifnull +11 -> 143
    //   135: aload_1
    //   136: invokeinterface 260 1 0
    //   141: aload_2
    //   142: astore_3
    //   143: aload_3
    //   144: areturn
    //   145: astore_3
    //   146: aconst_null
    //   147: astore_2
    //   148: ldc_w 262
    //   151: astore_1
    //   152: invokestatic 251	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   155: ifeq +32 -> 187
    //   158: ldc 253
    //   160: iconst_2
    //   161: new 78	java/lang/StringBuilder
    //   164: dup
    //   165: invokespecial 81	java/lang/StringBuilder:<init>	()V
    //   168: ldc_w 264
    //   171: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   174: aload_3
    //   175: invokestatic 268	com/tencent/qphone/base/util/QLog:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   178: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   181: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   184: invokestatic 99	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   187: aload_1
    //   188: astore_3
    //   189: aload_2
    //   190: ifnull -47 -> 143
    //   193: aload_2
    //   194: invokeinterface 260 1 0
    //   199: aload_1
    //   200: areturn
    //   201: astore_2
    //   202: aconst_null
    //   203: astore_1
    //   204: aload_1
    //   205: ifnull +9 -> 214
    //   208: aload_1
    //   209: invokeinterface 260 1 0
    //   214: aload_2
    //   215: athrow
    //   216: astore_2
    //   217: goto -13 -> 204
    //   220: astore_3
    //   221: aload_2
    //   222: astore_1
    //   223: aload_3
    //   224: astore_2
    //   225: goto -21 -> 204
    //   228: astore_3
    //   229: aload_1
    //   230: astore_2
    //   231: ldc_w 262
    //   234: astore_1
    //   235: goto -83 -> 152
    //   238: astore 4
    //   240: aload_2
    //   241: astore_3
    //   242: aload_1
    //   243: astore_2
    //   244: aload_3
    //   245: astore_1
    //   246: aload 4
    //   248: astore_3
    //   249: goto -97 -> 152
    //   252: ldc_w 262
    //   255: astore_2
    //   256: goto -158 -> 98
    //   259: ldc_w 262
    //   262: astore_2
    //   263: goto -134 -> 129
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	266	0	this	bnfg
    //   0	266	1	paramString	String
    //   6	188	2	localObject1	Object
    //   201	14	2	localObject2	Object
    //   216	6	2	localObject3	Object
    //   224	39	2	localObject4	Object
    //   130	14	3	localObject5	Object
    //   145	30	3	localException1	java.lang.Exception
    //   188	1	3	str	String
    //   220	4	3	localObject6	Object
    //   228	1	3	localException2	java.lang.Exception
    //   241	8	3	localObject7	Object
    //   238	9	4	localException3	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   7	46	145	java/lang/Exception
    //   7	46	201	finally
    //   50	98	216	finally
    //   98	129	216	finally
    //   152	187	220	finally
    //   50	98	228	java/lang/Exception
    //   98	129	238	java/lang/Exception
  }
  
  public void a()
  {
    super.a();
    j();
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)a(2131366518));
    this.jdField_a_of_type_AndroidWidgetCheckBox = ((CheckBox)a(2131366568));
    this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaViewExtendEditText = ((ExtendEditText)a(2131366519));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)a(2131366562));
    this.jdField_a_of_type_AndroidViewView = a(2131366567);
    this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaViewExtendEditText.setEditableFactory(bane.c);
    this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaViewExtendEditText.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    if (!this.jdField_a_of_type_Bnfs.k) {
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
    }
    if ((this.jdField_a_of_type_Bnfs.h) || (this.jdField_a_of_type_Bnfs.j))
    {
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetCheckBox.setOnCheckedChangeListener(new bnfh(this));
      this.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(true);
    }
    if (a(QQStoryContext.a().a())) {
      k();
    }
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.a(paramInt1, paramInt2, paramIntent);
    Object localObject;
    if (paramInt1 == 1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("EditVideoQzComment", 2, "onActivityResult:requestCode=" + paramInt1 + "  resultCode=" + paramInt2);
      }
      if (paramIntent != null)
      {
        paramIntent = paramIntent.getExtras();
        if (paramIntent.containsKey("permission_code")) {
          this.jdField_a_of_type_Bnfs.jdField_c_of_type_Int = paramIntent.getInt("permission_code");
        }
        if (paramIntent.containsKey("uin_list"))
        {
          if (this.jdField_a_of_type_Bnfs.jdField_a_of_type_JavaUtilArrayList == null) {
            this.jdField_a_of_type_Bnfs.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
          }
          this.jdField_a_of_type_Bnfs.jdField_a_of_type_JavaUtilArrayList.clear();
          localObject = paramIntent.getStringArrayList("uin_list");
          if (localObject != null) {
            this.jdField_a_of_type_Bnfs.jdField_a_of_type_JavaUtilArrayList.addAll((Collection)localObject);
          }
        }
        if (a(this.jdField_a_of_type_Bnfs.jdField_c_of_type_Int))
        {
          this.jdField_a_of_type_Bnfs.b = paramIntent.getString("key_setting_raw_json");
          this.jdField_a_of_type_Bnfs.jdField_a_of_type_JavaLangString = paramIntent.getString("key_selected_tag");
        }
        if (xna.a().b() == 22) {
          LpReportInfo_pf00064.allReport(680, 5, 2);
        }
        d();
      }
    }
    do
    {
      do
      {
        do
        {
          return;
        } while (xna.a().b() != 22);
        LpReportInfo_pf00064.allReport(680, 5, 3);
        return;
      } while (paramInt1 != 1009);
      if (this.jdField_a_of_type_Bnfs.jdField_a_of_type_AndroidViewView != null) {
        this.jdField_a_of_type_Bnfs.jdField_a_of_type_AndroidViewView.setVisibility(8);
      }
      this.jdField_a_of_type_Bmnj.a(Message.obtain(null, 22));
    } while (paramIntent == null);
    Bundle localBundle = paramIntent.getExtras();
    if (localBundle.containsKey("extra_key_bundle_priv_key"))
    {
      paramIntent = localBundle.getBundle("extra_key_bundle_priv_key");
      if (paramIntent != null)
      {
        this.jdField_a_of_type_Bnfs.jdField_c_of_type_Int = paramIntent.getInt("permission_code");
        if (this.jdField_a_of_type_Bnfs.jdField_a_of_type_JavaUtilArrayList == null) {
          this.jdField_a_of_type_Bnfs.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
        }
        this.jdField_a_of_type_Bnfs.jdField_a_of_type_JavaUtilArrayList.clear();
        localObject = paramIntent.getStringArrayList("uin_list");
        if (localObject != null) {
          this.jdField_a_of_type_Bnfs.jdField_a_of_type_JavaUtilArrayList.addAll((Collection)localObject);
        }
        if (a(this.jdField_a_of_type_Bnfs.jdField_c_of_type_Int))
        {
          this.jdField_a_of_type_Bnfs.b = paramIntent.getString("key_setting_raw_json");
          this.jdField_a_of_type_Bnfs.jdField_a_of_type_JavaLangString = paramIntent.getString("key_selected_tag");
        }
        d();
      }
    }
    if (localBundle.containsKey("extraIsTopicSyncQzone"))
    {
      boolean bool = localBundle.getBoolean("extraIsTopicSyncQzone");
      this.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(bool);
    }
    if (localBundle.containsKey("contentIntentKey"))
    {
      localObject = localBundle.getString("contentIntentKey");
      paramIntent = (Intent)localObject;
      if (localObject == null) {
        paramIntent = "";
      }
      this.jdField_a_of_type_Bnfs.jdField_c_of_type_JavaLangString = paramIntent;
      if (xna.a().b() == 22) {
        LpReportInfo_pf00064.allReport(680, 2, 8);
      }
    }
    if (localBundle.containsKey("contentIntentKeyForVideoEditWithEmo"))
    {
      paramIntent = localBundle.getString("contentIntentKeyForVideoEditWithEmo");
      this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaViewExtendEditText.setText(paramIntent);
    }
    this.jdField_a_of_type_Bnfs.jdField_d_of_type_Int = localBundle.getInt("extra_key_font_id", -1);
    this.jdField_a_of_type_Bnfs.jdField_e_of_type_Int = localBundle.getInt("extra_key_font_format_type");
    this.jdField_a_of_type_Bnfs.jdField_d_of_type_JavaLangString = localBundle.getString("extra_key_font_url");
    this.jdField_a_of_type_Bnfs.f = localBundle.getInt("extra_key_super_font_id", -1);
    this.jdField_a_of_type_Bnfs.jdField_e_of_type_JavaLangString = localBundle.getString("extra_key_super_font_info");
    k();
  }
  
  protected boolean a(Message paramMessage)
  {
    switch (paramMessage.arg1)
    {
    }
    for (;;)
    {
      switch (paramMessage.what)
      {
      default: 
        this.jdField_a_of_type_Int = paramMessage.arg1;
        return super.a(paramMessage);
        if (paramMessage.what != 3) {
          this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
        }
        break;
      }
    }
    this.d = ((Long)paramMessage.obj).longValue();
    return true;
  }
  
  public void a_(int paramInt, Object paramObject)
  {
    int j = 0;
    int i = 0;
    if (paramInt == 7) {}
    for (boolean bool = true;; bool = false)
    {
      this.jdField_a_of_type_Boolean = bool;
      switch (paramInt)
      {
      default: 
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
        return;
      }
    }
    if (this.jdField_a_of_type_Bnfs.i) {}
    for (paramInt = i;; paramInt = 8)
    {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(paramInt);
      return;
    }
    if (this.jdField_a_of_type_Int != 1)
    {
      if ((this.jdField_a_of_type_Bnfs.i) && (!this.jdField_a_of_type_Boolean)) {}
      for (paramInt = j;; paramInt = 8)
      {
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(paramInt);
        return;
      }
    }
    this.jdField_a_of_type_Boolean = true;
    return;
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
  }
  
  public void d()
  {
    this.jdField_a_of_type_JavaLangString = bkah.a(this.jdField_a_of_type_Bnfs.jdField_c_of_type_Int);
    this.jdField_a_of_type_AndroidWidgetButton.setText(this.jdField_a_of_type_JavaLangString);
  }
  
  public void onClick(View paramView)
  {
    if (this.d > System.currentTimeMillis()) {}
    do
    {
      return;
      i = paramView.getId();
      if (i == 2131366562)
      {
        paramView = QzoneConfig.getInstance().getConfig("H5Url", "UgcPermitSetting", "https://h5.qzone.qq.com/ugc/setting?_wv=3&type=mood&uin={uin}&qua={qua}&_proxy=1").replace("{uin}", QQStoryContext.a().a()).replace("{qua}", bjdm.a());
        this.jdField_a_of_type_Bnfs.d(3004);
        localObject1 = new Bundle();
        ((Bundle)localObject1).putInt("permission_code", this.jdField_a_of_type_Bnfs.jdField_c_of_type_Int);
        if ((this.jdField_a_of_type_Bnfs.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_Bnfs.jdField_a_of_type_JavaUtilArrayList.size() > 0))
        {
          ((Bundle)localObject1).putStringArrayList("uin_list", this.jdField_a_of_type_Bnfs.jdField_a_of_type_JavaUtilArrayList);
          localObject2 = new ArrayList(this.jdField_a_of_type_Bnfs.jdField_a_of_type_JavaUtilArrayList.size());
          localObject3 = this.jdField_a_of_type_Bnfs.jdField_a_of_type_JavaUtilArrayList.iterator();
          while (((Iterator)localObject3).hasNext()) {
            ((ArrayList)localObject2).add(a((String)((Iterator)localObject3).next()));
          }
          ((Bundle)localObject1).putStringArrayList("key_nicknames", (ArrayList)localObject2);
        }
        if ((a(this.jdField_a_of_type_Bnfs.jdField_c_of_type_Int)) && (!TextUtils.isEmpty(this.jdField_a_of_type_Bnfs.b))) {
          ((Bundle)localObject1).putString("key_setting_raw_json", this.jdField_a_of_type_Bnfs.b);
        }
        if (xna.a().b() == 22)
        {
          LpReportInfo_pf00064.allReport(680, 2, 4);
          LpReportInfo_pf00064.allReport(680, 5, 1);
        }
        bjdt.a((BaseActivity)this.jdField_a_of_type_Bmor, paramView, 1, (Bundle)localObject1, "");
        return;
      }
    } while (i != 2131366519);
    this.jdField_a_of_type_Bnfs.d(3001);
    Object localObject1 = bjea.a();
    Object localObject2 = new Bundle();
    ((Bundle)localObject2).putInt("permission_code", this.jdField_a_of_type_Bnfs.jdField_c_of_type_Int);
    if ((this.jdField_a_of_type_Bnfs.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_Bnfs.jdField_a_of_type_JavaUtilArrayList.size() > 0))
    {
      ((Bundle)localObject2).putStringArrayList("uin_list", this.jdField_a_of_type_Bnfs.jdField_a_of_type_JavaUtilArrayList);
      paramView = new ArrayList(this.jdField_a_of_type_Bnfs.jdField_a_of_type_JavaUtilArrayList.size());
      localObject3 = this.jdField_a_of_type_Bnfs.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (((Iterator)localObject3).hasNext()) {
        paramView.add(a((String)((Iterator)localObject3).next()));
      }
      ((Bundle)localObject2).putStringArrayList("key_nicknames", paramView);
    }
    if ((a(this.jdField_a_of_type_Bnfs.jdField_c_of_type_Int)) && (!TextUtils.isEmpty(this.jdField_a_of_type_Bnfs.b))) {
      ((Bundle)localObject2).putString("key_setting_raw_json", this.jdField_a_of_type_Bnfs.b);
    }
    ((Bundle)localObject2).putBoolean("is_need_auto_close_from_pri", true);
    if (this.jdField_a_of_type_Bnfs.jdField_a_of_type_AndroidViewView != null) {
      this.jdField_a_of_type_Bnfs.jdField_a_of_type_AndroidViewView.setVisibility(0);
    }
    paramView = "";
    if (this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaViewExtendEditText != null) {
      paramView = this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaViewExtendEditText.getText().toString();
    }
    if (xna.a().b() == 22) {
      LpReportInfo_pf00064.allReport(680, 2, 3);
    }
    Object localObject3 = new Bundle();
    ((Bundle)localObject3).putBoolean("key_at_click_hide_keyboard", true);
    this.jdField_a_of_type_Bmnj.a(Message.obtain(null, 21));
    BaseActivity localBaseActivity = (BaseActivity)this.jdField_a_of_type_Bmor;
    if (this.jdField_a_of_type_Bnfs.h) {}
    for (int i = 0;; i = 1)
    {
      bjdt.a(localBaseActivity, (bjea)localObject1, 1009, "", paramView, "", "", 0, i, 1, 0, 0, 0, "", 10000, (Bundle)localObject2, this.jdField_a_of_type_Bnfs.h, this.jdField_a_of_type_Bnfs.g, this.jdField_a_of_type_Bnfs.jdField_d_of_type_Int, this.jdField_a_of_type_Bnfs.f, false, (Bundle)localObject3);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnfg
 * JD-Core Version:    0.7.0.1
 */