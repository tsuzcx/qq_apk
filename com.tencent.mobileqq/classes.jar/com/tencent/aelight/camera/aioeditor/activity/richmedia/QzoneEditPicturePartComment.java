package com.tencent.aelight.camera.aioeditor.activity.richmedia;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Message;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RelativeLayout;
import com.tencent.aelight.camera.aioeditor.activity.richmedia.view.ExtendEditText;
import com.tencent.aelight.camera.aioeditor.takevideo.EditVideoPart;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.text.QzoneTextBuilder;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qzonehub.api.font.IFontManager;
import common.config.service.QzoneConfig;
import cooperation.qzone.QUA;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QZoneHelper.UserInfo;
import cooperation.qzone.font.DefaultFontInfo;
import cooperation.qzone.webviewplugin.ugcsetting.UgcSettingUtil;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class QzoneEditPicturePartComment
  extends EditVideoPart
  implements View.OnClickListener
{
  private int jdField_a_of_type_Int = 0;
  private View jdField_a_of_type_AndroidViewView;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private CheckBox jdField_a_of_type_AndroidWidgetCheckBox;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private QzoneEditPicturePartManager jdField_a_of_type_ComTencentAelightCameraAioeditorActivityRichmediaQzoneEditPicturePartManager;
  private ExtendEditText jdField_a_of_type_ComTencentAelightCameraAioeditorActivityRichmediaViewExtendEditText;
  private String jdField_a_of_type_JavaLangString = UgcSettingUtil.getPrivacyDescriptionForShuoShuo(1);
  
  public QzoneEditPicturePartComment(@NonNull QzoneEditPicturePartManager paramQzoneEditPicturePartManager)
  {
    super(paramQzoneEditPicturePartManager);
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorActivityRichmediaQzoneEditPicturePartManager = paramQzoneEditPicturePartManager;
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
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorActivityRichmediaQzoneEditPicturePartManager.jdField_b_of_type_Int = paramString.fontId;
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorActivityRichmediaQzoneEditPicturePartManager.jdField_c_of_type_Int = paramString.formatType;
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorActivityRichmediaQzoneEditPicturePartManager.jdField_d_of_type_JavaLangString = paramString.fontUrl;
      int i = this.jdField_a_of_type_ComTencentAelightCameraAioeditorActivityRichmediaQzoneEditPicturePartManager.jdField_b_of_type_Int;
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
    Object localObject = this.jdField_a_of_type_ComTencentAelightCameraAioeditorActivityRichmediaViewExtendEditText;
    if (localObject == null) {
      return;
    }
    ((ExtendEditText)localObject).setTextEffect(this.jdField_a_of_type_ComTencentAelightCameraAioeditorActivityRichmediaQzoneEditPicturePartManager.jdField_e_of_type_JavaLangString);
    localObject = null;
    String str = ((IFontManager)QRoute.api(IFontManager.class)).getTrueTypeFont(this.jdField_a_of_type_ComTencentAelightCameraAioeditorActivityRichmediaQzoneEditPicturePartManager.jdField_b_of_type_Int, null, null, true, null);
    if (TextUtils.isEmpty(str)) {
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorActivityRichmediaQzoneEditPicturePartManager.jdField_b_of_type_Int = -1;
    } else {
      localObject = Typeface.createFromFile(str);
    }
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorActivityRichmediaViewExtendEditText.setTypeface((Typeface)localObject);
  }
  
  /* Error */
  public String a(String paramString)
  {
    // Byte code:
    //   0: ldc 149
    //   2: astore 6
    //   4: invokestatic 155	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   7: invokevirtual 161	com/tencent/qphone/base/util/BaseApplication:getContentResolver	()Landroid/content/ContentResolver;
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
    //   28: new 89	java/lang/StringBuilder
    //   31: dup
    //   32: invokespecial 92	java/lang/StringBuilder:<init>	()V
    //   35: astore 9
    //   37: aload 4
    //   39: astore 5
    //   41: aload 6
    //   43: astore_3
    //   44: aload 7
    //   46: astore_2
    //   47: aload 9
    //   49: ldc 163
    //   51: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   54: pop
    //   55: aload 4
    //   57: astore 5
    //   59: aload 6
    //   61: astore_3
    //   62: aload 7
    //   64: astore_2
    //   65: aload 9
    //   67: aload_1
    //   68: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   71: pop
    //   72: aload 4
    //   74: astore 5
    //   76: aload 6
    //   78: astore_3
    //   79: aload 7
    //   81: astore_2
    //   82: aload 8
    //   84: aload 9
    //   86: invokevirtual 107	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   89: invokestatic 169	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   92: aconst_null
    //   93: ldc 171
    //   95: iconst_1
    //   96: anewarray 173	java/lang/String
    //   99: dup
    //   100: iconst_0
    //   101: aload_1
    //   102: aastore
    //   103: aconst_null
    //   104: invokevirtual 179	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   107: astore 7
    //   109: aload 6
    //   111: astore 4
    //   113: aload 7
    //   115: ifnull +196 -> 311
    //   118: aload 6
    //   120: astore 4
    //   122: aload 7
    //   124: astore 5
    //   126: aload 6
    //   128: astore_3
    //   129: aload 7
    //   131: astore_2
    //   132: aload 7
    //   134: invokeinterface 185 1 0
    //   139: ifeq +172 -> 311
    //   142: aload 7
    //   144: astore 5
    //   146: aload 6
    //   148: astore_3
    //   149: aload 7
    //   151: astore_2
    //   152: aload 7
    //   154: aload 7
    //   156: ldc 187
    //   158: invokeinterface 191 2 0
    //   163: invokeinterface 194 2 0
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
    //   185: invokestatic 134	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   188: ifne +31 -> 219
    //   191: aload 7
    //   193: astore 5
    //   195: aload 6
    //   197: astore_3
    //   198: aload 7
    //   200: astore_2
    //   201: new 173	java/lang/String
    //   204: dup
    //   205: aload 4
    //   207: invokevirtual 198	java/lang/String:getBytes	()[B
    //   210: ldc 200
    //   212: invokespecial 203	java/lang/String:<init>	([BLjava/lang/String;)V
    //   215: invokestatic 208	com/tencent/mobileqq/utils/SecurityUtile:decode	(Ljava/lang/String;)Ljava/lang/String;
    //   218: astore_1
    //   219: aload_1
    //   220: astore 4
    //   222: aload 7
    //   224: astore 5
    //   226: aload_1
    //   227: astore_3
    //   228: aload 7
    //   230: astore_2
    //   231: invokestatic 211	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   234: ifeq +77 -> 311
    //   237: aload 7
    //   239: astore 5
    //   241: aload_1
    //   242: astore_3
    //   243: aload 7
    //   245: astore_2
    //   246: new 89	java/lang/StringBuilder
    //   249: dup
    //   250: invokespecial 92	java/lang/StringBuilder:<init>	()V
    //   253: astore 4
    //   255: aload 7
    //   257: astore 5
    //   259: aload_1
    //   260: astore_3
    //   261: aload 7
    //   263: astore_2
    //   264: aload 4
    //   266: ldc 213
    //   268: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   271: pop
    //   272: aload 7
    //   274: astore 5
    //   276: aload_1
    //   277: astore_3
    //   278: aload 7
    //   280: astore_2
    //   281: aload 4
    //   283: aload_1
    //   284: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   287: pop
    //   288: aload 7
    //   290: astore 5
    //   292: aload_1
    //   293: astore_3
    //   294: aload 7
    //   296: astore_2
    //   297: ldc 215
    //   299: iconst_2
    //   300: aload 4
    //   302: invokevirtual 107	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   305: invokestatic 218	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   308: aload_1
    //   309: astore 4
    //   311: aload 4
    //   313: astore_1
    //   314: aload 7
    //   316: ifnull +90 -> 406
    //   319: aload 7
    //   321: astore_2
    //   322: aload 4
    //   324: astore_3
    //   325: aload_2
    //   326: invokeinterface 221 1 0
    //   331: aload_3
    //   332: areturn
    //   333: astore_1
    //   334: goto +74 -> 408
    //   337: astore_1
    //   338: aload_2
    //   339: astore 5
    //   341: invokestatic 211	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   344: ifeq +53 -> 397
    //   347: aload_2
    //   348: astore 5
    //   350: new 89	java/lang/StringBuilder
    //   353: dup
    //   354: invokespecial 92	java/lang/StringBuilder:<init>	()V
    //   357: astore 4
    //   359: aload_2
    //   360: astore 5
    //   362: aload 4
    //   364: ldc 223
    //   366: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   369: pop
    //   370: aload_2
    //   371: astore 5
    //   373: aload 4
    //   375: aload_1
    //   376: invokestatic 227	com/tencent/qphone/base/util/QLog:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   379: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   382: pop
    //   383: aload_2
    //   384: astore 5
    //   386: ldc 215
    //   388: iconst_2
    //   389: aload 4
    //   391: invokevirtual 107	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   394: invokestatic 113	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   397: aload_3
    //   398: astore_1
    //   399: aload_2
    //   400: ifnull +6 -> 406
    //   403: goto -78 -> 325
    //   406: aload_1
    //   407: areturn
    //   408: aload 5
    //   410: ifnull +10 -> 420
    //   413: aload 5
    //   415: invokeinterface 221 1 0
    //   420: goto +5 -> 425
    //   423: aload_1
    //   424: athrow
    //   425: goto -2 -> 423
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	428	0	this	QzoneEditPicturePartComment
    //   0	428	1	paramString	String
    //   27	373	2	localCursor1	android.database.Cursor
    //   24	374	3	localObject1	Object
    //   16	374	4	localObject2	Object
    //   20	394	5	localObject3	Object
    //   2	194	6	str	String
    //   13	307	7	localCursor2	android.database.Cursor
    //   10	73	8	localContentResolver	android.content.ContentResolver
    //   35	50	9	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   28	37	333	finally
    //   47	55	333	finally
    //   65	72	333	finally
    //   82	109	333	finally
    //   132	142	333	finally
    //   152	170	333	finally
    //   183	191	333	finally
    //   201	219	333	finally
    //   231	237	333	finally
    //   246	255	333	finally
    //   264	272	333	finally
    //   281	288	333	finally
    //   297	308	333	finally
    //   341	347	333	finally
    //   350	359	333	finally
    //   362	370	333	finally
    //   373	383	333	finally
    //   386	397	333	finally
    //   28	37	337	java/lang/Exception
    //   47	55	337	java/lang/Exception
    //   65	72	337	java/lang/Exception
    //   82	109	337	java/lang/Exception
    //   132	142	337	java/lang/Exception
    //   152	170	337	java/lang/Exception
    //   183	191	337	java/lang/Exception
    //   201	219	337	java/lang/Exception
    //   231	237	337	java/lang/Exception
    //   246	255	337	java/lang/Exception
    //   264	272	337	java/lang/Exception
    //   281	288	337	java/lang/Exception
    //   297	308	337	java/lang/Exception
  }
  
  public void a()
  {
    super.a();
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)a(2131366996));
    this.jdField_a_of_type_AndroidWidgetCheckBox = ((CheckBox)a(2131367019));
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorActivityRichmediaViewExtendEditText = ((ExtendEditText)a(2131366997));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)a(2131367016));
    this.jdField_a_of_type_AndroidViewView = a(2131367018);
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorActivityRichmediaViewExtendEditText.setEditableFactory(QzoneTextBuilder.a);
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorActivityRichmediaViewExtendEditText.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    if (!this.jdField_a_of_type_ComTencentAelightCameraAioeditorActivityRichmediaQzoneEditPicturePartManager.jdField_e_of_type_Boolean) {
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
    }
    if ((this.jdField_a_of_type_ComTencentAelightCameraAioeditorActivityRichmediaQzoneEditPicturePartManager.jdField_b_of_type_Boolean) || (this.jdField_a_of_type_ComTencentAelightCameraAioeditorActivityRichmediaQzoneEditPicturePartManager.jdField_d_of_type_Boolean))
    {
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetCheckBox.setOnCheckedChangeListener(new QzoneEditPicturePartComment.1(this));
      this.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(true);
    }
    if (a(QQStoryContext.a().a())) {
      g();
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
        QLog.d("EditPicQzComment", 2, ((StringBuilder)localObject).toString());
      }
      if ((paramIntent != null) && (paramIntent.getExtras() != null))
      {
        paramIntent = paramIntent.getExtras();
        if (paramIntent.containsKey("permission_code")) {
          this.jdField_a_of_type_ComTencentAelightCameraAioeditorActivityRichmediaQzoneEditPicturePartManager.jdField_a_of_type_Int = paramIntent.getInt("permission_code");
        }
        if (paramIntent.containsKey("uin_list"))
        {
          if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorActivityRichmediaQzoneEditPicturePartManager.jdField_a_of_type_JavaUtilArrayList == null) {
            this.jdField_a_of_type_ComTencentAelightCameraAioeditorActivityRichmediaQzoneEditPicturePartManager.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
          }
          this.jdField_a_of_type_ComTencentAelightCameraAioeditorActivityRichmediaQzoneEditPicturePartManager.jdField_a_of_type_JavaUtilArrayList.clear();
          localObject = paramIntent.getStringArrayList("uin_list");
          if (localObject != null) {
            this.jdField_a_of_type_ComTencentAelightCameraAioeditorActivityRichmediaQzoneEditPicturePartManager.jdField_a_of_type_JavaUtilArrayList.addAll((Collection)localObject);
          }
        }
        if (a(this.jdField_a_of_type_ComTencentAelightCameraAioeditorActivityRichmediaQzoneEditPicturePartManager.jdField_a_of_type_Int))
        {
          this.jdField_a_of_type_ComTencentAelightCameraAioeditorActivityRichmediaQzoneEditPicturePartManager.jdField_b_of_type_JavaLangString = paramIntent.getString("key_setting_raw_json");
          this.jdField_a_of_type_ComTencentAelightCameraAioeditorActivityRichmediaQzoneEditPicturePartManager.jdField_a_of_type_JavaLangString = paramIntent.getString("key_selected_tag");
        }
        b();
      }
    }
    else if (paramInt1 == 1009)
    {
      if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorActivityRichmediaQzoneEditPicturePartManager.jdField_a_of_type_AndroidViewView != null) {
        this.jdField_a_of_type_ComTencentAelightCameraAioeditorActivityRichmediaQzoneEditPicturePartManager.jdField_a_of_type_AndroidViewView.setVisibility(8);
      }
      if ((paramIntent != null) && (paramIntent.getExtras() != null))
      {
        Bundle localBundle = paramIntent.getExtras();
        if (localBundle.containsKey("extra_key_bundle_priv_key"))
        {
          paramIntent = localBundle.getBundle("extra_key_bundle_priv_key");
          if (paramIntent != null)
          {
            this.jdField_a_of_type_ComTencentAelightCameraAioeditorActivityRichmediaQzoneEditPicturePartManager.jdField_a_of_type_Int = paramIntent.getInt("permission_code");
            if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorActivityRichmediaQzoneEditPicturePartManager.jdField_a_of_type_JavaUtilArrayList == null) {
              this.jdField_a_of_type_ComTencentAelightCameraAioeditorActivityRichmediaQzoneEditPicturePartManager.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
            }
            this.jdField_a_of_type_ComTencentAelightCameraAioeditorActivityRichmediaQzoneEditPicturePartManager.jdField_a_of_type_JavaUtilArrayList.clear();
            localObject = paramIntent.getStringArrayList("uin_list");
            if (localObject != null) {
              this.jdField_a_of_type_ComTencentAelightCameraAioeditorActivityRichmediaQzoneEditPicturePartManager.jdField_a_of_type_JavaUtilArrayList.addAll((Collection)localObject);
            }
            if (a(this.jdField_a_of_type_ComTencentAelightCameraAioeditorActivityRichmediaQzoneEditPicturePartManager.jdField_a_of_type_Int))
            {
              this.jdField_a_of_type_ComTencentAelightCameraAioeditorActivityRichmediaQzoneEditPicturePartManager.jdField_b_of_type_JavaLangString = paramIntent.getString("key_setting_raw_json");
              this.jdField_a_of_type_ComTencentAelightCameraAioeditorActivityRichmediaQzoneEditPicturePartManager.jdField_a_of_type_JavaLangString = paramIntent.getString("key_selected_tag");
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
          this.jdField_a_of_type_ComTencentAelightCameraAioeditorActivityRichmediaQzoneEditPicturePartManager.jdField_c_of_type_JavaLangString = paramIntent;
        }
        if (localBundle.containsKey("contentIntentKeyForVideoEditWithEmo"))
        {
          paramIntent = localBundle.getString("contentIntentKeyForVideoEditWithEmo");
          this.jdField_a_of_type_ComTencentAelightCameraAioeditorActivityRichmediaViewExtendEditText.setText(paramIntent);
        }
        this.jdField_a_of_type_ComTencentAelightCameraAioeditorActivityRichmediaQzoneEditPicturePartManager.jdField_b_of_type_Int = localBundle.getInt("extra_key_font_id", -1);
        this.jdField_a_of_type_ComTencentAelightCameraAioeditorActivityRichmediaQzoneEditPicturePartManager.jdField_c_of_type_Int = localBundle.getInt("extra_key_font_format_type");
        this.jdField_a_of_type_ComTencentAelightCameraAioeditorActivityRichmediaQzoneEditPicturePartManager.jdField_d_of_type_JavaLangString = localBundle.getString("extra_key_font_url");
        this.jdField_a_of_type_ComTencentAelightCameraAioeditorActivityRichmediaQzoneEditPicturePartManager.jdField_d_of_type_Int = localBundle.getInt("extra_key_super_font_id", -1);
        this.jdField_a_of_type_ComTencentAelightCameraAioeditorActivityRichmediaQzoneEditPicturePartManager.jdField_e_of_type_JavaLangString = localBundle.getString("extra_key_super_font_info");
        g();
      }
    }
  }
  
  public void a(int paramInt, Object paramObject)
  {
    int i = 8;
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
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      return;
    }
    paramObject = this.jdField_a_of_type_AndroidWidgetRelativeLayout;
    paramInt = i;
    if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorActivityRichmediaQzoneEditPicturePartManager.jdField_c_of_type_Boolean) {
      paramInt = 0;
    }
    paramObject.setVisibility(paramInt);
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
    this.jdField_a_of_type_JavaLangString = UgcSettingUtil.getPrivacyDescriptionForShuoShuo(this.jdField_a_of_type_ComTencentAelightCameraAioeditorActivityRichmediaQzoneEditPicturePartManager.jdField_a_of_type_Int);
    this.jdField_a_of_type_AndroidWidgetButton.setText(this.jdField_a_of_type_JavaLangString);
  }
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_Long > System.currentTimeMillis()) {
      return;
    }
    int i = paramView.getId();
    Bundle localBundle;
    Object localObject;
    Iterator localIterator;
    if (i == 2131367016)
    {
      paramView = QzoneConfig.getInstance().getConfig("H5Url", "UgcPermitSetting", "https://h5.qzone.qq.com/ugc/setting?_wv=3&type=mood&uin={uin}&qua={qua}&_proxy=1").replace("{uin}", QQStoryContext.a().a()).replace("{qua}", QUA.getQUA3());
      ((QzoneEditPicturePartManager)this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager).a(3004);
      localBundle = new Bundle();
      localBundle.putInt("permission_code", this.jdField_a_of_type_ComTencentAelightCameraAioeditorActivityRichmediaQzoneEditPicturePartManager.jdField_a_of_type_Int);
      if ((this.jdField_a_of_type_ComTencentAelightCameraAioeditorActivityRichmediaQzoneEditPicturePartManager.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_ComTencentAelightCameraAioeditorActivityRichmediaQzoneEditPicturePartManager.jdField_a_of_type_JavaUtilArrayList.size() > 0))
      {
        localBundle.putStringArrayList("uin_list", this.jdField_a_of_type_ComTencentAelightCameraAioeditorActivityRichmediaQzoneEditPicturePartManager.jdField_a_of_type_JavaUtilArrayList);
        localObject = new ArrayList(this.jdField_a_of_type_ComTencentAelightCameraAioeditorActivityRichmediaQzoneEditPicturePartManager.jdField_a_of_type_JavaUtilArrayList.size());
        localIterator = this.jdField_a_of_type_ComTencentAelightCameraAioeditorActivityRichmediaQzoneEditPicturePartManager.jdField_a_of_type_JavaUtilArrayList.iterator();
        while (localIterator.hasNext()) {
          ((ArrayList)localObject).add(a((String)localIterator.next()));
        }
        localBundle.putStringArrayList("key_nicknames", (ArrayList)localObject);
      }
      if ((a(this.jdField_a_of_type_ComTencentAelightCameraAioeditorActivityRichmediaQzoneEditPicturePartManager.jdField_a_of_type_Int)) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentAelightCameraAioeditorActivityRichmediaQzoneEditPicturePartManager.jdField_b_of_type_JavaLangString))) {
        localBundle.putString("key_setting_raw_json", this.jdField_a_of_type_ComTencentAelightCameraAioeditorActivityRichmediaQzoneEditPicturePartManager.jdField_b_of_type_JavaLangString);
      }
      QZoneHelper.forwardToBrowser((BaseActivity)this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoUi, paramView, 1, localBundle, "");
      return;
    }
    if (i == 2131366997)
    {
      ((QzoneEditPicturePartManager)this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager).a(3001);
      paramView = QZoneHelper.UserInfo.getInstance();
      localBundle = new Bundle();
      localBundle.putInt("permission_code", this.jdField_a_of_type_ComTencentAelightCameraAioeditorActivityRichmediaQzoneEditPicturePartManager.jdField_a_of_type_Int);
      if ((this.jdField_a_of_type_ComTencentAelightCameraAioeditorActivityRichmediaQzoneEditPicturePartManager.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_ComTencentAelightCameraAioeditorActivityRichmediaQzoneEditPicturePartManager.jdField_a_of_type_JavaUtilArrayList.size() > 0))
      {
        localBundle.putStringArrayList("uin_list", this.jdField_a_of_type_ComTencentAelightCameraAioeditorActivityRichmediaQzoneEditPicturePartManager.jdField_a_of_type_JavaUtilArrayList);
        localObject = new ArrayList(this.jdField_a_of_type_ComTencentAelightCameraAioeditorActivityRichmediaQzoneEditPicturePartManager.jdField_a_of_type_JavaUtilArrayList.size());
        localIterator = this.jdField_a_of_type_ComTencentAelightCameraAioeditorActivityRichmediaQzoneEditPicturePartManager.jdField_a_of_type_JavaUtilArrayList.iterator();
        while (localIterator.hasNext()) {
          ((ArrayList)localObject).add(a((String)localIterator.next()));
        }
        localBundle.putStringArrayList("key_nicknames", (ArrayList)localObject);
      }
      if ((a(this.jdField_a_of_type_ComTencentAelightCameraAioeditorActivityRichmediaQzoneEditPicturePartManager.jdField_a_of_type_Int)) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentAelightCameraAioeditorActivityRichmediaQzoneEditPicturePartManager.jdField_b_of_type_JavaLangString))) {
        localBundle.putString("key_setting_raw_json", this.jdField_a_of_type_ComTencentAelightCameraAioeditorActivityRichmediaQzoneEditPicturePartManager.jdField_b_of_type_JavaLangString);
      }
      if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorActivityRichmediaQzoneEditPicturePartManager.jdField_a_of_type_AndroidViewView != null) {
        this.jdField_a_of_type_ComTencentAelightCameraAioeditorActivityRichmediaQzoneEditPicturePartManager.jdField_a_of_type_AndroidViewView.setVisibility(0);
      }
      localObject = new Bundle();
      ((Bundle)localObject).putBoolean("key_at_click_hide_keyboard", true);
      QZoneHelper.forwardToVideoEditActionPanel((BaseActivity)this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoUi, paramView, 1009, "", this.jdField_a_of_type_ComTencentAelightCameraAioeditorActivityRichmediaQzoneEditPicturePartManager.jdField_c_of_type_JavaLangString, "", "", 0, this.jdField_a_of_type_ComTencentAelightCameraAioeditorActivityRichmediaQzoneEditPicturePartManager.jdField_b_of_type_Boolean ^ true, 1, 0, 0, 0, "", 10000, localBundle, this.jdField_a_of_type_ComTencentAelightCameraAioeditorActivityRichmediaQzoneEditPicturePartManager.jdField_b_of_type_Boolean, this.jdField_a_of_type_ComTencentAelightCameraAioeditorActivityRichmediaQzoneEditPicturePartManager.jdField_a_of_type_Boolean, this.jdField_a_of_type_ComTencentAelightCameraAioeditorActivityRichmediaQzoneEditPicturePartManager.jdField_b_of_type_Int, this.jdField_a_of_type_ComTencentAelightCameraAioeditorActivityRichmediaQzoneEditPicturePartManager.jdField_d_of_type_Int, true, (Bundle)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.activity.richmedia.QzoneEditPicturePartComment
 * JD-Core Version:    0.7.0.1
 */