package com.tencent.biz.pubaccount.readinjoy.rebuild.cmp;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import bgln;
import bkhe;
import com.tencent.biz.pubaccount.readinjoy.notecard.SoundCheckRunnable;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyXListView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.dinifly.LottieDrawable;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import mqq.app.AppRuntime;
import mue;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import pka;
import pxk;
import pzo;
import pzp;
import qqr;
import qrb;
import qvv;
import qvw;
import qvx;
import rgj;
import smv;
import snh;

public class ComponentContentNoteCard
  extends RelativeLayout
  implements bkhe, pzp, qqr, smv
{
  private int jdField_a_of_type_Int = 0;
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private SoundCheckRunnable jdField_a_of_type_ComTencentBizPubaccountReadinjoyNotecardSoundCheckRunnable;
  private ComponentNotIntrest jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentNotIntrest;
  private ReadInJoyXListView jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView;
  private LottieDrawable jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable;
  private Object jdField_a_of_type_JavaLangObject;
  private rgj jdField_a_of_type_Rgj;
  private boolean jdField_a_of_type_Boolean;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private boolean jdField_b_of_type_Boolean;
  private ImageView jdField_c_of_type_AndroidWidgetImageView;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private ImageView jdField_d_of_type_AndroidWidgetImageView;
  private TextView jdField_d_of_type_AndroidWidgetTextView;
  
  public ComponentContentNoteCard(Context paramContext)
  {
    super(paramContext);
  }
  
  public ComponentContentNoteCard(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public ComponentContentNoteCard(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public ComponentContentNoteCard(Context paramContext, snh paramsnh)
  {
    super(paramContext);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView = ((ReadInJoyXListView)paramsnh.a());
    a(paramContext);
  }
  
  private SpannableStringBuilder a(JSONArray paramJSONArray)
  {
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    int i = 0;
    while (i < paramJSONArray.length())
    {
      Object localObject = new JSONObject(paramJSONArray.get(i).toString());
      String str = ((JSONObject)localObject).optString("word", "    ");
      int j = Color.parseColor(((JSONObject)localObject).optString("color", "#C3C0D6"));
      int k = Integer.valueOf(((JSONObject)localObject).optString("size", "15")).intValue();
      localObject = new SpannableString(str);
      ((SpannableString)localObject).setSpan(new ForegroundColorSpan(j), 0, str.length(), 33);
      ((SpannableString)localObject).setSpan(new AbsoluteSizeSpan(k, true), 0, str.length(), 33);
      localSpannableStringBuilder.append((CharSequence)localObject);
      i += 1;
    }
    return localSpannableStringBuilder;
  }
  
  private String a(JSONObject paramJSONObject, String paramString)
  {
    return paramJSONObject.get(paramString).toString();
  }
  
  private void a(ImageView paramImageView, String paramString)
  {
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mLoadingDrawable = new ColorDrawable(0);
    Object localObject = null;
    try
    {
      paramString = URLDrawable.getDrawable(paramString, localURLDrawableOptions);
      if (paramString != null) {
        paramImageView.setImageDrawable(paramString);
      }
      return;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        paramString = localObject;
      }
    }
  }
  
  /* Error */
  private void a(TextView paramTextView, JSONObject paramJSONObject, float paramFloat)
  {
    // Byte code:
    //   0: ldc 187
    //   2: fstore 5
    //   4: fconst_0
    //   5: fstore 7
    //   7: aload_1
    //   8: ifnull +7 -> 15
    //   11: aload_2
    //   12: ifnonnull +4 -> 16
    //   15: return
    //   16: new 74	org/json/JSONArray
    //   19: dup
    //   20: invokespecial 188	org/json/JSONArray:<init>	()V
    //   23: astore 11
    //   25: aload_2
    //   26: ldc 190
    //   28: invokevirtual 194	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   31: astore 10
    //   33: aload 10
    //   35: astore 11
    //   37: aload_0
    //   38: aload_2
    //   39: ldc 196
    //   41: invokespecial 198	com/tencent/biz/pubaccount/readinjoy/rebuild/cmp/ComponentContentNoteCard:a	(Lorg/json/JSONObject;Ljava/lang/String;)Ljava/lang/String;
    //   44: astore 10
    //   46: aload_0
    //   47: aload_2
    //   48: ldc 200
    //   50: invokespecial 198	com/tencent/biz/pubaccount/readinjoy/rebuild/cmp/ComponentContentNoteCard:a	(Lorg/json/JSONObject;Ljava/lang/String;)Ljava/lang/String;
    //   53: astore 12
    //   55: aload_0
    //   56: aload_2
    //   57: ldc 202
    //   59: invokespecial 198	com/tencent/biz/pubaccount/readinjoy/rebuild/cmp/ComponentContentNoteCard:a	(Lorg/json/JSONObject;Ljava/lang/String;)Ljava/lang/String;
    //   62: invokestatic 207	java/lang/Float:valueOf	(Ljava/lang/String;)Ljava/lang/Float;
    //   65: invokevirtual 211	java/lang/Float:floatValue	()F
    //   68: fstore 6
    //   70: fload 6
    //   72: fstore 4
    //   74: aload_0
    //   75: aload_2
    //   76: ldc 213
    //   78: invokespecial 198	com/tencent/biz/pubaccount/readinjoy/rebuild/cmp/ComponentContentNoteCard:a	(Lorg/json/JSONObject;Ljava/lang/String;)Ljava/lang/String;
    //   81: invokestatic 207	java/lang/Float:valueOf	(Ljava/lang/String;)Ljava/lang/Float;
    //   84: invokevirtual 211	java/lang/Float:floatValue	()F
    //   87: fstore 8
    //   89: fload 8
    //   91: fstore 5
    //   93: fload 6
    //   95: fstore 4
    //   97: aload_0
    //   98: invokevirtual 217	com/tencent/biz/pubaccount/readinjoy/rebuild/cmp/ComponentContentNoteCard:getContext	()Landroid/content/Context;
    //   101: fload 6
    //   103: invokestatic 222	zby:b	(Landroid/content/Context;F)I
    //   106: i2f
    //   107: fstore 6
    //   109: fload 8
    //   111: fstore 5
    //   113: fload 6
    //   115: fstore 4
    //   117: aload_0
    //   118: invokevirtual 217	com/tencent/biz/pubaccount/readinjoy/rebuild/cmp/ComponentContentNoteCard:getContext	()Landroid/content/Context;
    //   121: fload 8
    //   123: invokestatic 222	zby:b	(Landroid/content/Context;F)I
    //   126: istore 9
    //   128: iload 9
    //   130: i2f
    //   131: fstore 5
    //   133: fload 6
    //   135: fstore 4
    //   137: aload 10
    //   139: astore_2
    //   140: aload 12
    //   142: astore 10
    //   144: aload_1
    //   145: aload_0
    //   146: aload 11
    //   148: invokespecial 224	com/tencent/biz/pubaccount/readinjoy/rebuild/cmp/ComponentContentNoteCard:a	(Lorg/json/JSONArray;)Landroid/text/SpannableStringBuilder;
    //   151: invokevirtual 229	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   154: new 231	android/widget/RelativeLayout$LayoutParams
    //   157: dup
    //   158: bipush 254
    //   160: bipush 254
    //   162: invokespecial 234	android/widget/RelativeLayout$LayoutParams:<init>	(II)V
    //   165: astore 11
    //   167: aload_2
    //   168: ldc 236
    //   170: invokevirtual 240	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   173: ifeq +138 -> 311
    //   176: aload 11
    //   178: bipush 9
    //   180: invokevirtual 243	android/widget/RelativeLayout$LayoutParams:addRule	(I)V
    //   183: fconst_0
    //   184: fstore 8
    //   186: fload 4
    //   188: fstore 6
    //   190: fload 8
    //   192: fstore 4
    //   194: aload 10
    //   196: ldc 245
    //   198: invokevirtual 240	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   201: ifeq +168 -> 369
    //   204: aload 11
    //   206: bipush 10
    //   208: invokevirtual 243	android/widget/RelativeLayout$LayoutParams:addRule	(I)V
    //   211: fload 5
    //   213: fstore 8
    //   215: aload_1
    //   216: aload 11
    //   218: invokevirtual 249	android/widget/TextView:setLayoutParams	(Landroid/view/ViewGroup$LayoutParams;)V
    //   221: aload_1
    //   222: fload 6
    //   224: f2i
    //   225: fload 8
    //   227: f2i
    //   228: fload 4
    //   230: f2i
    //   231: fload 7
    //   233: f2i
    //   234: invokevirtual 253	android/widget/TextView:setPadding	(IIII)V
    //   237: aload_1
    //   238: fload_3
    //   239: invokevirtual 257	android/widget/TextView:setTextSize	(F)V
    //   242: return
    //   243: astore_2
    //   244: ldc 236
    //   246: astore 10
    //   248: ldc 245
    //   250: astore_2
    //   251: ldc 187
    //   253: fstore 4
    //   255: ldc_w 259
    //   258: iconst_1
    //   259: ldc_w 261
    //   262: invokestatic 267	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   265: aload_2
    //   266: astore 12
    //   268: aload 10
    //   270: astore_2
    //   271: aload 12
    //   273: astore 10
    //   275: goto -131 -> 144
    //   278: astore 12
    //   280: ldc_w 259
    //   283: iconst_1
    //   284: new 269	java/lang/StringBuilder
    //   287: dup
    //   288: invokespecial 270	java/lang/StringBuilder:<init>	()V
    //   291: ldc_w 272
    //   294: invokevirtual 275	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   297: aload 11
    //   299: invokevirtual 278	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   302: invokevirtual 279	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   305: invokestatic 267	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   308: goto -154 -> 154
    //   311: aload_2
    //   312: ldc_w 281
    //   315: invokevirtual 240	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   318: ifeq +16 -> 334
    //   321: aload 11
    //   323: bipush 11
    //   325: invokevirtual 243	android/widget/RelativeLayout$LayoutParams:addRule	(I)V
    //   328: fconst_0
    //   329: fstore 6
    //   331: goto -137 -> 194
    //   334: aload 11
    //   336: bipush 14
    //   338: invokevirtual 243	android/widget/RelativeLayout$LayoutParams:addRule	(I)V
    //   341: fload 4
    //   343: fconst_0
    //   344: fcmpl
    //   345: ifle +13 -> 358
    //   348: fload 4
    //   350: fstore 6
    //   352: fconst_0
    //   353: fstore 4
    //   355: goto -161 -> 194
    //   358: fload 4
    //   360: fneg
    //   361: fstore 4
    //   363: fconst_0
    //   364: fstore 6
    //   366: goto -172 -> 194
    //   369: aload 10
    //   371: ldc_w 283
    //   374: invokevirtual 240	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   377: ifeq +20 -> 397
    //   380: aload 11
    //   382: bipush 12
    //   384: invokevirtual 243	android/widget/RelativeLayout$LayoutParams:addRule	(I)V
    //   387: fconst_0
    //   388: fstore 8
    //   390: fload 5
    //   392: fstore 7
    //   394: goto -179 -> 215
    //   397: aload 11
    //   399: bipush 15
    //   401: invokevirtual 243	android/widget/RelativeLayout$LayoutParams:addRule	(I)V
    //   404: fload 5
    //   406: fstore 8
    //   408: fload 5
    //   410: fconst_0
    //   411: fcmpl
    //   412: ifgt -197 -> 215
    //   415: fload 5
    //   417: fneg
    //   418: fstore 7
    //   420: fconst_0
    //   421: fstore 8
    //   423: goto -208 -> 215
    //   426: astore_2
    //   427: ldc 236
    //   429: astore 10
    //   431: ldc 245
    //   433: astore_2
    //   434: ldc 187
    //   436: fstore 4
    //   438: goto -183 -> 255
    //   441: astore_2
    //   442: ldc 245
    //   444: astore_2
    //   445: ldc 187
    //   447: fstore 4
    //   449: goto -194 -> 255
    //   452: astore_2
    //   453: ldc 187
    //   455: fstore 4
    //   457: aload 12
    //   459: astore_2
    //   460: goto -205 -> 255
    //   463: astore_2
    //   464: aload 12
    //   466: astore_2
    //   467: goto -212 -> 255
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	470	0	this	ComponentContentNoteCard
    //   0	470	1	paramTextView	TextView
    //   0	470	2	paramJSONObject	JSONObject
    //   0	470	3	paramFloat	float
    //   72	384	4	f1	float
    //   2	414	5	f2	float
    //   68	297	6	f3	float
    //   5	414	7	f4	float
    //   87	335	8	f5	float
    //   126	3	9	i	int
    //   31	399	10	localObject1	Object
    //   23	375	11	localObject2	Object
    //   53	219	12	localObject3	Object
    //   278	187	12	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   25	33	243	java/lang/Exception
    //   144	154	278	java/lang/Exception
    //   37	46	426	java/lang/Exception
    //   46	55	441	java/lang/Exception
    //   55	70	452	java/lang/Exception
    //   74	89	463	java/lang/Exception
    //   97	109	463	java/lang/Exception
    //   117	128	463	java/lang/Exception
  }
  
  private void a(rgj paramrgj)
  {
    for (;;)
    {
      try
      {
        a(this.jdField_a_of_type_AndroidWidgetTextView, new JSONObject(paramrgj.jdField_a_of_type_JavaLangString), 18.0F);
        a(this.jdField_b_of_type_AndroidWidgetTextView, new JSONObject(paramrgj.b), 15.0F);
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_c_of_type_AndroidWidgetTextView.setText(paramrgj.jdField_d_of_type_JavaLangString);
        String str = pzo.c();
        Context localContext = getContext();
        if ((Build.VERSION.SDK_INT >= 23) && (localContext != null)) {
          if (localContext.checkSelfPermission("android.permission.RECORD_AUDIO") == 0)
          {
            i = 1;
            if ((i != 0) || (pzo.a() != 1)) {
              continue;
            }
            this.jdField_d_of_type_AndroidWidgetTextView.setText(getContext().getString(2131717095));
            this.jdField_d_of_type_AndroidWidgetTextView.setOnClickListener(new qvv(this));
            a(this.jdField_a_of_type_AndroidWidgetImageView, paramrgj.e);
            a(this.jdField_b_of_type_AndroidWidgetImageView, paramrgj.c);
            this.jdField_d_of_type_AndroidWidgetImageView.setOnClickListener(new qvw(this));
            this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
            if (this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable != null) {
              this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable.stop();
            }
            if (TextUtils.isEmpty(paramrgj.f)) {}
          }
        }
      }
      catch (JSONException localJSONException)
      {
        try
        {
          this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable = pka.a(paramrgj.f);
          this.jdField_c_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable);
          return;
          localJSONException = localJSONException;
          localJSONException.printStackTrace();
          QLog.e("ComponentContentNoteCard", 1, "json error: " + paramrgj.jdField_a_of_type_JavaLangString + "\n" + paramrgj.b);
          continue;
          i = 0;
          continue;
          this.jdField_d_of_type_AndroidWidgetTextView.setText(localJSONException);
        }
        catch (Exception paramrgj)
        {
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.e("ComponentContentNoteCard", 1, paramrgj, new Object[0]);
          return;
        }
      }
      int i = 1;
    }
  }
  
  private void b(rgj paramrgj)
  {
    paramrgj.g = paramrgj.g.replace("#$%", pzo.a());
    Object localObject = getContext();
    if ((Build.VERSION.SDK_INT >= 23) && (localObject != null)) {
      if (((Context)localObject).checkSelfPermission("android.permission.RECORD_AUDIO") != 0) {}
    }
    for (int i = 1;; i = 1) {
      for (;;)
      {
        if ((i == 0) && (pzo.a() == 1))
        {
          localObject = paramrgj.h.replace("#$%", getContext().getString(2131717094));
          this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(new qvx(this));
        }
        try
        {
          for (;;)
          {
            a(this.jdField_a_of_type_AndroidWidgetTextView, new JSONObject(paramrgj.g), 18.0F);
            a(this.jdField_b_of_type_AndroidWidgetTextView, new JSONObject((String)localObject), 15.0F);
            a(this.jdField_b_of_type_AndroidWidgetImageView, paramrgj.i);
            this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
            this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
            this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
            this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
            return;
            i = 0;
            break;
            localObject = paramrgj.h.replace("#$%", pzo.b());
          }
        }
        catch (JSONException localJSONException)
        {
          for (;;)
          {
            localJSONException.printStackTrace();
            QLog.e("ComponentContentNoteCard", 1, "json error: " + paramrgj.g + "\n" + paramrgj.h);
          }
        }
      }
    }
  }
  
  private void d()
  {
    try
    {
      mue.a((Activity)getContext());
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("ComponentContentNoteCard", 1, localException, new Object[0]);
    }
  }
  
  private void e()
  {
    ViewGroup.LayoutParams localLayoutParams = this.jdField_a_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
    localLayoutParams.width = ((int)bgln.k());
    localLayoutParams.height = ((int)(bgln.k() * 0.5625D));
    if (this.jdField_a_of_type_AndroidWidgetRelativeLayout != null) {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setLayoutParams(localLayoutParams);
    }
  }
  
  private void f()
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyNotecardSoundCheckRunnable == null) || (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyNotecardSoundCheckRunnable.a()))
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyNotecardSoundCheckRunnable = new SoundCheckRunnable();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyNotecardSoundCheckRunnable.a(this);
      ThreadManager.excute(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyNotecardSoundCheckRunnable, 16, null, true);
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(new ComponentContentNoteCard.5(this), 60000L);
    }
  }
  
  private void g()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyNotecardSoundCheckRunnable != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyNotecardSoundCheckRunnable.a();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyNotecardSoundCheckRunnable.a(null);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyNotecardSoundCheckRunnable = null;
    }
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
  }
  
  public void A_()
  {
    String str = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    if (pzo.a(getContext(), str) < rgj.jdField_d_of_type_Int)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.c(7);
      return;
    }
    QQToast.a(getContext(), 0, getContext().getString(2131717198), 0).a();
  }
  
  public View a(Context paramContext)
  {
    return LayoutInflater.from(paramContext).inflate(2131560097, this, true);
  }
  
  public void a()
  {
    int j = 1;
    if (QLog.isColorLevel()) {
      QLog.d("ComponentContentNoteCard", 2, "onItemResume");
    }
    this.jdField_b_of_type_Boolean = true;
    if (this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable != null) {
      this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable.resumeAnimation();
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.a(this);
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyNotecardSoundCheckRunnable != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyNotecardSoundCheckRunnable.a();
    }
    Object localObject = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    if ((this.jdField_a_of_type_Boolean) && (pzo.a() != 0))
    {
      i = pzo.b(getContext(), (String)localObject);
      int k = pzo.c(getContext(), (String)localObject);
      if ((i < pzo.b()) && (k < pzo.c()))
      {
        this.jdField_a_of_type_Rgj.jdField_a_of_type_Int = 2;
        pzo.a(getContext(), (String)localObject, i + 1);
        pzo.b(getContext(), (String)localObject, k + 1);
      }
    }
    a(this.jdField_a_of_type_JavaLangObject);
    if ((pzo.a() == 1) && (pzo.b(getContext(), (String)localObject) > 0))
    {
      localObject = getContext();
      i = j;
      if (Build.VERSION.SDK_INT >= 23)
      {
        i = j;
        if (localObject != null) {
          if (((Context)localObject).checkSelfPermission("android.permission.RECORD_AUDIO") != 0) {
            break label242;
          }
        }
      }
    }
    label242:
    for (int i = j;; i = 0)
    {
      if (i != 0) {
        this.jdField_a_of_type_AndroidOsHandler.postDelayed(new ComponentContentNoteCard.4(this), 1000L);
      }
      this.jdField_a_of_type_Boolean = false;
      return;
    }
  }
  
  public void a(Context paramContext)
  {
    a(a(paramContext));
  }
  
  public void a(View paramView)
  {
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131371814));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131370481));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131378010));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131371811));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131369746));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131369744));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131376534));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131370314));
    this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131371813));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentNotIntrest = ((ComponentNotIntrest)paramView.findViewById(2131371805));
    e();
  }
  
  public void a(Object paramObject)
  {
    this.jdField_a_of_type_JavaLangObject = paramObject;
    if ((paramObject instanceof pxk))
    {
      paramObject = ((pxk)paramObject).a().scripCmsInfo;
      this.jdField_a_of_type_Rgj = paramObject;
      if (paramObject != null)
      {
        if ((paramObject.jdField_a_of_type_Int != 1) && ((!TextUtils.isEmpty(paramObject.g)) || (!TextUtils.isEmpty(paramObject.h)))) {
          break label68;
        }
        a(paramObject);
      }
    }
    return;
    label68:
    b(paramObject);
  }
  
  public void a(qrb paramqrb)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentNotIntrest != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentNotIntrest.a(paramqrb);
    }
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ComponentContentNoteCard", 2, "onItemPause");
    }
    this.jdField_b_of_type_Boolean = false;
    if (this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable != null) {
      this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable.pauseAnimation();
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.b(this);
    g();
  }
  
  public void c()
  {
    this.jdField_a_of_type_Boolean = true;
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable != null) && (this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable.isAnimating()) && (this.jdField_a_of_type_Int != 0)) {
      this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable.pauseAnimation();
    }
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    if (this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable != null)
    {
      if (paramInt == 0) {
        this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable.resumeAnimation();
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable.pauseAnimation();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentContentNoteCard
 * JD-Core Version:    0.7.0.1
 */