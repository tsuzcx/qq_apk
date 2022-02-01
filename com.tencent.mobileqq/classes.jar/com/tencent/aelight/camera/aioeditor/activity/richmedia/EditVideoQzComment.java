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
  public RelativeLayout a;
  private QzEditVideoPartManager b;
  private String c = UgcSettingUtil.getPrivacyDescriptionForShuoShuo(1);
  private CheckBox d;
  private ExtendEditText e;
  private Button f;
  private View g;
  private int h = 0;
  private boolean i;
  
  public EditVideoQzComment(@NonNull QzEditVideoPartManager paramQzEditVideoPartManager)
  {
    super(paramQzEditVideoPartManager);
    this.b = paramQzEditVideoPartManager;
  }
  
  private void a(long paramLong) {}
  
  public static boolean a(int paramInt)
  {
    return (paramInt == 16) || (paramInt == 128);
  }
  
  private boolean b(String paramString)
  {
    try
    {
      long l = Long.valueOf(paramString).longValue();
      a(l);
      paramString = ((IFontManager)QRoute.api(IFontManager.class)).getDefaultFont(l);
      if (paramString == null) {
        return false;
      }
      this.b.o = paramString.fontId;
      this.b.p = paramString.formatType;
      this.b.q = paramString.fontUrl;
      int j = this.b.o;
      return j > 0;
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
  
  private void c()
  {
    RelativeLayout localRelativeLayout1 = (RelativeLayout)d(2063991043);
    Object localObject = LayoutInflater.from(u());
    int j = 0;
    this.a = ((RelativeLayout)((LayoutInflater)localObject).inflate(2131628677, localRelativeLayout1, false));
    localObject = new RelativeLayout.LayoutParams(-1, AIOUtils.b(50.0F, s()));
    RelativeLayout localRelativeLayout2 = this.a;
    if (!this.b.k) {
      j = 8;
    }
    localRelativeLayout2.setVisibility(j);
    ((RelativeLayout.LayoutParams)localObject).addRule(12);
    if (LiuHaiUtils.j > 0) {
      j = LiuHaiUtils.j;
    } else {
      j = AIOUtils.b(60.0F, s());
    }
    ((RelativeLayout.LayoutParams)localObject).bottomMargin = j;
    localRelativeLayout1.addView(this.a, (ViewGroup.LayoutParams)localObject);
  }
  
  private void d()
  {
    Object localObject = this.e;
    if (localObject == null) {
      return;
    }
    ((ExtendEditText)localObject).setTextEffect(this.b.s);
    localObject = null;
    String str = ((IFontManager)QRoute.api(IFontManager.class)).getTrueTypeFont(this.b.o, null, null, true, null);
    if (TextUtils.isEmpty(str)) {
      this.b.o = -1;
    } else {
      localObject = Typeface.createFromFile(str);
    }
    this.e.setTypeface((Typeface)localObject);
  }
  
  /* Error */
  public String a(String paramString)
  {
    // Byte code:
    //   0: ldc 217
    //   2: astore 6
    //   4: invokestatic 223	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   7: invokevirtual 229	com/tencent/qphone/base/util/BaseApplication:getContentResolver	()Landroid/content/ContentResolver;
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
    //   28: new 98	java/lang/StringBuilder
    //   31: dup
    //   32: invokespecial 101	java/lang/StringBuilder:<init>	()V
    //   35: astore 9
    //   37: aload 4
    //   39: astore 5
    //   41: aload 6
    //   43: astore_3
    //   44: aload 7
    //   46: astore_2
    //   47: aload 9
    //   49: ldc 231
    //   51: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   54: pop
    //   55: aload 4
    //   57: astore 5
    //   59: aload 6
    //   61: astore_3
    //   62: aload 7
    //   64: astore_2
    //   65: aload 9
    //   67: aload_1
    //   68: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   71: pop
    //   72: aload 4
    //   74: astore 5
    //   76: aload 6
    //   78: astore_3
    //   79: aload 7
    //   81: astore_2
    //   82: aload 8
    //   84: aload 9
    //   86: invokevirtual 116	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   89: invokestatic 237	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   92: aconst_null
    //   93: ldc 239
    //   95: iconst_1
    //   96: anewarray 241	java/lang/String
    //   99: dup
    //   100: iconst_0
    //   101: aload_1
    //   102: aastore
    //   103: aconst_null
    //   104: invokevirtual 247	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
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
    //   134: invokeinterface 253 1 0
    //   139: ifeq +175 -> 314
    //   142: aload 7
    //   144: astore 5
    //   146: aload 6
    //   148: astore_3
    //   149: aload 7
    //   151: astore_2
    //   152: aload 7
    //   154: aload 7
    //   156: ldc 255
    //   158: invokeinterface 259 2 0
    //   163: invokeinterface 262 2 0
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
    //   185: invokestatic 202	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   188: ifne +32 -> 220
    //   191: aload 7
    //   193: astore 5
    //   195: aload 6
    //   197: astore_3
    //   198: aload 7
    //   200: astore_2
    //   201: new 241	java/lang/String
    //   204: dup
    //   205: aload 4
    //   207: invokevirtual 266	java/lang/String:getBytes	()[B
    //   210: ldc_w 268
    //   213: invokespecial 271	java/lang/String:<init>	([BLjava/lang/String;)V
    //   216: invokestatic 276	com/tencent/mobileqq/utils/SecurityUtile:decode	(Ljava/lang/String;)Ljava/lang/String;
    //   219: astore_1
    //   220: aload_1
    //   221: astore 4
    //   223: aload 7
    //   225: astore 5
    //   227: aload_1
    //   228: astore_3
    //   229: aload 7
    //   231: astore_2
    //   232: invokestatic 279	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   235: ifeq +79 -> 314
    //   238: aload 7
    //   240: astore 5
    //   242: aload_1
    //   243: astore_3
    //   244: aload 7
    //   246: astore_2
    //   247: new 98	java/lang/StringBuilder
    //   250: dup
    //   251: invokespecial 101	java/lang/StringBuilder:<init>	()V
    //   254: astore 4
    //   256: aload 7
    //   258: astore 5
    //   260: aload_1
    //   261: astore_3
    //   262: aload 7
    //   264: astore_2
    //   265: aload 4
    //   267: ldc_w 281
    //   270: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   273: pop
    //   274: aload 7
    //   276: astore 5
    //   278: aload_1
    //   279: astore_3
    //   280: aload 7
    //   282: astore_2
    //   283: aload 4
    //   285: aload_1
    //   286: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   289: pop
    //   290: aload 7
    //   292: astore 5
    //   294: aload_1
    //   295: astore_3
    //   296: aload 7
    //   298: astore_2
    //   299: ldc_w 283
    //   302: iconst_2
    //   303: aload 4
    //   305: invokevirtual 116	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   308: invokestatic 285	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
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
    //   329: invokeinterface 288 1 0
    //   334: aload_3
    //   335: areturn
    //   336: astore_1
    //   337: goto +76 -> 413
    //   340: astore_1
    //   341: aload_2
    //   342: astore 5
    //   344: invokestatic 279	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   347: ifeq +55 -> 402
    //   350: aload_2
    //   351: astore 5
    //   353: new 98	java/lang/StringBuilder
    //   356: dup
    //   357: invokespecial 101	java/lang/StringBuilder:<init>	()V
    //   360: astore 4
    //   362: aload_2
    //   363: astore 5
    //   365: aload 4
    //   367: ldc_w 290
    //   370: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   373: pop
    //   374: aload_2
    //   375: astore 5
    //   377: aload 4
    //   379: aload_1
    //   380: invokestatic 294	com/tencent/qphone/base/util/QLog:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   383: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   386: pop
    //   387: aload_2
    //   388: astore 5
    //   390: ldc_w 283
    //   393: iconst_2
    //   394: aload 4
    //   396: invokevirtual 116	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   399: invokestatic 121	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
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
    //   420: invokeinterface 288 1 0
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
    c();
    this.a = ((RelativeLayout)d(2131433444));
    this.d = ((CheckBox)d(2131433467));
    this.e = ((ExtendEditText)d(2131433445));
    this.f = ((Button)d(2131433464));
    this.g = d(2131433466);
    this.e.setEditableFactory(QzoneTextBuilder.a);
    this.e.setOnClickListener(this);
    this.f.setOnClickListener(this);
    if (!this.b.m) {
      this.f.setVisibility(8);
    }
    if ((this.b.j) || (this.b.l))
    {
      this.f.setVisibility(8);
      this.d.setVisibility(0);
      this.d.setOnCheckedChangeListener(new EditVideoQzComment.1(this));
      this.d.setChecked(true);
    }
    if (b(QQStoryContext.a().g())) {
      d();
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
          this.b.d = paramIntent.getInt("permission_code");
        }
        if (paramIntent.containsKey("uin_list"))
        {
          if (this.b.c == null) {
            this.b.c = new ArrayList();
          }
          this.b.c.clear();
          localObject = paramIntent.getStringArrayList("uin_list");
          if (localObject != null) {
            this.b.c.addAll((Collection)localObject);
          }
        }
        if (a(this.b.d))
        {
          this.b.f = paramIntent.getString("key_setting_raw_json");
          this.b.e = paramIntent.getString("key_selected_tag");
        }
        if (SlideShowPhotoListManager.a().e() == 22) {
          LpReportInfo_pf00064.allReport(680, 5, 2);
        }
        b();
        return;
      }
      if (SlideShowPhotoListManager.a().e() == 22) {
        LpReportInfo_pf00064.allReport(680, 5, 3);
      }
    }
    else if (paramInt1 == 1009)
    {
      if (this.b.b != null) {
        this.b.b.setVisibility(8);
      }
      this.t.a(Message.obtain(null, 22));
      if (paramIntent != null)
      {
        Bundle localBundle = paramIntent.getExtras();
        if (localBundle.containsKey("extra_key_bundle_priv_key"))
        {
          paramIntent = localBundle.getBundle("extra_key_bundle_priv_key");
          if (paramIntent != null)
          {
            this.b.d = paramIntent.getInt("permission_code");
            if (this.b.c == null) {
              this.b.c = new ArrayList();
            }
            this.b.c.clear();
            localObject = paramIntent.getStringArrayList("uin_list");
            if (localObject != null) {
              this.b.c.addAll((Collection)localObject);
            }
            if (a(this.b.d))
            {
              this.b.f = paramIntent.getString("key_setting_raw_json");
              this.b.e = paramIntent.getString("key_selected_tag");
            }
            b();
          }
        }
        if (localBundle.containsKey("extraIsTopicSyncQzone"))
        {
          boolean bool = localBundle.getBoolean("extraIsTopicSyncQzone");
          this.d.setChecked(bool);
        }
        if (localBundle.containsKey("contentIntentKey"))
        {
          localObject = localBundle.getString("contentIntentKey");
          paramIntent = (Intent)localObject;
          if (localObject == null) {
            paramIntent = "";
          }
          this.b.g = paramIntent;
          if (SlideShowPhotoListManager.a().e() == 22) {
            LpReportInfo_pf00064.allReport(680, 2, 8);
          }
        }
        if (localBundle.containsKey("contentIntentKeyForVideoEditWithEmo"))
        {
          paramIntent = localBundle.getString("contentIntentKeyForVideoEditWithEmo");
          this.e.setText(paramIntent);
        }
        this.b.o = localBundle.getInt("extra_key_font_id", -1);
        this.b.p = localBundle.getInt("extra_key_font_format_type");
        this.b.q = localBundle.getString("extra_key_font_url");
        this.b.r = localBundle.getInt("extra_key_super_font_id", -1);
        this.b.s = localBundle.getString("extra_key_super_font_info");
        d();
      }
    }
  }
  
  public void a(int paramInt, Object paramObject)
  {
    int k = 0;
    int j = 0;
    boolean bool;
    if (paramInt == 4) {
      bool = true;
    } else {
      bool = false;
    }
    this.i = bool;
    if (paramInt != 0)
    {
      if (paramInt != 4)
      {
        if (paramInt != 5)
        {
          this.a.setVisibility(8);
          return;
        }
        this.a.setVisibility(8);
        return;
      }
      if ((this.b.k) && (!this.i)) {
        paramInt = j;
      } else {
        paramInt = 8;
      }
      this.a.setVisibility(paramInt);
      return;
    }
    if (this.b.k) {
      paramInt = k;
    } else {
      paramInt = 8;
    }
    this.a.setVisibility(paramInt);
  }
  
  protected boolean a(Message paramMessage)
  {
    if (paramMessage.what != 11)
    {
      this.h = paramMessage.arg1;
      return super.a(paramMessage);
    }
    this.v = ((Long)paramMessage.obj).longValue();
    return true;
  }
  
  public void b()
  {
    this.c = UgcSettingUtil.getPrivacyDescriptionForShuoShuo(this.b.d);
    this.f.setText(this.c);
  }
  
  public void onClick(View paramView)
  {
    if (this.v > System.currentTimeMillis()) {
      return;
    }
    int j = paramView.getId();
    paramView = "";
    Object localObject1;
    Object localObject2;
    Object localObject3;
    if (j == 2131433464)
    {
      paramView = QzoneConfig.getInstance().getConfig("H5Url", "UgcPermitSetting", "https://h5.qzone.qq.com/ugc/setting?_wv=3&type=mood&uin={uin}&qua={qua}&_proxy=1").replace("{uin}", QQStoryContext.a().g()).replace("{qua}", QUA.getQUA3());
      this.b.a(3004);
      localObject1 = new Bundle();
      ((Bundle)localObject1).putInt("permission_code", this.b.d);
      if ((this.b.c != null) && (this.b.c.size() > 0))
      {
        ((Bundle)localObject1).putStringArrayList("uin_list", this.b.c);
        localObject2 = new ArrayList(this.b.c.size());
        localObject3 = this.b.c.iterator();
        while (((Iterator)localObject3).hasNext()) {
          ((ArrayList)localObject2).add(a((String)((Iterator)localObject3).next()));
        }
        ((Bundle)localObject1).putStringArrayList("key_nicknames", (ArrayList)localObject2);
      }
      if ((a(this.b.d)) && (!TextUtils.isEmpty(this.b.f))) {
        ((Bundle)localObject1).putString("key_setting_raw_json", this.b.f);
      }
      if (SlideShowPhotoListManager.a().e() == 22)
      {
        LpReportInfo_pf00064.allReport(680, 2, 4);
        LpReportInfo_pf00064.allReport(680, 5, 1);
      }
      QZoneHelper.forwardToBrowser((BaseActivity)this.u, paramView, 1, (Bundle)localObject1, "");
      return;
    }
    if (j == 2131433445)
    {
      this.b.a(3001);
      localObject1 = QZoneHelper.UserInfo.getInstance();
      localObject2 = new Bundle();
      ((Bundle)localObject2).putInt("permission_code", this.b.d);
      if ((this.b.c != null) && (this.b.c.size() > 0))
      {
        ((Bundle)localObject2).putStringArrayList("uin_list", this.b.c);
        localObject3 = new ArrayList(this.b.c.size());
        Iterator localIterator = this.b.c.iterator();
        while (localIterator.hasNext()) {
          ((ArrayList)localObject3).add(a((String)localIterator.next()));
        }
        ((Bundle)localObject2).putStringArrayList("key_nicknames", (ArrayList)localObject3);
      }
      if ((a(this.b.d)) && (!TextUtils.isEmpty(this.b.f))) {
        ((Bundle)localObject2).putString("key_setting_raw_json", this.b.f);
      }
      ((Bundle)localObject2).putBoolean("is_need_auto_close_from_pri", true);
      if (this.b.b != null) {
        this.b.b.setVisibility(0);
      }
      localObject3 = this.e;
      if (localObject3 != null) {
        paramView = ((ExtendEditText)localObject3).getText().toString();
      }
      if (SlideShowPhotoListManager.a().e() == 22) {
        LpReportInfo_pf00064.allReport(680, 2, 3);
      }
      localObject3 = new Bundle();
      ((Bundle)localObject3).putBoolean("key_at_click_hide_keyboard", true);
      this.t.a(Message.obtain(null, 21));
      QZoneHelper.forwardToVideoEditActionPanel((BaseActivity)this.u, (QZoneHelper.UserInfo)localObject1, 1009, "", paramView, "", "", 0, this.b.j ^ true, 1, 0, 0, 0, "", 10000, (Bundle)localObject2, this.b.j, this.b.i, this.b.o, this.b.r, false, (Bundle)localObject3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.activity.richmedia.EditVideoQzComment
 * JD-Core Version:    0.7.0.1
 */