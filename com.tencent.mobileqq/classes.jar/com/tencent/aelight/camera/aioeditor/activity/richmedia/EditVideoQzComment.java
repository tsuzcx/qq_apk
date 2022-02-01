package com.tencent.aelight.camera.aioeditor.activity.richmedia;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Message;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.aelight.camera.aioeditor.activity.richmedia.view.ExtendEditText;
import com.tencent.aelight.camera.aioeditor.takevideo.EditVideoPart;
import com.tencent.aelight.camera.aioeditor.takevideo.EditVideoPartManager;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.takevideo.slideshow.SlideShowPhotoListManager;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.text.QzoneTextBuilder;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qzonehub.api.font.IFontManager;
import com.tencent.util.LiuHaiUtils;
import common.config.service.QzoneConfig;
import cooperation.qzone.QUA;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QZoneHelper.UserInfo;
import cooperation.qzone.font.DefaultFontInfo;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import cooperation.qzone.webviewplugin.ugcsetting.UgcSettingUtil;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class EditVideoQzComment
  extends EditVideoPart
  implements View.OnClickListener
{
  private int jdField_a_of_type_Int = 0;
  private View jdField_a_of_type_AndroidViewView;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private CheckBox jdField_a_of_type_AndroidWidgetCheckBox;
  public RelativeLayout a;
  private QzEditVideoPartManager jdField_a_of_type_ComTencentAelightCameraAioeditorActivityRichmediaQzEditVideoPartManager;
  private ExtendEditText jdField_a_of_type_ComTencentAelightCameraAioeditorActivityRichmediaViewExtendEditText;
  private String jdField_a_of_type_JavaLangString = UgcSettingUtil.getPrivacyDescriptionForShuoShuo(1);
  private boolean jdField_a_of_type_Boolean;
  
  public EditVideoQzComment(@NonNull QzEditVideoPartManager paramQzEditVideoPartManager)
  {
    super(paramQzEditVideoPartManager);
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorActivityRichmediaQzEditVideoPartManager = paramQzEditVideoPartManager;
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
      paramString = ((IFontManager)QRoute.api(IFontManager.class)).getDefaultFont(l);
      if (paramString == null) {
        return false;
      }
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorActivityRichmediaQzEditVideoPartManager.jdField_b_of_type_Int = paramString.fontId;
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorActivityRichmediaQzEditVideoPartManager.jdField_c_of_type_Int = paramString.formatType;
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorActivityRichmediaQzEditVideoPartManager.jdField_d_of_type_JavaLangString = paramString.fontUrl;
      int i = this.jdField_a_of_type_ComTencentAelightCameraAioeditorActivityRichmediaQzEditVideoPartManager.jdField_b_of_type_Int;
      return i > 0;
    }
    catch (Throwable paramString)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("loadDefaultFontData Throwable, errMsg = ");
      localStringBuilder.append(paramString.getMessage());
      QLog.e("loadDefaultFontData", 1, localStringBuilder.toString());
    }
    return false;
  }
  
  private void g()
  {
    RelativeLayout localRelativeLayout1 = (RelativeLayout)a(2064122153);
    Object localObject = LayoutInflater.from(a());
    int i = 0;
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)((LayoutInflater)localObject).inflate(2131562249, localRelativeLayout1, false));
    localObject = new RelativeLayout.LayoutParams(-1, AIOUtils.b(50.0F, a()));
    RelativeLayout localRelativeLayout2 = this.jdField_a_of_type_AndroidWidgetRelativeLayout;
    if (!this.jdField_a_of_type_ComTencentAelightCameraAioeditorActivityRichmediaQzEditVideoPartManager.jdField_d_of_type_Boolean) {
      i = 8;
    }
    localRelativeLayout2.setVisibility(i);
    ((RelativeLayout.LayoutParams)localObject).addRule(12);
    if (LiuHaiUtils.e > 0) {
      i = LiuHaiUtils.e;
    } else {
      i = AIOUtils.b(60.0F, a());
    }
    ((RelativeLayout.LayoutParams)localObject).bottomMargin = i;
    localRelativeLayout1.addView(this.jdField_a_of_type_AndroidWidgetRelativeLayout, (ViewGroup.LayoutParams)localObject);
  }
  
  private void h()
  {
    Object localObject = this.jdField_a_of_type_ComTencentAelightCameraAioeditorActivityRichmediaViewExtendEditText;
    if (localObject == null) {
      return;
    }
    ((ExtendEditText)localObject).setTextEffect(this.jdField_a_of_type_ComTencentAelightCameraAioeditorActivityRichmediaQzEditVideoPartManager.jdField_e_of_type_JavaLangString);
    localObject = null;
    String str = ((IFontManager)QRoute.api(IFontManager.class)).getTrueTypeFont(this.jdField_a_of_type_ComTencentAelightCameraAioeditorActivityRichmediaQzEditVideoPartManager.jdField_b_of_type_Int, null, null, true, null);
    if (TextUtils.isEmpty(str)) {
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorActivityRichmediaQzEditVideoPartManager.jdField_b_of_type_Int = -1;
    } else {
      localObject = Typeface.createFromFile(str);
    }
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorActivityRichmediaViewExtendEditText.setTypeface((Typeface)localObject);
  }
  
  /* Error */
  public String a(String paramString)
  {
    // Byte code:
    //   0: ldc 208
    //   2: astore 6
    //   4: invokestatic 214	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   7: invokevirtual 220	com/tencent/qphone/base/util/BaseApplication:getContentResolver	()Landroid/content/ContentResolver;
    //   10: astore 8
    //   12: aconst_null
    //   13: astore 7
    //   15: aconst_null
    //   16: astore 4
    //   18: aload 4
    //   20: astore 5
    //   22: aload 6
    //   24: astore_3
    //   25: aload 7
    //   27: astore_2
    //   28: new 90	java/lang/StringBuilder
    //   31: dup
    //   32: invokespecial 93	java/lang/StringBuilder:<init>	()V
    //   35: astore 9
    //   37: aload 4
    //   39: astore 5
    //   41: aload 6
    //   43: astore_3
    //   44: aload 7
    //   46: astore_2
    //   47: aload 9
    //   49: ldc 222
    //   51: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   54: pop
    //   55: aload 4
    //   57: astore 5
    //   59: aload 6
    //   61: astore_3
    //   62: aload 7
    //   64: astore_2
    //   65: aload 9
    //   67: aload_1
    //   68: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   71: pop
    //   72: aload 4
    //   74: astore 5
    //   76: aload 6
    //   78: astore_3
    //   79: aload 7
    //   81: astore_2
    //   82: aload 8
    //   84: aload 9
    //   86: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   89: invokestatic 228	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   92: aconst_null
    //   93: ldc 230
    //   95: iconst_1
    //   96: anewarray 232	java/lang/String
    //   99: dup
    //   100: iconst_0
    //   101: aload_1
    //   102: aastore
    //   103: aconst_null
    //   104: invokevirtual 238	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   107: astore 7
    //   109: aload 6
    //   111: astore 4
    //   113: aload 7
    //   115: ifnull +199 -> 314
    //   118: aload 6
    //   120: astore 4
    //   122: aload 7
    //   124: astore 5
    //   126: aload 6
    //   128: astore_3
    //   129: aload 7
    //   131: astore_2
    //   132: aload 7
    //   134: invokeinterface 244 1 0
    //   139: ifeq +175 -> 314
    //   142: aload 7
    //   144: astore 5
    //   146: aload 6
    //   148: astore_3
    //   149: aload 7
    //   151: astore_2
    //   152: aload 7
    //   154: aload 7
    //   156: ldc 246
    //   158: invokeinterface 250 2 0
    //   163: invokeinterface 253 2 0
    //   168: astore 4
    //   170: aload 6
    //   172: astore_1
    //   173: aload 7
    //   175: astore 5
    //   177: aload 6
    //   179: astore_3
    //   180: aload 7
    //   182: astore_2
    //   183: aload 4
    //   185: invokestatic 193	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   188: ifne +32 -> 220
    //   191: aload 7
    //   193: astore 5
    //   195: aload 6
    //   197: astore_3
    //   198: aload 7
    //   200: astore_2
    //   201: new 232	java/lang/String
    //   204: dup
    //   205: aload 4
    //   207: invokevirtual 257	java/lang/String:getBytes	()[B
    //   210: ldc_w 259
    //   213: invokespecial 262	java/lang/String:<init>	([BLjava/lang/String;)V
    //   216: invokestatic 267	com/tencent/mobileqq/utils/SecurityUtile:decode	(Ljava/lang/String;)Ljava/lang/String;
    //   219: astore_1
    //   220: aload_1
    //   221: astore 4
    //   223: aload 7
    //   225: astore 5
    //   227: aload_1
    //   228: astore_3
    //   229: aload 7
    //   231: astore_2
    //   232: invokestatic 270	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   235: ifeq +79 -> 314
    //   238: aload 7
    //   240: astore 5
    //   242: aload_1
    //   243: astore_3
    //   244: aload 7
    //   246: astore_2
    //   247: new 90	java/lang/StringBuilder
    //   250: dup
    //   251: invokespecial 93	java/lang/StringBuilder:<init>	()V
    //   254: astore 4
    //   256: aload 7
    //   258: astore 5
    //   260: aload_1
    //   261: astore_3
    //   262: aload 7
    //   264: astore_2
    //   265: aload 4
    //   267: ldc_w 272
    //   270: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   273: pop
    //   274: aload 7
    //   276: astore 5
    //   278: aload_1
    //   279: astore_3
    //   280: aload 7
    //   282: astore_2
    //   283: aload 4
    //   285: aload_1
    //   286: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   289: pop
    //   290: aload 7
    //   292: astore 5
    //   294: aload_1
    //   295: astore_3
    //   296: aload 7
    //   298: astore_2
    //   299: ldc_w 274
    //   302: iconst_2
    //   303: aload 4
    //   305: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   308: invokestatic 277	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   311: aload_1
    //   312: astore 4
    //   314: aload 4
    //   316: astore_1
    //   317: aload 7
    //   319: ifnull +92 -> 411
    //   322: aload 7
    //   324: astore_2
    //   325: aload 4
    //   327: astore_3
    //   328: aload_2
    //   329: invokeinterface 280 1 0
    //   334: aload_3
    //   335: areturn
    //   336: astore_1
    //   337: goto +76 -> 413
    //   340: astore_1
    //   341: aload_2
    //   342: astore 5
    //   344: invokestatic 270	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   347: ifeq +55 -> 402
    //   350: aload_2
    //   351: astore 5
    //   353: new 90	java/lang/StringBuilder
    //   356: dup
    //   357: invokespecial 93	java/lang/StringBuilder:<init>	()V
    //   360: astore 4
    //   362: aload_2
    //   363: astore 5
    //   365: aload 4
    //   367: ldc_w 282
    //   370: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   373: pop
    //   374: aload_2
    //   375: astore 5
    //   377: aload 4
    //   379: aload_1
    //   380: invokestatic 286	com/tencent/qphone/base/util/QLog:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   383: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   386: pop
    //   387: aload_2
    //   388: astore 5
    //   390: ldc_w 274
    //   393: iconst_2
    //   394: aload 4
    //   396: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   399: invokestatic 114	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   402: aload_3
    //   403: astore_1
    //   404: aload_2
    //   405: ifnull +6 -> 411
    //   408: goto -80 -> 328
    //   411: aload_1
    //   412: areturn
    //   413: aload 5
    //   415: ifnull +10 -> 425
    //   418: aload 5
    //   420: invokeinterface 280 1 0
    //   425: goto +5 -> 430
    //   428: aload_1
    //   429: athrow
    //   430: goto -2 -> 428
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	433	0	this	EditVideoQzComment
    //   0	433	1	paramString	String
    //   27	378	2	localCursor1	android.database.Cursor
    //   24	379	3	localObject1	Object
    //   16	379	4	localObject2	Object
    //   20	399	5	localObject3	Object
    //   2	194	6	str	String
    //   13	310	7	localCursor2	android.database.Cursor
    //   10	73	8	localContentResolver	android.content.ContentResolver
    //   35	50	9	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   28	37	336	finally
    //   47	55	336	finally
    //   65	72	336	finally
    //   82	109	336	finally
    //   132	142	336	finally
    //   152	170	336	finally
    //   183	191	336	finally
    //   201	220	336	finally
    //   232	238	336	finally
    //   247	256	336	finally
    //   265	274	336	finally
    //   283	290	336	finally
    //   299	311	336	finally
    //   344	350	336	finally
    //   353	362	336	finally
    //   365	374	336	finally
    //   377	387	336	finally
    //   390	402	336	finally
    //   28	37	340	java/lang/Exception
    //   47	55	340	java/lang/Exception
    //   65	72	340	java/lang/Exception
    //   82	109	340	java/lang/Exception
    //   132	142	340	java/lang/Exception
    //   152	170	340	java/lang/Exception
    //   183	191	340	java/lang/Exception
    //   201	220	340	java/lang/Exception
    //   232	238	340	java/lang/Exception
    //   247	256	340	java/lang/Exception
    //   265	274	340	java/lang/Exception
    //   283	290	340	java/lang/Exception
    //   299	311	340	java/lang/Exception
  }
  
  public void a()
  {
    super.a();
    g();
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)a(2131366996));
    this.jdField_a_of_type_AndroidWidgetCheckBox = ((CheckBox)a(2131367019));
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorActivityRichmediaViewExtendEditText = ((ExtendEditText)a(2131366997));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)a(2131367016));
    this.jdField_a_of_type_AndroidViewView = a(2131367018);
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorActivityRichmediaViewExtendEditText.setEditableFactory(QzoneTextBuilder.a);
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorActivityRichmediaViewExtendEditText.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    if (!this.jdField_a_of_type_ComTencentAelightCameraAioeditorActivityRichmediaQzEditVideoPartManager.f) {
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
    }
    if ((this.jdField_a_of_type_ComTencentAelightCameraAioeditorActivityRichmediaQzEditVideoPartManager.jdField_c_of_type_Boolean) || (this.jdField_a_of_type_ComTencentAelightCameraAioeditorActivityRichmediaQzEditVideoPartManager.jdField_e_of_type_Boolean))
    {
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetCheckBox.setOnCheckedChangeListener(new EditVideoQzComment.1(this));
      this.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(true);
    }
    if (a(QQStoryContext.a().a())) {
      h();
    }
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.a(paramInt1, paramInt2, paramIntent);
    Object localObject;
    if (paramInt1 == 1)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onActivityResult:requestCode=");
        ((StringBuilder)localObject).append(paramInt1);
        ((StringBuilder)localObject).append("  resultCode=");
        ((StringBuilder)localObject).append(paramInt2);
        QLog.d("EditVideoQzComment", 2, ((StringBuilder)localObject).toString());
      }
      if (paramIntent != null)
      {
        paramIntent = paramIntent.getExtras();
        if (paramIntent.containsKey("permission_code")) {
          this.jdField_a_of_type_ComTencentAelightCameraAioeditorActivityRichmediaQzEditVideoPartManager.jdField_a_of_type_Int = paramIntent.getInt("permission_code");
        }
        if (paramIntent.containsKey("uin_list"))
        {
          if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorActivityRichmediaQzEditVideoPartManager.jdField_a_of_type_JavaUtilArrayList == null) {
            this.jdField_a_of_type_ComTencentAelightCameraAioeditorActivityRichmediaQzEditVideoPartManager.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
          }
          this.jdField_a_of_type_ComTencentAelightCameraAioeditorActivityRichmediaQzEditVideoPartManager.jdField_a_of_type_JavaUtilArrayList.clear();
          localObject = paramIntent.getStringArrayList("uin_list");
          if (localObject != null) {
            this.jdField_a_of_type_ComTencentAelightCameraAioeditorActivityRichmediaQzEditVideoPartManager.jdField_a_of_type_JavaUtilArrayList.addAll((Collection)localObject);
          }
        }
        if (a(this.jdField_a_of_type_ComTencentAelightCameraAioeditorActivityRichmediaQzEditVideoPartManager.jdField_a_of_type_Int))
        {
          this.jdField_a_of_type_ComTencentAelightCameraAioeditorActivityRichmediaQzEditVideoPartManager.jdField_b_of_type_JavaLangString = paramIntent.getString("key_setting_raw_json");
          this.jdField_a_of_type_ComTencentAelightCameraAioeditorActivityRichmediaQzEditVideoPartManager.jdField_a_of_type_JavaLangString = paramIntent.getString("key_selected_tag");
        }
        if (SlideShowPhotoListManager.a().b() == 22) {
          LpReportInfo_pf00064.allReport(680, 5, 2);
        }
        b();
        return;
      }
      if (SlideShowPhotoListManager.a().b() == 22) {
        LpReportInfo_pf00064.allReport(680, 5, 3);
      }
    }
    else if (paramInt1 == 1009)
    {
      if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorActivityRichmediaQzEditVideoPartManager.jdField_a_of_type_AndroidViewView != null) {
        this.jdField_a_of_type_ComTencentAelightCameraAioeditorActivityRichmediaQzEditVideoPartManager.jdField_a_of_type_AndroidViewView.setVisibility(8);
      }
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.a(Message.obtain(null, 22));
      if (paramIntent != null)
      {
        Bundle localBundle = paramIntent.getExtras();
        if (localBundle.containsKey("extra_key_bundle_priv_key"))
        {
          paramIntent = localBundle.getBundle("extra_key_bundle_priv_key");
          if (paramIntent != null)
          {
            this.jdField_a_of_type_ComTencentAelightCameraAioeditorActivityRichmediaQzEditVideoPartManager.jdField_a_of_type_Int = paramIntent.getInt("permission_code");
            if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorActivityRichmediaQzEditVideoPartManager.jdField_a_of_type_JavaUtilArrayList == null) {
              this.jdField_a_of_type_ComTencentAelightCameraAioeditorActivityRichmediaQzEditVideoPartManager.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
            }
            this.jdField_a_of_type_ComTencentAelightCameraAioeditorActivityRichmediaQzEditVideoPartManager.jdField_a_of_type_JavaUtilArrayList.clear();
            localObject = paramIntent.getStringArrayList("uin_list");
            if (localObject != null) {
              this.jdField_a_of_type_ComTencentAelightCameraAioeditorActivityRichmediaQzEditVideoPartManager.jdField_a_of_type_JavaUtilArrayList.addAll((Collection)localObject);
            }
            if (a(this.jdField_a_of_type_ComTencentAelightCameraAioeditorActivityRichmediaQzEditVideoPartManager.jdField_a_of_type_Int))
            {
              this.jdField_a_of_type_ComTencentAelightCameraAioeditorActivityRichmediaQzEditVideoPartManager.jdField_b_of_type_JavaLangString = paramIntent.getString("key_setting_raw_json");
              this.jdField_a_of_type_ComTencentAelightCameraAioeditorActivityRichmediaQzEditVideoPartManager.jdField_a_of_type_JavaLangString = paramIntent.getString("key_selected_tag");
            }
            b();
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
          this.jdField_a_of_type_ComTencentAelightCameraAioeditorActivityRichmediaQzEditVideoPartManager.jdField_c_of_type_JavaLangString = paramIntent;
          if (SlideShowPhotoListManager.a().b() == 22) {
            LpReportInfo_pf00064.allReport(680, 2, 8);
          }
        }
        if (localBundle.containsKey("contentIntentKeyForVideoEditWithEmo"))
        {
          paramIntent = localBundle.getString("contentIntentKeyForVideoEditWithEmo");
          this.jdField_a_of_type_ComTencentAelightCameraAioeditorActivityRichmediaViewExtendEditText.setText(paramIntent);
        }
        this.jdField_a_of_type_ComTencentAelightCameraAioeditorActivityRichmediaQzEditVideoPartManager.jdField_b_of_type_Int = localBundle.getInt("extra_key_font_id", -1);
        this.jdField_a_of_type_ComTencentAelightCameraAioeditorActivityRichmediaQzEditVideoPartManager.jdField_c_of_type_Int = localBundle.getInt("extra_key_font_format_type");
        this.jdField_a_of_type_ComTencentAelightCameraAioeditorActivityRichmediaQzEditVideoPartManager.jdField_d_of_type_JavaLangString = localBundle.getString("extra_key_font_url");
        this.jdField_a_of_type_ComTencentAelightCameraAioeditorActivityRichmediaQzEditVideoPartManager.jdField_d_of_type_Int = localBundle.getInt("extra_key_super_font_id", -1);
        this.jdField_a_of_type_ComTencentAelightCameraAioeditorActivityRichmediaQzEditVideoPartManager.jdField_e_of_type_JavaLangString = localBundle.getString("extra_key_super_font_info");
        h();
      }
    }
  }
  
  public void a(int paramInt, Object paramObject)
  {
    int j = 0;
    int i = 0;
    boolean bool;
    if (paramInt == 4) {
      bool = true;
    } else {
      bool = false;
    }
    this.jdField_a_of_type_Boolean = bool;
    if (paramInt != 0)
    {
      if (paramInt != 4)
      {
        if (paramInt != 5)
        {
          this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
          return;
        }
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
        return;
      }
      if ((this.jdField_a_of_type_ComTencentAelightCameraAioeditorActivityRichmediaQzEditVideoPartManager.jdField_d_of_type_Boolean) && (!this.jdField_a_of_type_Boolean)) {
        paramInt = i;
      } else {
        paramInt = 8;
      }
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(paramInt);
      return;
    }
    if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorActivityRichmediaQzEditVideoPartManager.jdField_d_of_type_Boolean) {
      paramInt = j;
    } else {
      paramInt = 8;
    }
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(paramInt);
  }
  
  protected boolean a(Message paramMessage)
  {
    if (paramMessage.what != 11)
    {
      this.jdField_a_of_type_Int = paramMessage.arg1;
      return super.a(paramMessage);
    }
    this.jdField_a_of_type_Long = ((Long)paramMessage.obj).longValue();
    return true;
  }
  
  public void b()
  {
    this.jdField_a_of_type_JavaLangString = UgcSettingUtil.getPrivacyDescriptionForShuoShuo(this.jdField_a_of_type_ComTencentAelightCameraAioeditorActivityRichmediaQzEditVideoPartManager.jdField_a_of_type_Int);
    this.jdField_a_of_type_AndroidWidgetButton.setText(this.jdField_a_of_type_JavaLangString);
  }
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_Long > System.currentTimeMillis()) {
      return;
    }
    int i = paramView.getId();
    paramView = "";
    Object localObject1;
    Object localObject2;
    Object localObject3;
    if (i == 2131367016)
    {
      paramView = QzoneConfig.getInstance().getConfig("H5Url", "UgcPermitSetting", "https://h5.qzone.qq.com/ugc/setting?_wv=3&type=mood&uin={uin}&qua={qua}&_proxy=1").replace("{uin}", QQStoryContext.a().a()).replace("{qua}", QUA.getQUA3());
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorActivityRichmediaQzEditVideoPartManager.a(3004);
      localObject1 = new Bundle();
      ((Bundle)localObject1).putInt("permission_code", this.jdField_a_of_type_ComTencentAelightCameraAioeditorActivityRichmediaQzEditVideoPartManager.jdField_a_of_type_Int);
      if ((this.jdField_a_of_type_ComTencentAelightCameraAioeditorActivityRichmediaQzEditVideoPartManager.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_ComTencentAelightCameraAioeditorActivityRichmediaQzEditVideoPartManager.jdField_a_of_type_JavaUtilArrayList.size() > 0))
      {
        ((Bundle)localObject1).putStringArrayList("uin_list", this.jdField_a_of_type_ComTencentAelightCameraAioeditorActivityRichmediaQzEditVideoPartManager.jdField_a_of_type_JavaUtilArrayList);
        localObject2 = new ArrayList(this.jdField_a_of_type_ComTencentAelightCameraAioeditorActivityRichmediaQzEditVideoPartManager.jdField_a_of_type_JavaUtilArrayList.size());
        localObject3 = this.jdField_a_of_type_ComTencentAelightCameraAioeditorActivityRichmediaQzEditVideoPartManager.jdField_a_of_type_JavaUtilArrayList.iterator();
        while (((Iterator)localObject3).hasNext()) {
          ((ArrayList)localObject2).add(a((String)((Iterator)localObject3).next()));
        }
        ((Bundle)localObject1).putStringArrayList("key_nicknames", (ArrayList)localObject2);
      }
      if ((a(this.jdField_a_of_type_ComTencentAelightCameraAioeditorActivityRichmediaQzEditVideoPartManager.jdField_a_of_type_Int)) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentAelightCameraAioeditorActivityRichmediaQzEditVideoPartManager.jdField_b_of_type_JavaLangString))) {
        ((Bundle)localObject1).putString("key_setting_raw_json", this.jdField_a_of_type_ComTencentAelightCameraAioeditorActivityRichmediaQzEditVideoPartManager.jdField_b_of_type_JavaLangString);
      }
      if (SlideShowPhotoListManager.a().b() == 22)
      {
        LpReportInfo_pf00064.allReport(680, 2, 4);
        LpReportInfo_pf00064.allReport(680, 5, 1);
      }
      QZoneHelper.forwardToBrowser((BaseActivity)this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoUi, paramView, 1, (Bundle)localObject1, "");
      return;
    }
    if (i == 2131366997)
    {
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorActivityRichmediaQzEditVideoPartManager.a(3001);
      localObject1 = QZoneHelper.UserInfo.getInstance();
      localObject2 = new Bundle();
      ((Bundle)localObject2).putInt("permission_code", this.jdField_a_of_type_ComTencentAelightCameraAioeditorActivityRichmediaQzEditVideoPartManager.jdField_a_of_type_Int);
      if ((this.jdField_a_of_type_ComTencentAelightCameraAioeditorActivityRichmediaQzEditVideoPartManager.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_ComTencentAelightCameraAioeditorActivityRichmediaQzEditVideoPartManager.jdField_a_of_type_JavaUtilArrayList.size() > 0))
      {
        ((Bundle)localObject2).putStringArrayList("uin_list", this.jdField_a_of_type_ComTencentAelightCameraAioeditorActivityRichmediaQzEditVideoPartManager.jdField_a_of_type_JavaUtilArrayList);
        localObject3 = new ArrayList(this.jdField_a_of_type_ComTencentAelightCameraAioeditorActivityRichmediaQzEditVideoPartManager.jdField_a_of_type_JavaUtilArrayList.size());
        Iterator localIterator = this.jdField_a_of_type_ComTencentAelightCameraAioeditorActivityRichmediaQzEditVideoPartManager.jdField_a_of_type_JavaUtilArrayList.iterator();
        while (localIterator.hasNext()) {
          ((ArrayList)localObject3).add(a((String)localIterator.next()));
        }
        ((Bundle)localObject2).putStringArrayList("key_nicknames", (ArrayList)localObject3);
      }
      if ((a(this.jdField_a_of_type_ComTencentAelightCameraAioeditorActivityRichmediaQzEditVideoPartManager.jdField_a_of_type_Int)) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentAelightCameraAioeditorActivityRichmediaQzEditVideoPartManager.jdField_b_of_type_JavaLangString))) {
        ((Bundle)localObject2).putString("key_setting_raw_json", this.jdField_a_of_type_ComTencentAelightCameraAioeditorActivityRichmediaQzEditVideoPartManager.jdField_b_of_type_JavaLangString);
      }
      ((Bundle)localObject2).putBoolean("is_need_auto_close_from_pri", true);
      if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorActivityRichmediaQzEditVideoPartManager.jdField_a_of_type_AndroidViewView != null) {
        this.jdField_a_of_type_ComTencentAelightCameraAioeditorActivityRichmediaQzEditVideoPartManager.jdField_a_of_type_AndroidViewView.setVisibility(0);
      }
      localObject3 = this.jdField_a_of_type_ComTencentAelightCameraAioeditorActivityRichmediaViewExtendEditText;
      if (localObject3 != null) {
        paramView = ((ExtendEditText)localObject3).getText().toString();
      }
      if (SlideShowPhotoListManager.a().b() == 22) {
        LpReportInfo_pf00064.allReport(680, 2, 3);
      }
      localObject3 = new Bundle();
      ((Bundle)localObject3).putBoolean("key_at_click_hide_keyboard", true);
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.a(Message.obtain(null, 21));
      QZoneHelper.forwardToVideoEditActionPanel((BaseActivity)this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoUi, (QZoneHelper.UserInfo)localObject1, 1009, "", paramView, "", "", 0, this.jdField_a_of_type_ComTencentAelightCameraAioeditorActivityRichmediaQzEditVideoPartManager.jdField_c_of_type_Boolean ^ true, 1, 0, 0, 0, "", 10000, (Bundle)localObject2, this.jdField_a_of_type_ComTencentAelightCameraAioeditorActivityRichmediaQzEditVideoPartManager.jdField_c_of_type_Boolean, this.jdField_a_of_type_ComTencentAelightCameraAioeditorActivityRichmediaQzEditVideoPartManager.jdField_b_of_type_Boolean, this.jdField_a_of_type_ComTencentAelightCameraAioeditorActivityRichmediaQzEditVideoPartManager.jdField_b_of_type_Int, this.jdField_a_of_type_ComTencentAelightCameraAioeditorActivityRichmediaQzEditVideoPartManager.jdField_d_of_type_Int, false, (Bundle)localObject3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.activity.richmedia.EditVideoQzComment
 * JD-Core Version:    0.7.0.1
 */