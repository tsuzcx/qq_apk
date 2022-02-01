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
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import common.config.service.QzoneConfig;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import dov.com.tencent.mobileqq.activity.richmedia.view.ExtendEditText;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class bpwj
  extends bpen
  implements View.OnClickListener
{
  private int jdField_a_of_type_Int;
  private View jdField_a_of_type_AndroidViewView;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private CheckBox jdField_a_of_type_AndroidWidgetCheckBox;
  public RelativeLayout a;
  private bpwv jdField_a_of_type_Bpwv;
  private ExtendEditText jdField_a_of_type_DovComTencentMobileqqActivityRichmediaViewExtendEditText;
  private String jdField_a_of_type_JavaLangString = bmos.a(1);
  private boolean jdField_a_of_type_Boolean;
  
  public bpwj(@NonNull bpwv parambpwv)
  {
    super(parambpwv);
    this.jdField_a_of_type_Bpwv = parambpwv;
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
      paramString = blxw.a(l);
      if (paramString == null) {
        return false;
      }
      this.jdField_a_of_type_Bpwv.jdField_d_of_type_Int = paramString.jdField_a_of_type_Int;
      this.jdField_a_of_type_Bpwv.jdField_e_of_type_Int = paramString.b;
      this.jdField_a_of_type_Bpwv.jdField_d_of_type_JavaLangString = paramString.jdField_a_of_type_JavaLangString;
      int i = this.jdField_a_of_type_Bpwv.jdField_d_of_type_Int;
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
    RelativeLayout localRelativeLayout1 = (RelativeLayout)a(2131365843);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)LayoutInflater.from(a()).inflate(2131562290, localRelativeLayout1, false));
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, afur.a(50.0F, a()));
    RelativeLayout localRelativeLayout2 = this.jdField_a_of_type_AndroidWidgetRelativeLayout;
    if (this.jdField_a_of_type_Bpwv.i)
    {
      i = 0;
      localRelativeLayout2.setVisibility(i);
      localLayoutParams.addRule(12);
      if (bqcd.jdField_e_of_type_Int <= 0) {
        break label110;
      }
    }
    label110:
    for (int i = bqcd.jdField_e_of_type_Int;; i = afur.a(60.0F, a()))
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
    this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaViewExtendEditText.setTextEffect(this.jdField_a_of_type_Bpwv.jdField_e_of_type_JavaLangString);
    String str = blxw.a(this.jdField_a_of_type_Bpwv.jdField_d_of_type_Int, null, null, null);
    if (TextUtils.isEmpty(str)) {
      this.jdField_a_of_type_Bpwv.jdField_d_of_type_Int = -1;
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
    //   47: ifnull +213 -> 260
    //   50: aload_1
    //   51: invokeinterface 226 1 0
    //   56: ifeq +204 -> 260
    //   59: aload_1
    //   60: aload_1
    //   61: ldc 228
    //   63: invokeinterface 232 2 0
    //   68: invokeinterface 235 2 0
    //   73: astore_2
    //   74: aload_2
    //   75: invokestatic 177	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   78: ifne +175 -> 253
    //   81: new 214	java/lang/String
    //   84: dup
    //   85: aload_2
    //   86: invokevirtual 239	java/lang/String:getBytes	()[B
    //   89: ldc 241
    //   91: invokespecial 244	java/lang/String:<init>	([BLjava/lang/String;)V
    //   94: invokestatic 249	com/tencent/mobileqq/utils/SecurityUtile:decode	(Ljava/lang/String;)Ljava/lang/String;
    //   97: astore_2
    //   98: invokestatic 252	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   101: ifeq +29 -> 130
    //   104: ldc 254
    //   106: iconst_2
    //   107: new 78	java/lang/StringBuilder
    //   110: dup
    //   111: invokespecial 81	java/lang/StringBuilder:<init>	()V
    //   114: ldc_w 256
    //   117: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   120: aload_2
    //   121: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   124: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   127: invokestatic 258	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   130: aload_2
    //   131: astore_3
    //   132: aload_1
    //   133: ifnull +11 -> 144
    //   136: aload_1
    //   137: invokeinterface 261 1 0
    //   142: aload_2
    //   143: astore_3
    //   144: aload_3
    //   145: areturn
    //   146: astore_3
    //   147: aconst_null
    //   148: astore_2
    //   149: ldc_w 263
    //   152: astore_1
    //   153: invokestatic 252	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   156: ifeq +32 -> 188
    //   159: ldc 254
    //   161: iconst_2
    //   162: new 78	java/lang/StringBuilder
    //   165: dup
    //   166: invokespecial 81	java/lang/StringBuilder:<init>	()V
    //   169: ldc_w 265
    //   172: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   175: aload_3
    //   176: invokestatic 269	com/tencent/qphone/base/util/QLog:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   179: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   182: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   185: invokestatic 99	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   188: aload_1
    //   189: astore_3
    //   190: aload_2
    //   191: ifnull -47 -> 144
    //   194: aload_2
    //   195: invokeinterface 261 1 0
    //   200: aload_1
    //   201: areturn
    //   202: astore_2
    //   203: aconst_null
    //   204: astore_1
    //   205: aload_1
    //   206: ifnull +9 -> 215
    //   209: aload_1
    //   210: invokeinterface 261 1 0
    //   215: aload_2
    //   216: athrow
    //   217: astore_2
    //   218: goto -13 -> 205
    //   221: astore_3
    //   222: aload_2
    //   223: astore_1
    //   224: aload_3
    //   225: astore_2
    //   226: goto -21 -> 205
    //   229: astore_3
    //   230: aload_1
    //   231: astore_2
    //   232: ldc_w 263
    //   235: astore_1
    //   236: goto -83 -> 153
    //   239: astore 4
    //   241: aload_2
    //   242: astore_3
    //   243: aload_1
    //   244: astore_2
    //   245: aload_3
    //   246: astore_1
    //   247: aload 4
    //   249: astore_3
    //   250: goto -97 -> 153
    //   253: ldc_w 263
    //   256: astore_2
    //   257: goto -159 -> 98
    //   260: ldc_w 263
    //   263: astore_2
    //   264: goto -134 -> 130
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	267	0	this	bpwj
    //   0	267	1	paramString	String
    //   6	189	2	localObject1	Object
    //   202	14	2	localObject2	Object
    //   217	6	2	localObject3	Object
    //   225	39	2	localObject4	Object
    //   131	14	3	localObject5	Object
    //   146	30	3	localException1	java.lang.Exception
    //   189	1	3	str	String
    //   221	4	3	localObject6	Object
    //   229	1	3	localException2	java.lang.Exception
    //   242	8	3	localObject7	Object
    //   239	9	4	localException3	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   7	46	146	java/lang/Exception
    //   7	46	202	finally
    //   50	98	217	finally
    //   98	130	217	finally
    //   153	188	221	finally
    //   50	98	229	java/lang/Exception
    //   98	130	239	java/lang/Exception
  }
  
  public void a()
  {
    super.a();
    j();
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)a(2131366783));
    this.jdField_a_of_type_AndroidWidgetCheckBox = ((CheckBox)a(2131366833));
    this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaViewExtendEditText = ((ExtendEditText)a(2131366784));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)a(2131366827));
    this.jdField_a_of_type_AndroidViewView = a(2131366832);
    this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaViewExtendEditText.setEditableFactory(bdoi.c);
    this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaViewExtendEditText.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    if (!this.jdField_a_of_type_Bpwv.k) {
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
    }
    if ((this.jdField_a_of_type_Bpwv.h) || (this.jdField_a_of_type_Bpwv.j))
    {
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetCheckBox.setOnCheckedChangeListener(new bpwk(this));
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
          this.jdField_a_of_type_Bpwv.jdField_c_of_type_Int = paramIntent.getInt("permission_code");
        }
        if (paramIntent.containsKey("uin_list"))
        {
          if (this.jdField_a_of_type_Bpwv.jdField_a_of_type_JavaUtilArrayList == null) {
            this.jdField_a_of_type_Bpwv.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
          }
          this.jdField_a_of_type_Bpwv.jdField_a_of_type_JavaUtilArrayList.clear();
          localObject = paramIntent.getStringArrayList("uin_list");
          if (localObject != null) {
            this.jdField_a_of_type_Bpwv.jdField_a_of_type_JavaUtilArrayList.addAll((Collection)localObject);
          }
        }
        if (a(this.jdField_a_of_type_Bpwv.jdField_c_of_type_Int))
        {
          this.jdField_a_of_type_Bpwv.b = paramIntent.getString("key_setting_raw_json");
          this.jdField_a_of_type_Bpwv.jdField_a_of_type_JavaLangString = paramIntent.getString("key_selected_tag");
        }
        if (zgl.a().b() == 22) {
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
        } while (zgl.a().b() != 22);
        LpReportInfo_pf00064.allReport(680, 5, 3);
        return;
      } while (paramInt1 != 1009);
      if (this.jdField_a_of_type_Bpwv.jdField_a_of_type_AndroidViewView != null) {
        this.jdField_a_of_type_Bpwv.jdField_a_of_type_AndroidViewView.setVisibility(8);
      }
      this.jdField_a_of_type_Bpep.a(Message.obtain(null, 22));
    } while (paramIntent == null);
    Bundle localBundle = paramIntent.getExtras();
    if (localBundle.containsKey("extra_key_bundle_priv_key"))
    {
      paramIntent = localBundle.getBundle("extra_key_bundle_priv_key");
      if (paramIntent != null)
      {
        this.jdField_a_of_type_Bpwv.jdField_c_of_type_Int = paramIntent.getInt("permission_code");
        if (this.jdField_a_of_type_Bpwv.jdField_a_of_type_JavaUtilArrayList == null) {
          this.jdField_a_of_type_Bpwv.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
        }
        this.jdField_a_of_type_Bpwv.jdField_a_of_type_JavaUtilArrayList.clear();
        localObject = paramIntent.getStringArrayList("uin_list");
        if (localObject != null) {
          this.jdField_a_of_type_Bpwv.jdField_a_of_type_JavaUtilArrayList.addAll((Collection)localObject);
        }
        if (a(this.jdField_a_of_type_Bpwv.jdField_c_of_type_Int))
        {
          this.jdField_a_of_type_Bpwv.b = paramIntent.getString("key_setting_raw_json");
          this.jdField_a_of_type_Bpwv.jdField_a_of_type_JavaLangString = paramIntent.getString("key_selected_tag");
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
      this.jdField_a_of_type_Bpwv.jdField_c_of_type_JavaLangString = paramIntent;
      if (zgl.a().b() == 22) {
        LpReportInfo_pf00064.allReport(680, 2, 8);
      }
    }
    if (localBundle.containsKey("contentIntentKeyForVideoEditWithEmo"))
    {
      paramIntent = localBundle.getString("contentIntentKeyForVideoEditWithEmo");
      this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaViewExtendEditText.setText(paramIntent);
    }
    this.jdField_a_of_type_Bpwv.jdField_d_of_type_Int = localBundle.getInt("extra_key_font_id", -1);
    this.jdField_a_of_type_Bpwv.jdField_e_of_type_Int = localBundle.getInt("extra_key_font_format_type");
    this.jdField_a_of_type_Bpwv.jdField_d_of_type_JavaLangString = localBundle.getString("extra_key_font_url");
    this.jdField_a_of_type_Bpwv.f = localBundle.getInt("extra_key_super_font_id", -1);
    this.jdField_a_of_type_Bpwv.jdField_e_of_type_JavaLangString = localBundle.getString("extra_key_super_font_info");
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
    if (this.jdField_a_of_type_Bpwv.i) {}
    for (paramInt = i;; paramInt = 8)
    {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(paramInt);
      return;
    }
    if (this.jdField_a_of_type_Int != 1)
    {
      if ((this.jdField_a_of_type_Bpwv.i) && (!this.jdField_a_of_type_Boolean)) {}
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
    this.jdField_a_of_type_JavaLangString = bmos.a(this.jdField_a_of_type_Bpwv.jdField_c_of_type_Int);
    this.jdField_a_of_type_AndroidWidgetButton.setText(this.jdField_a_of_type_JavaLangString);
  }
  
  public void onClick(View paramView)
  {
    if (this.d > System.currentTimeMillis()) {}
    do
    {
      for (;;)
      {
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        i = paramView.getId();
        if (i != 2131366827) {
          break;
        }
        localObject1 = QzoneConfig.getInstance().getConfig("H5Url", "UgcPermitSetting", "https://h5.qzone.qq.com/ugc/setting?_wv=3&type=mood&uin={uin}&qua={qua}&_proxy=1").replace("{uin}", QQStoryContext.a().a()).replace("{qua}", blru.a());
        this.jdField_a_of_type_Bpwv.c(3004);
        localObject2 = new Bundle();
        ((Bundle)localObject2).putInt("permission_code", this.jdField_a_of_type_Bpwv.jdField_c_of_type_Int);
        if ((this.jdField_a_of_type_Bpwv.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_Bpwv.jdField_a_of_type_JavaUtilArrayList.size() > 0))
        {
          ((Bundle)localObject2).putStringArrayList("uin_list", this.jdField_a_of_type_Bpwv.jdField_a_of_type_JavaUtilArrayList);
          localObject3 = new ArrayList(this.jdField_a_of_type_Bpwv.jdField_a_of_type_JavaUtilArrayList.size());
          localObject4 = this.jdField_a_of_type_Bpwv.jdField_a_of_type_JavaUtilArrayList.iterator();
          while (((Iterator)localObject4).hasNext()) {
            ((ArrayList)localObject3).add(a((String)((Iterator)localObject4).next()));
          }
          ((Bundle)localObject2).putStringArrayList("key_nicknames", (ArrayList)localObject3);
        }
        if ((a(this.jdField_a_of_type_Bpwv.jdField_c_of_type_Int)) && (!TextUtils.isEmpty(this.jdField_a_of_type_Bpwv.b))) {
          ((Bundle)localObject2).putString("key_setting_raw_json", this.jdField_a_of_type_Bpwv.b);
        }
        if (zgl.a().b() == 22)
        {
          LpReportInfo_pf00064.allReport(680, 2, 4);
          LpReportInfo_pf00064.allReport(680, 5, 1);
        }
        blsb.a((BaseActivity)this.jdField_a_of_type_Bpfx, (String)localObject1, 1, (Bundle)localObject2, "");
      }
    } while (i != 2131366784);
    this.jdField_a_of_type_Bpwv.c(3001);
    Object localObject2 = blsi.a();
    Object localObject3 = new Bundle();
    ((Bundle)localObject3).putInt("permission_code", this.jdField_a_of_type_Bpwv.jdField_c_of_type_Int);
    if ((this.jdField_a_of_type_Bpwv.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_Bpwv.jdField_a_of_type_JavaUtilArrayList.size() > 0))
    {
      ((Bundle)localObject3).putStringArrayList("uin_list", this.jdField_a_of_type_Bpwv.jdField_a_of_type_JavaUtilArrayList);
      localObject1 = new ArrayList(this.jdField_a_of_type_Bpwv.jdField_a_of_type_JavaUtilArrayList.size());
      localObject4 = this.jdField_a_of_type_Bpwv.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (((Iterator)localObject4).hasNext()) {
        ((ArrayList)localObject1).add(a((String)((Iterator)localObject4).next()));
      }
      ((Bundle)localObject3).putStringArrayList("key_nicknames", (ArrayList)localObject1);
    }
    if ((a(this.jdField_a_of_type_Bpwv.jdField_c_of_type_Int)) && (!TextUtils.isEmpty(this.jdField_a_of_type_Bpwv.b))) {
      ((Bundle)localObject3).putString("key_setting_raw_json", this.jdField_a_of_type_Bpwv.b);
    }
    ((Bundle)localObject3).putBoolean("is_need_auto_close_from_pri", true);
    if (this.jdField_a_of_type_Bpwv.jdField_a_of_type_AndroidViewView != null) {
      this.jdField_a_of_type_Bpwv.jdField_a_of_type_AndroidViewView.setVisibility(0);
    }
    Object localObject1 = "";
    if (this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaViewExtendEditText != null) {
      localObject1 = this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaViewExtendEditText.getText().toString();
    }
    if (zgl.a().b() == 22) {
      LpReportInfo_pf00064.allReport(680, 2, 3);
    }
    Object localObject4 = new Bundle();
    ((Bundle)localObject4).putBoolean("key_at_click_hide_keyboard", true);
    this.jdField_a_of_type_Bpep.a(Message.obtain(null, 21));
    BaseActivity localBaseActivity = (BaseActivity)this.jdField_a_of_type_Bpfx;
    if (this.jdField_a_of_type_Bpwv.h) {}
    for (int i = 0;; i = 1)
    {
      blsb.a(localBaseActivity, (blsi)localObject2, 1009, "", (String)localObject1, "", "", 0, i, 1, 0, 0, 0, "", 10000, (Bundle)localObject3, this.jdField_a_of_type_Bpwv.h, this.jdField_a_of_type_Bpwv.g, this.jdField_a_of_type_Bpwv.jdField_d_of_type_Int, this.jdField_a_of_type_Bpwv.f, false, (Bundle)localObject4);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bpwj
 * JD-Core Version:    0.7.0.1
 */