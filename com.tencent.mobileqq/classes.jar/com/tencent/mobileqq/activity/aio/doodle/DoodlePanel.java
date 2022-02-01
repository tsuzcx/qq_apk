package com.tencent.mobileqq.activity.aio.doodle;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewParent;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseAIOContext;
import com.tencent.mobileqq.activity.aio.doodle.control.ColorPicker;
import com.tencent.mobileqq.activity.aio.doodle.control.ColorPicker.ColorPickerData;
import com.tencent.mobileqq.activity.aio.doodle.control.GifTemplatePicker;
import com.tencent.mobileqq.activity.aio.doodle.control.GifTemplatePicker.GifTemplatePickerData;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.doodle.IDoodleXPanelContainer;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.scribble.IScribbleMsgUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.SharePreferenceUtils;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportProgressDialog;
import com.tencent.widget.ResetPanelInterface;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class DoodlePanel
  extends BaseDoodlePanel
  implements View.OnClickListener, View.OnLongClickListener, ResetPanelInterface
{
  public static int c = -1;
  public static final int d;
  protected DoodleLayout a;
  public AppRuntime b;
  private Button e;
  private ColorPicker f;
  private GifTemplatePicker g;
  private Button h;
  private boolean i = false;
  private DoodlePanelListener j;
  private boolean k = false;
  private BaseAIOContext l;
  private int m;
  private long n = 0L;
  private ProgressDialog o;
  
  static
  {
    Resources localResources = BaseApplication.getContext().getResources();
    DisplayMetrics localDisplayMetrics = localResources.getDisplayMetrics();
    d = (int)(Math.min(localDisplayMetrics.widthPixels, localDisplayMetrics.heightPixels) * 1.0F / 1.132931F) + Utils.a(81.0F, localResources);
  }
  
  public DoodlePanel(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public DoodlePanel(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  /* Error */
  private boolean a(String paramString, DoodleItem paramDoodleItem)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 4
    //   3: aload_1
    //   4: ifnull +317 -> 321
    //   7: aload_2
    //   8: ifnull +313 -> 321
    //   11: aload_1
    //   12: invokevirtual 108	java/lang/String:length	()I
    //   15: ifne +5 -> 20
    //   18: iconst_0
    //   19: ireturn
    //   20: aconst_null
    //   21: astore 6
    //   23: aconst_null
    //   24: astore 7
    //   26: aload 7
    //   28: astore 5
    //   30: new 110	java/io/File
    //   33: dup
    //   34: aload_1
    //   35: invokespecial 113	java/io/File:<init>	(Ljava/lang/String;)V
    //   38: astore_1
    //   39: aload 7
    //   41: astore 5
    //   43: aload_1
    //   44: invokevirtual 117	java/io/File:getParentFile	()Ljava/io/File;
    //   47: invokevirtual 121	java/io/File:exists	()Z
    //   50: ifne +15 -> 65
    //   53: aload 7
    //   55: astore 5
    //   57: aload_1
    //   58: invokevirtual 117	java/io/File:getParentFile	()Ljava/io/File;
    //   61: invokevirtual 124	java/io/File:mkdirs	()Z
    //   64: pop
    //   65: aload 7
    //   67: astore 5
    //   69: new 126	java/io/BufferedOutputStream
    //   72: dup
    //   73: new 128	java/io/FileOutputStream
    //   76: dup
    //   77: aload_1
    //   78: invokespecial 131	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   81: invokespecial 134	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   84: astore_1
    //   85: aload_2
    //   86: new 136	com/tencent/mobileqq/activity/aio/doodle/DoodlePanel$6
    //   89: dup
    //   90: aload_0
    //   91: aload_1
    //   92: invokespecial 139	com/tencent/mobileqq/activity/aio/doodle/DoodlePanel$6:<init>	(Lcom/tencent/mobileqq/activity/aio/doodle/DoodlePanel;Ljava/io/OutputStream;)V
    //   95: invokestatic 144	com/tencent/mobileqq/activity/aio/doodle/DoodleMsgTranslator:a	(Lcom/tencent/mobileqq/activity/aio/doodle/DoodleItem;Lcom/tencent/mobileqq/activity/aio/doodle/DoodleMsgTranslator$TranslatorListener;)Z
    //   98: pop
    //   99: aload_1
    //   100: invokevirtual 149	java/io/OutputStream:close	()V
    //   103: iconst_1
    //   104: istore_3
    //   105: goto +130 -> 235
    //   108: astore_2
    //   109: aload_1
    //   110: astore 5
    //   112: aload_2
    //   113: astore_1
    //   114: goto +156 -> 270
    //   117: astore_2
    //   118: goto +11 -> 129
    //   121: astore_1
    //   122: goto +148 -> 270
    //   125: astore_2
    //   126: aload 6
    //   128: astore_1
    //   129: aload_1
    //   130: astore 5
    //   132: aload_2
    //   133: invokevirtual 152	java/lang/Exception:printStackTrace	()V
    //   136: aload_1
    //   137: astore 5
    //   139: new 154	java/lang/StringBuilder
    //   142: dup
    //   143: invokespecial 156	java/lang/StringBuilder:<init>	()V
    //   146: astore 6
    //   148: aload_1
    //   149: astore 5
    //   151: aload 6
    //   153: ldc 158
    //   155: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   158: pop
    //   159: aload_1
    //   160: astore 5
    //   162: aload 6
    //   164: aload_2
    //   165: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   168: pop
    //   169: aload_1
    //   170: astore 5
    //   172: ldc 167
    //   174: iconst_2
    //   175: aload 6
    //   177: invokevirtual 171	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   180: invokestatic 176	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   183: iload 4
    //   185: istore_3
    //   186: aload_1
    //   187: ifnull +48 -> 235
    //   190: aload_1
    //   191: invokevirtual 149	java/io/OutputStream:close	()V
    //   194: iload 4
    //   196: istore_3
    //   197: goto +38 -> 235
    //   200: astore_1
    //   201: new 154	java/lang/StringBuilder
    //   204: dup
    //   205: invokespecial 156	java/lang/StringBuilder:<init>	()V
    //   208: astore_2
    //   209: aload_2
    //   210: ldc 178
    //   212: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   215: pop
    //   216: aload_2
    //   217: aload_1
    //   218: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   221: pop
    //   222: ldc 167
    //   224: iconst_2
    //   225: aload_2
    //   226: invokevirtual 171	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   229: invokestatic 176	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   232: iload 4
    //   234: istore_3
    //   235: new 154	java/lang/StringBuilder
    //   238: dup
    //   239: invokespecial 156	java/lang/StringBuilder:<init>	()V
    //   242: astore_1
    //   243: aload_1
    //   244: ldc 180
    //   246: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   249: pop
    //   250: aload_1
    //   251: invokestatic 186	java/lang/System:currentTimeMillis	()J
    //   254: invokevirtual 189	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   257: pop
    //   258: ldc 167
    //   260: iconst_2
    //   261: aload_1
    //   262: invokevirtual 171	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   265: invokestatic 176	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   268: iload_3
    //   269: ireturn
    //   270: aload 5
    //   272: ifnull +47 -> 319
    //   275: aload 5
    //   277: invokevirtual 149	java/io/OutputStream:close	()V
    //   280: goto +39 -> 319
    //   283: astore_2
    //   284: new 154	java/lang/StringBuilder
    //   287: dup
    //   288: invokespecial 156	java/lang/StringBuilder:<init>	()V
    //   291: astore 5
    //   293: aload 5
    //   295: ldc 178
    //   297: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   300: pop
    //   301: aload 5
    //   303: aload_2
    //   304: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   307: pop
    //   308: ldc 167
    //   310: iconst_2
    //   311: aload 5
    //   313: invokevirtual 171	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   316: invokestatic 176	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   319: aload_1
    //   320: athrow
    //   321: iconst_0
    //   322: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	323	0	this	DoodlePanel
    //   0	323	1	paramString	String
    //   0	323	2	paramDoodleItem	DoodleItem
    //   104	165	3	bool1	boolean
    //   1	232	4	bool2	boolean
    //   28	284	5	localObject1	Object
    //   21	155	6	localStringBuilder	StringBuilder
    //   24	42	7	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   85	103	108	finally
    //   85	103	117	java/lang/Exception
    //   30	39	121	finally
    //   43	53	121	finally
    //   57	65	121	finally
    //   69	85	121	finally
    //   132	136	121	finally
    //   139	148	121	finally
    //   151	159	121	finally
    //   162	169	121	finally
    //   172	183	121	finally
    //   30	39	125	java/lang/Exception
    //   43	53	125	java/lang/Exception
    //   57	65	125	java/lang/Exception
    //   69	85	125	java/lang/Exception
    //   190	194	200	java/lang/Exception
    //   275	280	283	java/lang/Exception
  }
  
  private boolean f()
  {
    long l1 = System.currentTimeMillis();
    if (l1 - this.n < 500L)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(" send click is invalid, lasttime:");
      localStringBuilder.append(this.n);
      localStringBuilder.append(" currenttime:");
      localStringBuilder.append(l1);
      QLog.d("Scribble", 2, localStringBuilder.toString());
      return false;
    }
    this.n = l1;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(" send click is valid, lasttime:");
    localStringBuilder.append(this.n);
    QLog.d("Scribble", 2, localStringBuilder.toString());
    return true;
  }
  
  private void g()
  {
    Object localObject = this.a;
    if (localObject != null)
    {
      boolean bool2 = false;
      int i1 = ((DoodleLayout)localObject).b(false, false);
      localObject = this.e;
      boolean bool1;
      if (localObject != null)
      {
        if (i1 > 0) {
          bool1 = true;
        } else {
          bool1 = false;
        }
        ((Button)localObject).setEnabled(bool1);
      }
      localObject = this.h;
      if (localObject != null)
      {
        bool1 = bool2;
        if (i1 > 0) {
          bool1 = true;
        }
        ((Button)localObject).setEnabled(bool1);
      }
    }
  }
  
  public int a(boolean paramBoolean)
  {
    DoodleLayout localDoodleLayout = this.a;
    if (localDoodleLayout != null) {
      return localDoodleLayout.b(false, paramBoolean);
    }
    return 0;
  }
  
  void a(Context paramContext, int paramInt)
  {
    try
    {
      if (this.o != null)
      {
        e();
      }
      else
      {
        this.o = new ReportProgressDialog(paramContext, 2131953338);
        this.o.setCancelable(true);
        this.o.show();
        this.o.setContentView(2131625585);
        ((TextView)this.o.findViewById(2131440191)).setText(paramInt);
      }
      if (!this.o.isShowing()) {
        this.o.show();
      }
      return;
    }
    catch (Throwable paramContext) {}
  }
  
  public void a(Bitmap paramBitmap, DoodleItem paramDoodleItem, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("sendDoodleMessage begin:");
    localStringBuilder.append(System.currentTimeMillis());
    QLog.d("Scribble", 2, localStringBuilder.toString());
    if (paramBitmap != null)
    {
      if (paramDoodleItem == null) {
        return;
      }
      a(getContext(), 2131892581);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("sendDoodleMessage before SendPapScribbleMsg:");
      localStringBuilder.append(System.currentTimeMillis());
      QLog.d("Scribble", 2, localStringBuilder.toString());
      ((IScribbleMsgUtils)QRoute.api(IScribbleMsgUtils.class)).SendScribbleMsg(this.b, this.l.O().b, this.l.O().a, paramBitmap, paramInt, new DoodlePanel.5(this, paramDoodleItem));
    }
  }
  
  public void a(BaseAIOContext paramBaseAIOContext, DoodlePanelListener paramDoodlePanelListener)
  {
    this.l = paramBaseAIOContext;
    this.j = paramDoodlePanelListener;
    this.b = MobileQQ.sMobileQQ.waitAppRuntime(null);
    c = ((IDoodleXPanelContainer)QRoute.api(IDoodleXPanelContainer.class)).getExternalPanelheight();
    paramBaseAIOContext = new StringBuilder();
    paramBaseAIOContext.append("mOriginPanelHeight:");
    paramBaseAIOContext.append(c);
    QLog.d("Scribble", 2, paramBaseAIOContext.toString());
    this.f = ((ColorPicker)super.findViewById(2131430976));
    this.f.setListener(new DoodlePanel.1(this));
    this.e = ((Button)findViewById(2131430010));
    this.e.setOnClickListener(this);
    if ((QQTheme.isNowSimpleUI()) && (Build.VERSION.SDK_INT >= 21)) {
      this.e.setBackgroundTintList(getContext().getResources().getColorStateList(2131168003));
    }
    this.g = ((GifTemplatePicker)findViewById(2131434232));
    this.g.setListener(new DoodlePanel.2(this));
    this.h = ((Button)findViewById(2131436642));
    this.h.setOnClickListener(this);
    this.h.setOnLongClickListener(this);
    this.a = ((DoodleLayout)findViewById(2131432060));
    this.a.setDoodleLayoutListener(new DoodlePanel.3(this));
    paramBaseAIOContext = SharePreferenceUtils.a(getContext(), "aio_doodle_colorpicker_select");
    boolean bool = TextUtils.isEmpty(paramBaseAIOContext);
    i2 = 1;
    int i3;
    if (!bool)
    {
      paramBaseAIOContext = paramBaseAIOContext.split(";");
      if (paramBaseAIOContext.length == 3)
      {
        i1 = Integer.valueOf(paramBaseAIOContext[0]).intValue();
        i3 = Integer.valueOf(paramBaseAIOContext[1]).intValue();
        int i4 = Integer.valueOf(paramBaseAIOContext[2]).intValue();
        this.f.b(new ColorPicker.ColorPickerData(i1, i3, i4), false);
      }
    }
    else
    {
      this.f.a(0, false);
    }
    paramBaseAIOContext = SharePreferenceUtils.a(getContext(), "aio_doodle_template_picker_select");
    i1 = i2;
    try
    {
      if (!TextUtils.isEmpty(paramBaseAIOContext))
      {
        i3 = Integer.valueOf(paramBaseAIOContext).intValue();
        i1 = i3;
        if (i3 == -1) {
          i1 = 0;
        }
      }
    }
    catch (Exception paramBaseAIOContext)
    {
      for (;;)
      {
        i1 = i2;
      }
    }
    i2 = 0;
    while (i2 < this.g.getItemCount())
    {
      paramBaseAIOContext = (GifTemplatePicker.GifTemplatePickerData)this.g.c(i2);
      if ((paramBaseAIOContext != null) && (paramBaseAIOContext.b == i1)) {
        break label444;
      }
      i2 += 1;
    }
    i2 = -1;
    label444:
    this.g.a(i2, false);
    g();
    if (AppSetting.e)
    {
      this.e.setContentDescription(HardCodeUtil.a(2131901525));
      this.h.setContentDescription(HardCodeUtil.a(2131901526));
      this.a.setContentDescription(HardCodeUtil.a(2131901527));
    }
  }
  
  public void a(ColorPicker.ColorPickerData paramColorPickerData)
  {
    if (this.a != null)
    {
      if (paramColorPickerData == null) {
        return;
      }
      if (paramColorPickerData.a == 0)
      {
        this.a.setColor(paramColorPickerData.c);
        return;
      }
      this.a.setTexture(paramColorPickerData.b);
    }
  }
  
  public boolean a()
  {
    Context localContext = getContext();
    if (a(true) > 0) {
      ReportController.b(this.b, "dc00898", "", "", "0X80081B8", "0X80081B8", 1, 0, "", "", "", "");
    }
    if (a(true) > 10)
    {
      DoodlePanel.7 local7 = new DoodlePanel.7(this);
      DialogUtil.a(localContext, 230, null, localContext.getString(2131886484), localContext.getString(2131886481), localContext.getString(2131886483), local7, local7).show();
      return true;
    }
    return false;
  }
  
  public void b()
  {
    c = ((IDoodleXPanelContainer)QRoute.api(IDoodleXPanelContainer.class)).getExternalPanelheight();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("mOriginPanelHeight:");
    localStringBuilder.append(c);
    QLog.d("Scribble", 2, localStringBuilder.toString());
    this.k = true;
    this.m = getPanelHeight();
    ((IDoodleXPanelContainer)QRoute.api(IDoodleXPanelContainer.class)).setExternalPanelheight(this.m);
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("set mExternalPanelheight :");
    localStringBuilder.append(((IDoodleXPanelContainer)QRoute.api(IDoodleXPanelContainer.class)).getExternalPanelheight());
    QLog.d("Scribble", 2, localStringBuilder.toString());
    ReportController.b(this.b, "dc00898", "", "", "0X80081B3", "0X80081B3", 1, 0, "", "", "", "");
  }
  
  public void b(boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("onHide :");
      localStringBuilder.append(paramBoolean);
      QLog.d("Scribble", 2, localStringBuilder.toString());
    }
    this.k = false;
    this.m = 0;
    if (!paramBoolean) {
      ((IDoodleXPanelContainer)QRoute.api(IDoodleXPanelContainer.class)).setExternalPanelheight(c);
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("set mExternalPanelheight :");
    localStringBuilder.append(((IDoodleXPanelContainer)QRoute.api(IDoodleXPanelContainer.class)).getExternalPanelheight());
    QLog.d("Scribble", 2, localStringBuilder.toString());
    setVisibility(8);
  }
  
  public void c()
  {
    this.j = null;
    Object localObject = this.f;
    if (localObject != null)
    {
      ((ColorPicker)localObject).c();
      this.f = null;
    }
    localObject = this.g;
    if (localObject != null)
    {
      ((GifTemplatePicker)localObject).c();
      this.g = null;
    }
    localObject = this.a;
    if (localObject != null)
    {
      ((DoodleLayout)localObject).a();
      this.a = null;
    }
    this.b = null;
  }
  
  public void d()
  {
    Object localObject = this.a;
    if (localObject != null) {
      ((DoodleLayout)localObject).a(true, true);
    }
    localObject = this.g;
    if (localObject != null) {
      ((GifTemplatePicker)localObject).a(((GifTemplatePicker)localObject).getSelectIndex(), false);
    }
    g();
  }
  
  void e()
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("cancelProgressDialog ");
      ((StringBuilder)localObject).append(System.currentTimeMillis());
      QLog.d("Scribble", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.o;
    if ((localObject != null) && (((ProgressDialog)localObject).isShowing())) {
      this.o.cancel();
    }
  }
  
  public int getDefaultExternalPanelheight()
  {
    this.m = getPanelHeight();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getDefaultExternalPanelheight , orginal:");
    localStringBuilder.append(((IDoodleXPanelContainer)QRoute.api(IDoodleXPanelContainer.class)).getExternalPanelheight());
    localStringBuilder.append(" return:");
    localStringBuilder.append(this.m);
    QLog.d("Scribble", 2, localStringBuilder.toString());
    return this.m;
  }
  
  public int getPanelHeight()
  {
    Object localObject1 = BaseApplication.getContext().getResources();
    if (localObject1 != null)
    {
      Object localObject2 = ((Resources)localObject1).getDisplayMetrics();
      int i1 = Math.min(((DisplayMetrics)localObject2).widthPixels, ((DisplayMetrics)localObject2).heightPixels);
      localObject2 = getParent();
      if ((localObject2 instanceof View))
      {
        int i2 = ((View)localObject2).getWidth();
        if ((i1 != i2) && (i2 > 0))
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("getPanelHeight , disWidth:");
          ((StringBuilder)localObject2).append(i1);
          ((StringBuilder)localObject2).append(" winwidth:");
          ((StringBuilder)localObject2).append(i2);
          QLog.d("Scribble", 2, ((StringBuilder)localObject2).toString());
          int i3 = (int)(i2 * 1.0F / 1.132931F) + Utils.a(81.0F, (Resources)localObject1);
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("getPanelHeight , disWidth:");
          ((StringBuilder)localObject1).append(i1);
          ((StringBuilder)localObject1).append(" winwidth:");
          ((StringBuilder)localObject1).append(i2);
          ((StringBuilder)localObject1).append(" nWinHeight:");
          ((StringBuilder)localObject1).append(i3);
          QLog.d("Scribble", 2, ((StringBuilder)localObject1).toString());
          return i3;
        }
      }
    }
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("getPanelHeight , use max height:");
    ((StringBuilder)localObject1).append(d);
    QLog.d("Scribble", 2, ((StringBuilder)localObject1).toString());
    return d;
  }
  
  public void onClick(View paramView)
  {
    int i1 = paramView.getId();
    Object localObject;
    if (i1 == 2131436642)
    {
      localObject = this.a;
      if (localObject != null) {
        ((DoodleLayout)localObject).b();
      }
      g();
      ReportController.b(this.b, "dc00898", "", "", "0X80081B6", "0X80081B6", 1, 0, "", "", "", "");
    }
    else if (i1 == 2131430010)
    {
      if (!f())
      {
        QLog.d("Scribble", 2, " onsend error, invalid click, return");
      }
      else if (this.j != null)
      {
        Bitmap localBitmap = this.a.getDoodleBitmap();
        if (localBitmap == null)
        {
          QLog.d("Scribble", 2, " onsend error : bitmap is null");
        }
        else
        {
          DoodleItem localDoodleItem = this.a.getDoodleItem();
          if (localDoodleItem == null)
          {
            QLog.d("Scribble", 2, " onsend error : doodleParam is null");
          }
          else
          {
            ReportController.b(this.b, "dc00898", "", "", "0X80081BB", "0X80081BB", 1, this.a.b(false, true), "", "", "", "");
            int i2 = this.a.getTemplateID();
            if (this.a.getDoodleItem() != null) {
              localObject = this.a.getDoodleItem().d();
            } else {
              localObject = "";
            }
            i1 = i2;
            if (i2 < 0) {
              i1 = 0;
            }
            ReportController.b(this.b, "dc00898", "", "", "0X8008326", "0X8008326", 0, 0, "", "", String.valueOf(i1), (String)localObject);
            a(localBitmap, localDoodleItem, this.a.getTemplateID());
            this.j.a(localBitmap, localDoodleItem, this.a.getTemplateID());
          }
        }
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    if (this.k)
    {
      if (((IDoodleXPanelContainer)QRoute.api(IDoodleXPanelContainer.class)).getExternalPanelheight() == this.m) {
        ((IDoodleXPanelContainer)QRoute.api(IDoodleXPanelContainer.class)).setExternalPanelheight(c);
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onDetachedFromWindow, set mExternalPanelheight :");
      localStringBuilder.append(((IDoodleXPanelContainer)QRoute.api(IDoodleXPanelContainer.class)).getExternalPanelheight());
      QLog.d("Scribble", 2, localStringBuilder.toString());
    }
    this.k = false;
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    int i1 = paramMotionEvent.getAction() & 0xFF;
    if (i1 == 0) {
      getParent().requestDisallowInterceptTouchEvent(true);
    } else if ((i1 == 1) || (i1 == 3)) {
      getParent().requestDisallowInterceptTouchEvent(false);
    }
    return super.onInterceptTouchEvent(paramMotionEvent);
  }
  
  public boolean onLongClick(View paramView)
  {
    if (paramView.getId() == 2131436642)
    {
      paramView = new DoodlePanel.4(this);
      DialogUtil.a(getContext(), 230, null, getContext().getString(2131886487), getContext().getString(2131886485), getContext().getString(2131886486), paramView, paramView).show();
    }
    ReportController.b(this.b, "dc00898", "", "", "0X80081B7", "0X80081B7", 1, 0, "", "", "", "");
    return true;
  }
  
  protected void onVisibilityChanged(View paramView, int paramInt)
  {
    super.onVisibilityChanged(paramView, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.doodle.DoodlePanel
 * JD-Core Version:    0.7.0.1
 */