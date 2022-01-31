import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import com.tencent.qqmini.sdk.log.QMLog;
import com.tencent.qqmini.sdk.runtime.core.page.NativeViewContainer;
import com.tencent.qqmini.sdk.runtime.core.page.PageWebview;
import com.tencent.qqmini.sdk.runtime.core.page.PageWebviewContainer;
import com.tencent.qqmini.sdk.runtime.core.page.widget.WebEditText;
import com.tencent.qqmini.sdk.utils.DisplayUtil;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

public final class bhgx
{
  private int jdField_a_of_type_Int;
  public bhfz a;
  private NativeViewContainer jdField_a_of_type_ComTencentQqminiSdkRuntimeCorePageNativeViewContainer;
  private WebEditText jdField_a_of_type_ComTencentQqminiSdkRuntimeCorePageWidgetWebEditText;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  private Map<Integer, WebEditText> jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap();
  private AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private Map<Integer, bgpu> jdField_b_of_type_JavaUtilMap = new ConcurrentHashMap();
  private int jdField_c_of_type_Int;
  private Map<Integer, String> jdField_c_of_type_JavaUtilMap = new HashMap();
  private int d;
  private int e;
  
  public bhgx(NativeViewContainer paramNativeViewContainer)
  {
    this.jdField_a_of_type_ComTencentQqminiSdkRuntimeCorePageNativeViewContainer = paramNativeViewContainer;
  }
  
