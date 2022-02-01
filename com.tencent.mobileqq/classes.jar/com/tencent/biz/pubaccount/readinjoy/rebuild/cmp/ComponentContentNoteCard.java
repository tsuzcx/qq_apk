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
import com.tencent.av.utils.UITools;
import com.tencent.biz.pubaccount.readinjoy.drawable.ReadInJoyLottieDrawable;
import com.tencent.biz.pubaccount.readinjoy.model.IReadInJoyModel;
import com.tencent.biz.pubaccount.readinjoy.notecard.ReadInJoyNoteCardUtil;
import com.tencent.biz.pubaccount.readinjoy.notecard.SoundCheckRunnable;
import com.tencent.biz.pubaccount.readinjoy.notecard.SoundCheckRunnable.OnSoundActionListener;
import com.tencent.biz.pubaccount.readinjoy.rebuild.ComponentInheritView;
import com.tencent.biz.pubaccount.readinjoy.rebuild.FeedItemCell.CellListener;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ScripCmsInfo;
import com.tencent.biz.pubaccount.readinjoy.view.IReadInJoyListItemLifeCycle;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyXListView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.dinifly.LottieDrawable;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;
import mqq.app.AppRuntime;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ComponentContentNoteCard
  extends RelativeLayout
  implements SoundCheckRunnable.OnSoundActionListener, ComponentInheritView, IReadInJoyListItemLifeCycle, AbsListView.OnScrollListener
{
  private int jdField_a_of_type_Int = 0;
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  private ImageView jdField_a_of_type_AndroidWidgetImageView = null;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout = null;
  private TextView jdField_a_of_type_AndroidWidgetTextView = null;
  private SoundCheckRunnable jdField_a_of_type_ComTencentBizPubaccountReadinjoyNotecardSoundCheckRunnable;
  private ComponentNotIntrest jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentNotIntrest = null;
  private ScripCmsInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructScripCmsInfo;
  private ReadInJoyXListView jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView = null;
  private LottieDrawable jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable = null;
  private Object jdField_a_of_type_JavaLangObject;
  private boolean jdField_a_of_type_Boolean = false;
  private ImageView jdField_b_of_type_AndroidWidgetImageView = null;
  private TextView jdField_b_of_type_AndroidWidgetTextView = null;
  private boolean jdField_b_of_type_Boolean = false;
  private ImageView jdField_c_of_type_AndroidWidgetImageView = null;
  private TextView jdField_c_of_type_AndroidWidgetTextView = null;
  private ImageView jdField_d_of_type_AndroidWidgetImageView = null;
  private TextView jdField_d_of_type_AndroidWidgetTextView = null;
  
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
  
  public ComponentContentNoteCard(Context paramContext, ReadInJoyBaseAdapter paramReadInJoyBaseAdapter)
  {
    super(paramContext);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView = ((ReadInJoyXListView)paramReadInJoyBaseAdapter.a());
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
    //   0: ldc 211
    //   2: fstore 5
    //   4: fconst_0
    //   5: fstore 7
    //   7: aload_1
    //   8: ifnull +7 -> 15
    //   11: aload_2
    //   12: ifnonnull +4 -> 16
    //   15: return
    //   16: new 100	org/json/JSONArray
    //   19: dup
    //   20: invokespecial 212	org/json/JSONArray:<init>	()V
    //   23: astore 11
    //   25: aload_2
    //   26: ldc 214
    //   28: invokevirtual 218	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   31: astore 10
    //   33: aload 10
    //   35: astore 11
    //   37: aload_0
    //   38: aload_2
    //   39: ldc 220
    //   41: invokespecial 222	com/tencent/biz/pubaccount/readinjoy/rebuild/cmp/ComponentContentNoteCard:a	(Lorg/json/JSONObject;Ljava/lang/String;)Ljava/lang/String;
    //   44: astore 10
    //   46: aload_0
    //   47: aload_2
    //   48: ldc 224
    //   50: invokespecial 222	com/tencent/biz/pubaccount/readinjoy/rebuild/cmp/ComponentContentNoteCard:a	(Lorg/json/JSONObject;Ljava/lang/String;)Ljava/lang/String;
    //   53: astore 12
    //   55: aload_0
    //   56: aload_2
    //   57: ldc 226
    //   59: invokespecial 222	com/tencent/biz/pubaccount/readinjoy/rebuild/cmp/ComponentContentNoteCard:a	(Lorg/json/JSONObject;Ljava/lang/String;)Ljava/lang/String;
    //   62: invokestatic 231	java/lang/Float:valueOf	(Ljava/lang/String;)Ljava/lang/Float;
    //   65: invokevirtual 235	java/lang/Float:floatValue	()F
    //   68: fstore 6
    //   70: fload 6
    //   72: fstore 4
    //   74: aload_0
    //   75: aload_2
    //   76: ldc 237
    //   78: invokespecial 222	com/tencent/biz/pubaccount/readinjoy/rebuild/cmp/ComponentContentNoteCard:a	(Lorg/json/JSONObject;Ljava/lang/String;)Ljava/lang/String;
    //   81: invokestatic 231	java/lang/Float:valueOf	(Ljava/lang/String;)Ljava/lang/Float;
    //   84: invokevirtual 235	java/lang/Float:floatValue	()F
    //   87: fstore 8
    //   89: fload 8
    //   91: fstore 5
    //   93: fload 6
    //   95: fstore 4
    //   97: aload_0
    //   98: invokevirtual 241	com/tencent/biz/pubaccount/readinjoy/rebuild/cmp/ComponentContentNoteCard:getContext	()Landroid/content/Context;
    //   101: fload 6
    //   103: invokestatic 246	com/tencent/biz/qqstory/takevideo/doodle/util/DisplayUtil:b	(Landroid/content/Context;F)I
    //   106: i2f
    //   107: fstore 6
    //   109: fload 8
    //   111: fstore 5
    //   113: fload 6
    //   115: fstore 4
    //   117: aload_0
    //   118: invokevirtual 241	com/tencent/biz/pubaccount/readinjoy/rebuild/cmp/ComponentContentNoteCard:getContext	()Landroid/content/Context;
    //   121: fload 8
    //   123: invokestatic 246	com/tencent/biz/qqstory/takevideo/doodle/util/DisplayUtil:b	(Landroid/content/Context;F)I
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
    //   148: invokespecial 248	com/tencent/biz/pubaccount/readinjoy/rebuild/cmp/ComponentContentNoteCard:a	(Lorg/json/JSONArray;)Landroid/text/SpannableStringBuilder;
    //   151: invokevirtual 253	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   154: new 255	android/widget/RelativeLayout$LayoutParams
    //   157: dup
    //   158: bipush 254
    //   160: bipush 254
    //   162: invokespecial 258	android/widget/RelativeLayout$LayoutParams:<init>	(II)V
    //   165: astore 11
    //   167: aload_2
    //   168: ldc_w 260
    //   171: invokevirtual 264	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   174: ifeq +141 -> 315
    //   177: aload 11
    //   179: bipush 9
    //   181: invokevirtual 267	android/widget/RelativeLayout$LayoutParams:addRule	(I)V
    //   184: fconst_0
    //   185: fstore 8
    //   187: fload 4
    //   189: fstore 6
    //   191: fload 8
    //   193: fstore 4
    //   195: aload 10
    //   197: ldc_w 269
    //   200: invokevirtual 264	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   203: ifeq +170 -> 373
    //   206: aload 11
    //   208: bipush 10
    //   210: invokevirtual 267	android/widget/RelativeLayout$LayoutParams:addRule	(I)V
    //   213: fload 5
    //   215: fstore 8
    //   217: aload_1
    //   218: aload 11
    //   220: invokevirtual 273	android/widget/TextView:setLayoutParams	(Landroid/view/ViewGroup$LayoutParams;)V
    //   223: aload_1
    //   224: fload 6
    //   226: f2i
    //   227: fload 8
    //   229: f2i
    //   230: fload 4
    //   232: f2i
    //   233: fload 7
    //   235: f2i
    //   236: invokevirtual 277	android/widget/TextView:setPadding	(IIII)V
    //   239: aload_1
    //   240: fload_3
    //   241: invokevirtual 281	android/widget/TextView:setTextSize	(F)V
    //   244: return
    //   245: astore_2
    //   246: ldc_w 260
    //   249: astore 10
    //   251: ldc_w 269
    //   254: astore_2
    //   255: ldc 211
    //   257: fstore 4
    //   259: ldc_w 283
    //   262: iconst_1
    //   263: ldc_w 285
    //   266: invokestatic 291	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   269: aload_2
    //   270: astore 12
    //   272: aload 10
    //   274: astore_2
    //   275: aload 12
    //   277: astore 10
    //   279: goto -135 -> 144
    //   282: astore 12
    //   284: ldc_w 283
    //   287: iconst_1
    //   288: new 293	java/lang/StringBuilder
    //   291: dup
    //   292: invokespecial 294	java/lang/StringBuilder:<init>	()V
    //   295: ldc_w 296
    //   298: invokevirtual 299	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   301: aload 11
    //   303: invokevirtual 302	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   306: invokevirtual 303	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   309: invokestatic 291	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   312: goto -158 -> 154
    //   315: aload_2
    //   316: ldc_w 305
    //   319: invokevirtual 264	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   322: ifeq +16 -> 338
    //   325: aload 11
    //   327: bipush 11
    //   329: invokevirtual 267	android/widget/RelativeLayout$LayoutParams:addRule	(I)V
    //   332: fconst_0
    //   333: fstore 6
    //   335: goto -140 -> 195
    //   338: aload 11
    //   340: bipush 14
    //   342: invokevirtual 267	android/widget/RelativeLayout$LayoutParams:addRule	(I)V
    //   345: fload 4
    //   347: fconst_0
    //   348: fcmpl
    //   349: ifle +13 -> 362
    //   352: fload 4
    //   354: fstore 6
    //   356: fconst_0
    //   357: fstore 4
    //   359: goto -164 -> 195
    //   362: fload 4
    //   364: fneg
    //   365: fstore 4
    //   367: fconst_0
    //   368: fstore 6
    //   370: goto -175 -> 195
    //   373: aload 10
    //   375: ldc_w 307
    //   378: invokevirtual 264	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   381: ifeq +20 -> 401
    //   384: aload 11
    //   386: bipush 12
    //   388: invokevirtual 267	android/widget/RelativeLayout$LayoutParams:addRule	(I)V
    //   391: fconst_0
    //   392: fstore 8
    //   394: fload 5
    //   396: fstore 7
    //   398: goto -181 -> 217
    //   401: aload 11
    //   403: bipush 15
    //   405: invokevirtual 267	android/widget/RelativeLayout$LayoutParams:addRule	(I)V
    //   408: fload 5
    //   410: fstore 8
    //   412: fload 5
    //   414: fconst_0
    //   415: fcmpl
    //   416: ifgt -199 -> 217
    //   419: fload 5
    //   421: fneg
    //   422: fstore 7
    //   424: fconst_0
    //   425: fstore 8
    //   427: goto -210 -> 217
    //   430: astore_2
    //   431: ldc_w 260
    //   434: astore 10
    //   436: ldc_w 269
    //   439: astore_2
    //   440: ldc 211
    //   442: fstore 4
    //   444: goto -185 -> 259
    //   447: astore_2
    //   448: ldc_w 269
    //   451: astore_2
    //   452: ldc 211
    //   454: fstore 4
    //   456: goto -197 -> 259
    //   459: astore_2
    //   460: ldc 211
    //   462: fstore 4
    //   464: aload 12
    //   466: astore_2
    //   467: goto -208 -> 259
    //   470: astore_2
    //   471: aload 12
    //   473: astore_2
    //   474: goto -215 -> 259
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	477	0	this	ComponentContentNoteCard
    //   0	477	1	paramTextView	TextView
    //   0	477	2	paramJSONObject	JSONObject
    //   0	477	3	paramFloat	float
    //   72	391	4	f1	float
    //   2	418	5	f2	float
    //   68	301	6	f3	float
    //   5	418	7	f4	float
    //   87	339	8	f5	float
    //   126	3	9	i	int
    //   31	404	10	localObject1	Object
    //   23	379	11	localObject2	Object
    //   53	223	12	localObject3	Object
    //   282	190	12	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   25	33	245	java/lang/Exception
    //   144	154	282	java/lang/Exception
    //   37	46	430	java/lang/Exception
    //   46	55	447	java/lang/Exception
    //   55	70	459	java/lang/Exception
    //   74	89	470	java/lang/Exception
    //   97	109	470	java/lang/Exception
    //   117	128	470	java/lang/Exception
  }
  
  private void a(ScripCmsInfo paramScripCmsInfo)
  {
    for (;;)
    {
      try
      {
        a(this.jdField_a_of_type_AndroidWidgetTextView, new JSONObject(paramScripCmsInfo.jdField_a_of_type_JavaLangString), 18.0F);
        a(this.jdField_b_of_type_AndroidWidgetTextView, new JSONObject(paramScripCmsInfo.b), 15.0F);
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_c_of_type_AndroidWidgetTextView.setText(paramScripCmsInfo.jdField_d_of_type_JavaLangString);
        String str = ReadInJoyNoteCardUtil.c();
        Context localContext = getContext();
        if ((Build.VERSION.SDK_INT >= 23) && (localContext != null)) {
          if (localContext.checkSelfPermission("android.permission.RECORD_AUDIO") == 0)
          {
            i = 1;
            if ((i != 0) || (ReadInJoyNoteCardUtil.a() != 1)) {
              continue;
            }
            this.jdField_d_of_type_AndroidWidgetTextView.setText(getContext().getString(2131718314));
            this.jdField_d_of_type_AndroidWidgetTextView.setOnClickListener(new ComponentContentNoteCard.1(this));
            a(this.jdField_a_of_type_AndroidWidgetImageView, paramScripCmsInfo.e);
            a(this.jdField_b_of_type_AndroidWidgetImageView, paramScripCmsInfo.c);
            this.jdField_d_of_type_AndroidWidgetImageView.setOnClickListener(new ComponentContentNoteCard.2(this));
            this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
            if (this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable != null) {
              this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable.stop();
            }
            if (TextUtils.isEmpty(paramScripCmsInfo.f)) {}
          }
        }
      }
      catch (JSONException localJSONException)
      {
        try
        {
          this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable = ReadInJoyLottieDrawable.a(paramScripCmsInfo.f);
          this.jdField_c_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable);
          return;
          localJSONException = localJSONException;
          localJSONException.printStackTrace();
          QLog.e("ComponentContentNoteCard", 1, "json error: " + paramScripCmsInfo.jdField_a_of_type_JavaLangString + "\n" + paramScripCmsInfo.b);
          continue;
          i = 0;
          continue;
          this.jdField_d_of_type_AndroidWidgetTextView.setText(localJSONException);
        }
        catch (Exception paramScripCmsInfo)
        {
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.e("ComponentContentNoteCard", 1, paramScripCmsInfo, new Object[0]);
          return;
        }
      }
      int i = 1;
    }
  }
  
  private void b(ScripCmsInfo paramScripCmsInfo)
  {
    paramScripCmsInfo.g = paramScripCmsInfo.g.replace("#$%", ReadInJoyNoteCardUtil.a());
    Object localObject = getContext();
    if ((Build.VERSION.SDK_INT >= 23) && (localObject != null)) {
      if (((Context)localObject).checkSelfPermission("android.permission.RECORD_AUDIO") != 0) {}
    }
    for (int i = 1;; i = 1) {
      for (;;)
      {
        if ((i == 0) && (ReadInJoyNoteCardUtil.a() == 1))
        {
          localObject = paramScripCmsInfo.h.replace("#$%", getContext().getString(2131718313));
          this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(new ComponentContentNoteCard.3(this));
        }
        try
        {
          for (;;)
          {
            a(this.jdField_a_of_type_AndroidWidgetTextView, new JSONObject(paramScripCmsInfo.g), 18.0F);
            a(this.jdField_b_of_type_AndroidWidgetTextView, new JSONObject((String)localObject), 15.0F);
            a(this.jdField_b_of_type_AndroidWidgetImageView, paramScripCmsInfo.i);
            this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
            this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
            this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
            this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
            return;
            i = 0;
            break;
            localObject = paramScripCmsInfo.h.replace("#$%", ReadInJoyNoteCardUtil.b());
          }
        }
        catch (JSONException localJSONException)
        {
          for (;;)
          {
            localJSONException.printStackTrace();
            QLog.e("ComponentContentNoteCard", 1, "json error: " + paramScripCmsInfo.g + "\n" + paramScripCmsInfo.h);
          }
        }
      }
    }
  }
  
  private void d()
  {
    try
    {
      UITools.a((Activity)getContext());
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
    if (this.jdField_a_of_type_AndroidWidgetRelativeLayout != null)
    {
      ViewGroup.LayoutParams localLayoutParams = this.jdField_a_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
      localLayoutParams.width = ((int)DeviceInfoUtil.k());
      localLayoutParams.height = ((int)(DeviceInfoUtil.k() * 0.5625D));
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
  
  public void D_()
  {
    String str = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    if (ReadInJoyNoteCardUtil.a(getContext(), str) < ScripCmsInfo.jdField_d_of_type_Int)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.c(7);
      return;
    }
    QQToast.a(getContext(), 0, getContext().getString(2131718404), 0).a();
  }
  
  public View a(Context paramContext)
  {
    return LayoutInflater.from(paramContext).inflate(2131560241, this, true);
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
    if ((this.jdField_a_of_type_Boolean) && (ReadInJoyNoteCardUtil.a() != 0))
    {
      i = ReadInJoyNoteCardUtil.b(getContext(), (String)localObject);
      int k = ReadInJoyNoteCardUtil.c(getContext(), (String)localObject);
      if ((i < ReadInJoyNoteCardUtil.b()) && (k < ReadInJoyNoteCardUtil.c()))
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructScripCmsInfo.jdField_a_of_type_Int = 2;
        ReadInJoyNoteCardUtil.a(getContext(), (String)localObject, i + 1);
        ReadInJoyNoteCardUtil.b(getContext(), (String)localObject, k + 1);
      }
    }
    a(this.jdField_a_of_type_JavaLangObject);
    if ((ReadInJoyNoteCardUtil.a() == 1) && (ReadInJoyNoteCardUtil.b(getContext(), (String)localObject) > 0))
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
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131372381));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131371015));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131378648));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131372378));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131370273));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131370271));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131377082));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131370851));
    this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131372380));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentNotIntrest = ((ComponentNotIntrest)paramView.findViewById(2131372372));
    e();
  }
  
  public void a(FeedItemCell.CellListener paramCellListener)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentNotIntrest != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentNotIntrest.a(paramCellListener);
    }
  }
  
  public void a(Object paramObject)
  {
    this.jdField_a_of_type_JavaLangObject = paramObject;
    if ((paramObject instanceof IReadInJoyModel))
    {
      paramObject = ((IReadInJoyModel)paramObject).a().scripCmsInfo;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructScripCmsInfo = paramObject;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentContentNoteCard
 * JD-Core Version:    0.7.0.1
 */