  private void a()
  {
    WebEditText localWebEditText = (WebEditText)this.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(this.e));
    if ((localWebEditText == null) || (!localWebEditText.isFocused()) || (localWebEditText.b())) {
      return;
    }
    this.jdField_a_of_type_Boolean = localWebEditText.a();
    int i = localWebEditText.getBottom();
    int j = localWebEditText.b();
    i = this.jdField_a_of_type_Int - (i + j);
    if ((this.jdField_a_of_type_Boolean) && (i < this.jdField_c_of_type_Int))
    {
      this.d = (-(this.jdField_c_of_type_Int - i));
      bgox.a(this.jdField_a_of_type_ComTencentQqminiSdkRuntimeCorePageNativeViewContainer.a(), 0.0F, this.d, 1.0F, 1.0F);
      bgox.a(localWebEditText, 0.0F, this.d, 1.0F, 1.0F);
    }
    localWebEditText.setHasMoveParent(true);
  }
  
  public Map<Integer, WebEditText> a()
  {
    return this.jdField_a_of_type_JavaUtilMap;
  }
  
  public void a(bgmk parambgmk)
  {
    QMLog.d("WebInputHandler", ", webParams=" + parambgmk.jdField_b_of_type_JavaLangString + ", callbackId=" + parambgmk.jdField_b_of_type_Int);
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      QMLog.d("WebInputHandler", "[showKeyboard] mCurrentFocusInput=" + this.jdField_a_of_type_ComTencentQqminiSdkRuntimeCorePageWidgetWebEditText);
      if (TextUtils.isEmpty(parambgmk.jdField_b_of_type_JavaLangString))
      {
        QMLog.e("WebInputHandler", "[showKeyboard] no web input params");
        parambgmk.b();
        return;
      }
      if (this.jdField_a_of_type_ComTencentQqminiSdkRuntimeCorePageNativeViewContainer == null)
      {
        parambgmk.b();
        return;
      }
    }
    this.jdField_a_of_type_Int = DisplayUtil.getRealHeight(this.jdField_a_of_type_ComTencentQqminiSdkRuntimeCorePageNativeViewContainer.getContext());
    this.jdField_b_of_type_Int = this.jdField_a_of_type_ComTencentQqminiSdkRuntimeCorePageNativeViewContainer.a();
    Object localObject2 = new WebEditText(this.jdField_a_of_type_ComTencentQqminiSdkRuntimeCorePageNativeViewContainer.getContext(), this);
    try
    {
      bool = ((WebEditText)localObject2).a(this.jdField_a_of_type_ComTencentQqminiSdkRuntimeCorePageNativeViewContainer, parambgmk.jdField_b_of_type_JavaLangString);
      this.e = this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.incrementAndGet();
      this.jdField_a_of_type_ComTencentQqminiSdkRuntimeCorePageNativeViewContainer.setCurInputId(this.e);
      localPageWebview = this.jdField_a_of_type_ComTencentQqminiSdkRuntimeCorePageNativeViewContainer.a();
      this.jdField_a_of_type_Bhfz = new bhgy(this, localPageWebview);
      if (this.jdField_a_of_type_ComTencentQqminiSdkRuntimeCorePageNativeViewContainer != null)
      {
        bhhb localbhhb = new bhhb(this);
        this.jdField_a_of_type_ComTencentQqminiSdkRuntimeCorePageNativeViewContainer.setSoftKeyboardStateListener(localbhhb);
        this.jdField_b_of_type_JavaUtilMap.put(Integer.valueOf(this.e), localbhhb);
      }
      if (localPageWebview != null) {
        localPageWebview.setOnWebviewScrollListener(this.jdField_a_of_type_Bhfz);
      }
      if (!bool) {}
    }
    catch (Exception localException)
    {
      try
      {
        boolean bool;
        PageWebview localPageWebview;
        this.jdField_a_of_type_ComTencentQqminiSdkRuntimeCorePageNativeViewContainer.a((View)localObject2, ((WebEditText)localObject2).a(this.jdField_a_of_type_ComTencentQqminiSdkRuntimeCorePageNativeViewContainer.a().jdField_c_of_type_Int));
        this.jdField_a_of_type_ComTencentQqminiSdkRuntimeCorePageWidgetWebEditText = ((WebEditText)localObject2);
        ((WebEditText)localObject2).setInputId(this.e);
        ((WebEditText)localObject2).setPageWebview(localPageWebview);
        this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(this.e), localObject2);
        ((WebEditText)localObject2).b();
        ((WebEditText)localObject2).addTextChangedListener(new bhgz(this, parambgmk));
        ((WebEditText)localObject2).setOnEditorActionListener(new bhha(this, (WebEditText)localObject2, parambgmk));
        localObject2 = new JSONObject();
        ((JSONObject)localObject2).put("inputId", this.e);
        parambgmk.a((JSONObject)localObject2);
        for (;;)
        {
          return;
          localException = localException;
          QMLog.e("WebInputHandler", "[showKeyboard] initWithWebParams exception:", localException);
          bool = false;
          break;
          parambgmk.b();
        }
      }
      catch (Exception parambgmk)
      {
        for (;;)
        {
          QMLog.e("WebInputHandler", "[showKeyboard] exception:", parambgmk);
        }
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_ComTencentQqminiSdkRuntimeCorePageWidgetWebEditText == null) || (this.jdField_a_of_type_ComTencentQqminiSdkRuntimeCorePageNativeViewContainer == null) || (this.jdField_a_of_type_ComTencentQqminiSdkRuntimeCorePageNativeViewContainer.a() == null))
    {
      QMLog.e("WebInputHandler", "mCurrentFocusInput is null, return.");
      return;
    }
    if (this.jdField_a_of_type_JavaUtilMap.size() > 0)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.entrySet().iterator();
      for (;;)
      {
        if (localIterator.hasNext())
        {
          Object localObject = (WebEditText)((Map.Entry)localIterator.next()).getValue();
          QMLog.d("WebInputHandler", "[hideCurrentInput] webEditText=" + localObject);
          int i = ((WebEditText)localObject).a();
          String str = ((WebEditText)localObject).getText().toString();
          PageWebview localPageWebview = ((WebEditText)localObject).a();
          if ((this.jdField_a_of_type_ComTencentQqminiSdkRuntimeCorePageWidgetWebEditText != null) && (this.jdField_a_of_type_ComTencentQqminiSdkRuntimeCorePageWidgetWebEditText.a() == ((WebEditText)localObject).a()) && (paramBoolean)) {
            ((InputMethodManager)((WebEditText)localObject).getContext().getSystemService("input_method")).hideSoftInputFromWindow(((WebEditText)localObject).getWindowToken(), 0);
          }
          ((WebEditText)localObject).clearFocus();
          ((WebEditText)localObject).a();
          ((WebEditText)localObject).setHasMoveParent(false);
          this.jdField_a_of_type_JavaUtilMap.remove(Integer.valueOf(i));
          if (this.jdField_a_of_type_ComTencentQqminiSdkRuntimeCorePageNativeViewContainer != null)
          {
            localObject = (bgpu)this.jdField_b_of_type_JavaUtilMap.remove(Integer.valueOf(i));
            this.jdField_a_of_type_ComTencentQqminiSdkRuntimeCorePageNativeViewContainer.a((bgpu)localObject);
          }
          if (localPageWebview == null) {
            continue;
          }
          try
          {
            localObject = new JSONObject();
            ((JSONObject)localObject).put("inputId", i);
            ((JSONObject)localObject).put("value", str);
            ((JSONObject)localObject).put("cursor", str.length());
            this.jdField_a_of_type_ComTencentQqminiSdkRuntimeCorePageNativeViewContainer.a().b("onKeyboardComplete", ((JSONObject)localObject).toString());
            if (this.jdField_a_of_type_Bhfz != null) {
              localPageWebview.a(this.jdField_a_of_type_Bhfz);
            }
          }
          catch (Exception localException)
          {
            for (;;)
            {
              Log.e("WebInputHandler", "[hideCurrentInput] exception:", localException);
            }
          }
        }
      }
    }
    this.jdField_a_of_type_ComTencentQqminiSdkRuntimeCorePageWidgetWebEditText = null;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_ComTencentQqminiSdkRuntimeCorePageWidgetWebEditText != null;
  }
  
  public boolean a(int paramInt)
  {
    return (this.jdField_a_of_type_ComTencentQqminiSdkRuntimeCorePageWidgetWebEditText != null) && (this.jdField_a_of_type_ComTencentQqminiSdkRuntimeCorePageWidgetWebEditText.a() == paramInt);
  }
  
  /* Error */
  public boolean a(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 39	bhgx:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   6: astore 10
    //   8: aload 10
    //   10: ifnonnull +11 -> 21
    //   13: iconst_0
    //   14: istore 9
    //   16: aload_0
    //   17: monitorexit
    //   18: iload 9
    //   20: ireturn
    //   21: new 254	org/json/JSONObject
    //   24: dup
    //   25: aload_1
    //   26: invokespecial 371	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   29: astore 10
    //   31: aload_0
    //   32: getfield 39	bhgx:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   35: aload 10
    //   37: ldc_w 257
    //   40: invokevirtual 375	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   43: invokestatic 63	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   46: invokeinterface 69 2 0
    //   51: checkcast 71	com/tencent/qqmini/sdk/runtime/core/page/widget/WebEditText
    //   54: astore_1
    //   55: aload_1
    //   56: ifnonnull +9 -> 65
    //   59: iconst_0
    //   60: istore 9
    //   62: goto -46 -> 16
    //   65: aload 10
    //   67: ldc_w 340
    //   70: invokevirtual 378	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   73: ifeq +28 -> 101
    //   76: aload 10
    //   78: ldc_w 340
    //   81: invokevirtual 382	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   84: astore 11
    //   86: aload_1
    //   87: aload 11
    //   89: invokevirtual 386	com/tencent/qqmini/sdk/runtime/core/page/widget/WebEditText:setText	(Ljava/lang/CharSequence;)V
    //   92: aload_1
    //   93: aload 11
    //   95: invokevirtual 350	java/lang/String:length	()I
    //   98: invokevirtual 389	com/tencent/qqmini/sdk/runtime/core/page/widget/WebEditText:setSelection	(I)V
    //   101: aload 10
    //   103: ldc_w 391
    //   106: iconst_m1
    //   107: invokevirtual 394	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   110: istore_3
    //   111: aload 10
    //   113: ldc_w 396
    //   116: iconst_m1
    //   117: invokevirtual 394	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   120: istore 4
    //   122: iload_3
    //   123: iconst_m1
    //   124: if_icmpeq +22 -> 146
    //   127: iload 4
    //   129: iconst_m1
    //   130: if_icmpeq +16 -> 146
    //   133: iload 4
    //   135: iload_3
    //   136: if_icmple +10 -> 146
    //   139: aload_1
    //   140: iload_3
    //   141: iload 4
    //   143: invokevirtual 399	com/tencent/qqmini/sdk/runtime/core/page/widget/WebEditText:setSelection	(II)V
    //   146: aload 10
    //   148: ldc_w 345
    //   151: iconst_m1
    //   152: invokevirtual 394	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   155: istore_3
    //   156: iload_3
    //   157: ifle +8 -> 165
    //   160: aload_1
    //   161: iload_3
    //   162: invokevirtual 389	com/tencent/qqmini/sdk/runtime/core/page/widget/WebEditText:setSelection	(I)V
    //   165: aload 10
    //   167: ldc_w 401
    //   170: invokevirtual 405	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   173: astore 10
    //   175: aload 10
    //   177: ifnull +203 -> 380
    //   180: aload 10
    //   182: ldc_w 407
    //   185: invokevirtual 375	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   188: istore 6
    //   190: aload 10
    //   192: ldc_w 409
    //   195: invokevirtual 375	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   198: istore 5
    //   200: aload 10
    //   202: ldc_w 411
    //   205: invokevirtual 375	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   208: istore_3
    //   209: aload 10
    //   211: ldc_w 413
    //   214: invokevirtual 375	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   217: istore 4
    //   219: aload_1
    //   220: invokevirtual 309	com/tencent/qqmini/sdk/runtime/core/page/widget/WebEditText:getContext	()Landroid/content/Context;
    //   223: invokestatic 417	com/tencent/qqmini/sdk/utils/DisplayUtil:getDensity	(Landroid/content/Context;)F
    //   226: fstore_2
    //   227: iload_3
    //   228: i2f
    //   229: fload_2
    //   230: fmul
    //   231: ldc_w 418
    //   234: fadd
    //   235: fconst_0
    //   236: invokestatic 424	java/lang/Math:max	(FF)F
    //   239: f2i
    //   240: istore_3
    //   241: iload 4
    //   243: i2f
    //   244: fload_2
    //   245: fmul
    //   246: ldc_w 418
    //   249: fadd
    //   250: fconst_0
    //   251: invokestatic 424	java/lang/Math:max	(FF)F
    //   254: f2i
    //   255: istore 4
    //   257: iload 6
    //   259: i2f
    //   260: fload_2
    //   261: fmul
    //   262: ldc_w 418
    //   265: fadd
    //   266: f2i
    //   267: istore 6
    //   269: aload_0
    //   270: aload_0
    //   271: getfield 48	bhgx:jdField_a_of_type_ComTencentQqminiSdkRuntimeCorePageNativeViewContainer	Lcom/tencent/qqmini/sdk/runtime/core/page/NativeViewContainer;
    //   274: invokevirtual 177	com/tencent/qqmini/sdk/runtime/core/page/NativeViewContainer:a	()I
    //   277: putfield 178	bhgx:jdField_b_of_type_Int	I
    //   280: ldc_w 426
    //   283: aload_0
    //   284: getfield 48	bhgx:jdField_a_of_type_ComTencentQqminiSdkRuntimeCorePageNativeViewContainer	Lcom/tencent/qqmini/sdk/runtime/core/page/NativeViewContainer;
    //   287: invokevirtual 427	com/tencent/qqmini/sdk/runtime/core/page/NativeViewContainer:a	()Z
    //   290: invokestatic 432	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   293: invokevirtual 436	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   296: ifeq +8 -> 304
    //   299: aload_0
    //   300: iconst_0
    //   301: putfield 178	bhgx:jdField_b_of_type_Int	I
    //   304: iload 5
    //   306: i2f
    //   307: fload_2
    //   308: fmul
    //   309: ldc_w 418
    //   312: fadd
    //   313: f2i
    //   314: istore 5
    //   316: aload_0
    //   317: getfield 48	bhgx:jdField_a_of_type_ComTencentQqminiSdkRuntimeCorePageNativeViewContainer	Lcom/tencent/qqmini/sdk/runtime/core/page/NativeViewContainer;
    //   320: invokevirtual 193	com/tencent/qqmini/sdk/runtime/core/page/NativeViewContainer:a	()Lcom/tencent/qqmini/sdk/runtime/core/page/PageWebview;
    //   323: getfield 219	com/tencent/qqmini/sdk/runtime/core/page/PageWebview:jdField_c_of_type_Int	I
    //   326: istore 7
    //   328: aload_0
    //   329: getfield 178	bhgx:jdField_b_of_type_Int	I
    //   332: istore 8
    //   334: aload_1
    //   335: invokevirtual 440	com/tencent/qqmini/sdk/runtime/core/page/widget/WebEditText:getLayoutParams	()Landroid/view/ViewGroup$LayoutParams;
    //   338: checkcast 442	android/widget/FrameLayout$LayoutParams
    //   341: astore 10
    //   343: aload 10
    //   345: iload_3
    //   346: putfield 444	android/widget/FrameLayout$LayoutParams:width	I
    //   349: aload 10
    //   351: iload 4
    //   353: putfield 446	android/widget/FrameLayout$LayoutParams:height	I
    //   356: aload 10
    //   358: iload 6
    //   360: putfield 449	android/widget/FrameLayout$LayoutParams:leftMargin	I
    //   363: aload 10
    //   365: iload 8
    //   367: iload 5
    //   369: iload 7
    //   371: isub
    //   372: iadd
    //   373: putfield 452	android/widget/FrameLayout$LayoutParams:topMargin	I
    //   376: aload_1
    //   377: invokevirtual 455	com/tencent/qqmini/sdk/runtime/core/page/widget/WebEditText:requestLayout	()V
    //   380: iconst_1
    //   381: istore 9
    //   383: goto -367 -> 16
    //   386: astore_1
    //   387: aload_1
    //   388: invokevirtual 458	java/lang/Exception:printStackTrace	()V
    //   391: iconst_0
    //   392: istore 9
    //   394: goto -378 -> 16
    //   397: astore_1
    //   398: aload_0
    //   399: monitorexit
    //   400: aload_1
    //   401: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	402	0	this	bhgx
    //   0	402	1	paramString	String
    //   226	82	2	f	float
    //   110	236	3	i	int
    //   120	232	4	j	int
    //   198	174	5	k	int
    //   188	171	6	m	int
    //   326	46	7	n	int
    //   332	41	8	i1	int
    //   14	379	9	bool	boolean
    //   6	358	10	localObject	Object
    //   84	10	11	str	String
    // Exception table:
    //   from	to	target	type
    //   21	55	386	java/lang/Exception
    //   65	101	386	java/lang/Exception
    //   101	122	386	java/lang/Exception
    //   139	146	386	java/lang/Exception
    //   146	156	386	java/lang/Exception
    //   160	165	386	java/lang/Exception
    //   165	175	386	java/lang/Exception
    //   180	257	386	java/lang/Exception
    //   269	304	386	java/lang/Exception
    //   316	380	386	java/lang/Exception
    //   2	8	397	finally
    //   21	55	397	finally
    //   65	101	397	finally
    //   101	122	397	finally
    //   139	146	397	finally
    //   146	156	397	finally
    //   160	165	397	finally
    //   165	175	397	finally
    //   180	257	397	finally
    //   269	304	397	finally
    //   316	380	397	finally
    //   387	391	397	finally
  }
  
  public void b(bgmk parambgmk)
  {
    label94:
    try
    {
      QMLog.d("WebInputHandler", ", webParams=" + parambgmk.jdField_b_of_type_JavaLangString + ", callbackId=" + parambgmk.jdField_b_of_type_Int);
      try
      {
        localObject2 = new JSONObject(parambgmk.jdField_b_of_type_JavaLangString);
        j = ((JSONObject)localObject2).optInt("inputId");
        localObject1 = (WebEditText)this.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(j));
        if (localObject1 != null) {
          break label94;
        }
        parambgmk.b();
      }
      catch (Exception parambgmk)
      {
        for (;;)
        {
          Object localObject2;
          int j;
          Object localObject1;
          QMLog.e("WebInputHandler", "setKeyboardValue error.", parambgmk);
        }
      }
      return;
    }
    finally {}
    localObject2 = ((JSONObject)localObject2).optString("value");
    this.jdField_c_of_type_JavaUtilMap.put(Integer.valueOf(j), localObject2);
    ((WebEditText)localObject1).setText((CharSequence)localObject2);
    if (localObject2 != null) {}
    for (int i = ((String)localObject2).length();; i = 0)
    {
      ((WebEditText)localObject1).setSelection(i);
      localObject1 = new JSONObject();
      ((JSONObject)localObject1).put("inputId", j);
      parambgmk.a((JSONObject)localObject1);
      break;
    }
  }
  
  /* Error */
  public void c(bgmk parambgmk)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 116
    //   4: new 118	java/lang/StringBuilder
    //   7: dup
    //   8: invokespecial 119	java/lang/StringBuilder:<init>	()V
    //   11: ldc 121
    //   13: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16: aload_1
    //   17: getfield 130	bgmk:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   20: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: ldc 132
    //   25: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   28: aload_1
    //   29: getfield 134	bgmk:jdField_b_of_type_Int	I
    //   32: invokevirtual 137	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   35: invokevirtual 141	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   38: invokestatic 146	com/tencent/qqmini/sdk/log/QMLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   41: aload_0
    //   42: getfield 34	bhgx:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   45: astore_3
    //   46: aload_3
    //   47: monitorenter
    //   48: aload_1
    //   49: getfield 130	bgmk:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   52: invokestatic 159	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   55: ifeq +21 -> 76
    //   58: ldc 116
    //   60: ldc_w 462
    //   63: invokestatic 163	com/tencent/qqmini/sdk/log/QMLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   66: aload_1
    //   67: invokevirtual 165	bgmk:b	()Ljava/lang/String;
    //   70: pop
    //   71: aload_3
    //   72: monitorexit
    //   73: aload_0
    //   74: monitorexit
    //   75: return
    //   76: new 254	org/json/JSONObject
    //   79: dup
    //   80: aload_1
    //   81: getfield 130	bgmk:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   84: invokespecial 371	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   87: ldc_w 257
    //   90: invokevirtual 375	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   93: istore_2
    //   94: aload_0
    //   95: getfield 39	bhgx:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   98: iload_2
    //   99: invokestatic 63	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   102: invokeinterface 465 2 0
    //   107: ifne +23 -> 130
    //   110: aload_1
    //   111: invokevirtual 467	bgmk:a	()Ljava/lang/String;
    //   114: pop
    //   115: aload_3
    //   116: monitorexit
    //   117: goto -44 -> 73
    //   120: astore_1
    //   121: aload_3
    //   122: monitorexit
    //   123: aload_1
    //   124: athrow
    //   125: astore_1
    //   126: aload_0
    //   127: monitorexit
    //   128: aload_1
    //   129: athrow
    //   130: aload_0
    //   131: getfield 39	bhgx:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   134: iload_2
    //   135: invokestatic 63	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   138: invokeinterface 69 2 0
    //   143: checkcast 71	com/tencent/qqmini/sdk/runtime/core/page/widget/WebEditText
    //   146: astore 4
    //   148: aload_0
    //   149: getfield 46	bhgx:jdField_c_of_type_JavaUtilMap	Ljava/util/Map;
    //   152: iload_2
    //   153: invokestatic 63	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   156: invokeinterface 334 2 0
    //   161: pop
    //   162: aload_1
    //   163: invokevirtual 467	bgmk:a	()Ljava/lang/String;
    //   166: pop
    //   167: new 254	org/json/JSONObject
    //   170: dup
    //   171: invokespecial 255	org/json/JSONObject:<init>	()V
    //   174: astore 5
    //   176: aload 5
    //   178: ldc_w 257
    //   181: iload_2
    //   182: invokevirtual 260	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   185: pop
    //   186: aload 5
    //   188: ldc_w 340
    //   191: aload 4
    //   193: invokevirtual 306	com/tencent/qqmini/sdk/runtime/core/page/widget/WebEditText:getText	()Landroid/text/Editable;
    //   196: invokevirtual 307	java/lang/Object:toString	()Ljava/lang/String;
    //   199: invokevirtual 343	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   202: pop
    //   203: aload 5
    //   205: ldc_w 345
    //   208: aload 4
    //   210: invokevirtual 306	com/tencent/qqmini/sdk/runtime/core/page/widget/WebEditText:getText	()Landroid/text/Editable;
    //   213: invokevirtual 307	java/lang/Object:toString	()Ljava/lang/String;
    //   216: invokevirtual 350	java/lang/String:length	()I
    //   219: invokevirtual 260	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   222: pop
    //   223: aload_0
    //   224: iconst_1
    //   225: invokevirtual 469	bhgx:a	(Z)V
    //   228: aload_1
    //   229: getfield 472	bgmk:a	Lbglu;
    //   232: ldc_w 352
    //   235: aload 5
    //   237: invokevirtual 353	org/json/JSONObject:toString	()Ljava/lang/String;
    //   240: iconst_0
    //   241: invokeinterface 477 4 0
    //   246: aload_3
    //   247: monitorexit
    //   248: goto -175 -> 73
    //   251: astore_1
    //   252: ldc 116
    //   254: ldc_w 479
    //   257: aload_1
    //   258: invokestatic 268	com/tencent/qqmini/sdk/log/QMLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   261: goto -15 -> 246
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	264	0	this	bhgx
    //   0	264	1	parambgmk	bgmk
    //   93	89	2	i	int
    //   146	63	4	localWebEditText	WebEditText
    //   174	62	5	localJSONObject	JSONObject
    // Exception table:
    //   from	to	target	type
    //   48	73	120	finally
    //   76	115	120	finally
    //   115	117	120	finally
    //   121	123	120	finally
    //   130	246	120	finally
    //   246	248	120	finally
    //   252	261	120	finally
    //   2	48	125	finally
    //   123	125	125	finally
    //   76	115	251	java/lang/Exception
    //   130	246	251	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bhgx
 * JD-Core Version:    0.7.0.1
 */