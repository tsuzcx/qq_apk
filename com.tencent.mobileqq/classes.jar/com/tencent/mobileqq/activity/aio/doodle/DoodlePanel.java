package com.tencent.mobileqq.activity.aio.doodle;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
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
  public static int a;
  public static final int b;
  private long jdField_a_of_type_Long = 0L;
  private ProgressDialog jdField_a_of_type_AndroidAppProgressDialog;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private BaseAIOContext jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseAIOContext;
  protected DoodleLayout a;
  private DoodlePanelListener jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodlePanelListener;
  private ColorPicker jdField_a_of_type_ComTencentMobileqqActivityAioDoodleControlColorPicker;
  private GifTemplatePicker jdField_a_of_type_ComTencentMobileqqActivityAioDoodleControlGifTemplatePicker;
  public AppRuntime a;
  private boolean jdField_a_of_type_Boolean = false;
  private Button jdField_b_of_type_AndroidWidgetButton;
  private boolean jdField_b_of_type_Boolean = false;
  private int c;
  
  static
  {
    Resources localResources = BaseApplication.getContext().getResources();
    DisplayMetrics localDisplayMetrics = localResources.getDisplayMetrics();
    jdField_b_of_type_Int = (int)(Math.min(localDisplayMetrics.widthPixels, localDisplayMetrics.heightPixels) * 1.0F / 1.132931F) + Utils.a(81.0F, localResources);
    jdField_a_of_type_Int = -1;
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
    //   12: invokevirtual 101	java/lang/String:length	()I
    //   15: ifne +5 -> 20
    //   18: iconst_0
    //   19: ireturn
    //   20: aconst_null
    //   21: astore 6
    //   23: aconst_null
    //   24: astore 7
    //   26: aload 7
    //   28: astore 5
    //   30: new 103	java/io/File
    //   33: dup
    //   34: aload_1
    //   35: invokespecial 106	java/io/File:<init>	(Ljava/lang/String;)V
    //   38: astore_1
    //   39: aload 7
    //   41: astore 5
    //   43: aload_1
    //   44: invokevirtual 110	java/io/File:getParentFile	()Ljava/io/File;
    //   47: invokevirtual 114	java/io/File:exists	()Z
    //   50: ifne +15 -> 65
    //   53: aload 7
    //   55: astore 5
    //   57: aload_1
    //   58: invokevirtual 110	java/io/File:getParentFile	()Ljava/io/File;
    //   61: invokevirtual 117	java/io/File:mkdirs	()Z
    //   64: pop
    //   65: aload 7
    //   67: astore 5
    //   69: new 119	java/io/BufferedOutputStream
    //   72: dup
    //   73: new 121	java/io/FileOutputStream
    //   76: dup
    //   77: aload_1
    //   78: invokespecial 124	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   81: invokespecial 127	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   84: astore_1
    //   85: aload_2
    //   86: new 129	com/tencent/mobileqq/activity/aio/doodle/DoodlePanel$6
    //   89: dup
    //   90: aload_0
    //   91: aload_1
    //   92: invokespecial 132	com/tencent/mobileqq/activity/aio/doodle/DoodlePanel$6:<init>	(Lcom/tencent/mobileqq/activity/aio/doodle/DoodlePanel;Ljava/io/OutputStream;)V
    //   95: invokestatic 137	com/tencent/mobileqq/activity/aio/doodle/DoodleMsgTranslator:a	(Lcom/tencent/mobileqq/activity/aio/doodle/DoodleItem;Lcom/tencent/mobileqq/activity/aio/doodle/DoodleMsgTranslator$TranslatorListener;)Z
    //   98: pop
    //   99: aload_1
    //   100: invokevirtual 142	java/io/OutputStream:close	()V
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
    //   133: invokevirtual 145	java/lang/Exception:printStackTrace	()V
    //   136: aload_1
    //   137: astore 5
    //   139: new 147	java/lang/StringBuilder
    //   142: dup
    //   143: invokespecial 149	java/lang/StringBuilder:<init>	()V
    //   146: astore 6
    //   148: aload_1
    //   149: astore 5
    //   151: aload 6
    //   153: ldc 151
    //   155: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   158: pop
    //   159: aload_1
    //   160: astore 5
    //   162: aload 6
    //   164: aload_2
    //   165: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   168: pop
    //   169: aload_1
    //   170: astore 5
    //   172: ldc 160
    //   174: iconst_2
    //   175: aload 6
    //   177: invokevirtual 164	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   180: invokestatic 170	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   183: iload 4
    //   185: istore_3
    //   186: aload_1
    //   187: ifnull +48 -> 235
    //   190: aload_1
    //   191: invokevirtual 142	java/io/OutputStream:close	()V
    //   194: iload 4
    //   196: istore_3
    //   197: goto +38 -> 235
    //   200: astore_1
    //   201: new 147	java/lang/StringBuilder
    //   204: dup
    //   205: invokespecial 149	java/lang/StringBuilder:<init>	()V
    //   208: astore_2
    //   209: aload_2
    //   210: ldc 172
    //   212: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   215: pop
    //   216: aload_2
    //   217: aload_1
    //   218: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   221: pop
    //   222: ldc 160
    //   224: iconst_2
    //   225: aload_2
    //   226: invokevirtual 164	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   229: invokestatic 170	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   232: iload 4
    //   234: istore_3
    //   235: new 147	java/lang/StringBuilder
    //   238: dup
    //   239: invokespecial 149	java/lang/StringBuilder:<init>	()V
    //   242: astore_1
    //   243: aload_1
    //   244: ldc 174
    //   246: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   249: pop
    //   250: aload_1
    //   251: invokestatic 180	java/lang/System:currentTimeMillis	()J
    //   254: invokevirtual 183	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   257: pop
    //   258: ldc 160
    //   260: iconst_2
    //   261: aload_1
    //   262: invokevirtual 164	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   265: invokestatic 170	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   268: iload_3
    //   269: ireturn
    //   270: aload 5
    //   272: ifnull +47 -> 319
    //   275: aload 5
    //   277: invokevirtual 142	java/io/OutputStream:close	()V
    //   280: goto +39 -> 319
    //   283: astore_2
    //   284: new 147	java/lang/StringBuilder
    //   287: dup
    //   288: invokespecial 149	java/lang/StringBuilder:<init>	()V
    //   291: astore 5
    //   293: aload 5
    //   295: ldc 172
    //   297: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   300: pop
    //   301: aload 5
    //   303: aload_2
    //   304: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   307: pop
    //   308: ldc 160
    //   310: iconst_2
    //   311: aload 5
    //   313: invokevirtual 164	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   316: invokestatic 170	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
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
  
  private boolean b()
  {
    long l = System.currentTimeMillis();
    if (l - this.jdField_a_of_type_Long < 500L)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(" send click is invalid, lasttime:");
      localStringBuilder.append(this.jdField_a_of_type_Long);
      localStringBuilder.append(" currenttime:");
      localStringBuilder.append(l);
      QLog.d("Scribble", 2, localStringBuilder.toString());
      return false;
    }
    this.jdField_a_of_type_Long = l;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(" send click is valid, lasttime:");
    localStringBuilder.append(this.jdField_a_of_type_Long);
    QLog.d("Scribble", 2, localStringBuilder.toString());
    return true;
  }
  
  private void e()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleLayout;
    if (localObject != null)
    {
      boolean bool2 = false;
      int i = ((DoodleLayout)localObject).a(false, false);
      localObject = this.jdField_a_of_type_AndroidWidgetButton;
      boolean bool1;
      if (localObject != null)
      {
        if (i > 0) {
          bool1 = true;
        } else {
          bool1 = false;
        }
        ((Button)localObject).setEnabled(bool1);
      }
      localObject = this.jdField_b_of_type_AndroidWidgetButton;
      if (localObject != null)
      {
        bool1 = bool2;
        if (i > 0) {
          bool1 = true;
        }
        ((Button)localObject).setEnabled(bool1);
      }
    }
  }
  
  public int a()
  {
    this.c = b();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getDefaultExternalPanelheight , orginal:");
    localStringBuilder.append(((IDoodleXPanelContainer)QRoute.api(IDoodleXPanelContainer.class)).getExternalPanelheight());
    localStringBuilder.append(" return:");
    localStringBuilder.append(this.c);
    QLog.d("Scribble", 2, localStringBuilder.toString());
    return this.c;
  }
  
  public int a(boolean paramBoolean)
  {
    DoodleLayout localDoodleLayout = this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleLayout;
    if (localDoodleLayout != null) {
      return localDoodleLayout.a(false, paramBoolean);
    }
    return 0;
  }
  
  public void a()
  {
    jdField_a_of_type_Int = ((IDoodleXPanelContainer)QRoute.api(IDoodleXPanelContainer.class)).getExternalPanelheight();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("mOriginPanelHeight:");
    localStringBuilder.append(jdField_a_of_type_Int);
    QLog.d("Scribble", 2, localStringBuilder.toString());
    this.jdField_b_of_type_Boolean = true;
    this.c = b();
    ((IDoodleXPanelContainer)QRoute.api(IDoodleXPanelContainer.class)).setExternalPanelheight(this.c);
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("set mExternalPanelheight :");
    localStringBuilder.append(((IDoodleXPanelContainer)QRoute.api(IDoodleXPanelContainer.class)).getExternalPanelheight());
    QLog.d("Scribble", 2, localStringBuilder.toString());
    ReportController.b(this.jdField_a_of_type_MqqAppAppRuntime, "dc00898", "", "", "0X80081B3", "0X80081B3", 1, 0, "", "", "", "");
  }
  
  void a(Context paramContext, int paramInt)
  {
    try
    {
      if (this.jdField_a_of_type_AndroidAppProgressDialog != null)
      {
        d();
      }
      else
      {
        this.jdField_a_of_type_AndroidAppProgressDialog = new ReportProgressDialog(paramContext, 2131756189);
        this.jdField_a_of_type_AndroidAppProgressDialog.setCancelable(true);
        this.jdField_a_of_type_AndroidAppProgressDialog.show();
        this.jdField_a_of_type_AndroidAppProgressDialog.setContentView(2131559561);
        ((TextView)this.jdField_a_of_type_AndroidAppProgressDialog.findViewById(2131372646)).setText(paramInt);
      }
      if (!this.jdField_a_of_type_AndroidAppProgressDialog.isShowing()) {
        this.jdField_a_of_type_AndroidAppProgressDialog.show();
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
      a(getContext(), 2131694878);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("sendDoodleMessage before SendPapScribbleMsg:");
      localStringBuilder.append(System.currentTimeMillis());
      QLog.d("Scribble", 2, localStringBuilder.toString());
      ((IScribbleMsgUtils)QRoute.api(IScribbleMsgUtils.class)).SendScribbleMsg(this.jdField_a_of_type_MqqAppAppRuntime, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseAIOContext.a().jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseAIOContext.a().jdField_a_of_type_Int, paramBitmap, paramInt, new DoodlePanel.5(this, paramDoodleItem));
    }
  }
  
  public void a(BaseAIOContext paramBaseAIOContext, DoodlePanelListener paramDoodlePanelListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseAIOContext = paramBaseAIOContext;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodlePanelListener = paramDoodlePanelListener;
    this.jdField_a_of_type_MqqAppAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
    jdField_a_of_type_Int = ((IDoodleXPanelContainer)QRoute.api(IDoodleXPanelContainer.class)).getExternalPanelheight();
    paramBaseAIOContext = new StringBuilder();
    paramBaseAIOContext.append("mOriginPanelHeight:");
    paramBaseAIOContext.append(jdField_a_of_type_Int);
    QLog.d("Scribble", 2, paramBaseAIOContext.toString());
    this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleControlColorPicker = ((ColorPicker)super.findViewById(2131364851));
    this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleControlColorPicker.setListener(new DoodlePanel.1(this));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131364052));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleControlGifTemplatePicker = ((GifTemplatePicker)findViewById(2131367686));
    this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleControlGifTemplatePicker.setListener(new DoodlePanel.2(this));
    this.jdField_b_of_type_AndroidWidgetButton = ((Button)findViewById(2131369541));
    this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetButton.setOnLongClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleLayout = ((DoodleLayout)findViewById(2131365803));
    this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleLayout.setDoodleLayoutListener(new DoodlePanel.3(this));
    paramBaseAIOContext = SharePreferenceUtils.a(getContext(), "aio_doodle_colorpicker_select");
    boolean bool = TextUtils.isEmpty(paramBaseAIOContext);
    j = 1;
    int k;
    if (!bool)
    {
      paramBaseAIOContext = paramBaseAIOContext.split(";");
      if (paramBaseAIOContext.length == 3)
      {
        i = Integer.valueOf(paramBaseAIOContext[0]).intValue();
        k = Integer.valueOf(paramBaseAIOContext[1]).intValue();
        int m = Integer.valueOf(paramBaseAIOContext[2]).intValue();
        this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleControlColorPicker.b(new ColorPicker.ColorPickerData(i, k, m), false);
      }
    }
    else
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleControlColorPicker.a(0, false);
    }
    paramBaseAIOContext = SharePreferenceUtils.a(getContext(), "aio_doodle_template_picker_select");
    i = j;
    try
    {
      if (!TextUtils.isEmpty(paramBaseAIOContext))
      {
        k = Integer.valueOf(paramBaseAIOContext).intValue();
        i = k;
        if (k == -1) {
          i = 0;
        }
      }
    }
    catch (Exception paramBaseAIOContext)
    {
      for (;;)
      {
        i = j;
      }
    }
    j = 0;
    while (j < this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleControlGifTemplatePicker.b())
    {
      paramBaseAIOContext = (GifTemplatePicker.GifTemplatePickerData)this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleControlGifTemplatePicker.a(j);
      if ((paramBaseAIOContext != null) && (paramBaseAIOContext.jdField_b_of_type_Int == i)) {
        break label408;
      }
      j += 1;
    }
    j = -1;
    label408:
    this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleControlGifTemplatePicker.a(j, false);
    e();
    if (AppSetting.d)
    {
      this.jdField_a_of_type_AndroidWidgetButton.setContentDescription(HardCodeUtil.a(2131703574));
      this.jdField_b_of_type_AndroidWidgetButton.setContentDescription(HardCodeUtil.a(2131703575));
      this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleLayout.setContentDescription(HardCodeUtil.a(2131703576));
    }
  }
  
  public void a(ColorPicker.ColorPickerData paramColorPickerData)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleLayout != null)
    {
      if (paramColorPickerData == null) {
        return;
      }
      if (paramColorPickerData.jdField_a_of_type_Int == 0)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleLayout.setColor(paramColorPickerData.c);
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleLayout.setTexture(paramColorPickerData.jdField_b_of_type_Int);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("onHide :");
      localStringBuilder.append(paramBoolean);
      QLog.d("Scribble", 2, localStringBuilder.toString());
    }
    this.jdField_b_of_type_Boolean = false;
    this.c = 0;
    if (!paramBoolean) {
      ((IDoodleXPanelContainer)QRoute.api(IDoodleXPanelContainer.class)).setExternalPanelheight(jdField_a_of_type_Int);
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("set mExternalPanelheight :");
    localStringBuilder.append(((IDoodleXPanelContainer)QRoute.api(IDoodleXPanelContainer.class)).getExternalPanelheight());
    QLog.d("Scribble", 2, localStringBuilder.toString());
    setVisibility(8);
  }
  
  public boolean a()
  {
    Context localContext = getContext();
    if (a(true) > 0) {
      ReportController.b(this.jdField_a_of_type_MqqAppAppRuntime, "dc00898", "", "", "0X80081B8", "0X80081B8", 1, 0, "", "", "", "");
    }
    if (a(true) > 10)
    {
      DoodlePanel.7 local7 = new DoodlePanel.7(this);
      DialogUtil.a(localContext, 230, null, localContext.getString(2131689843), localContext.getString(2131689840), localContext.getString(2131689842), local7, local7).show();
      return true;
    }
    return false;
  }
  
  public int b()
  {
    Object localObject1 = BaseApplication.getContext().getResources();
    if (localObject1 != null)
    {
      Object localObject2 = ((Resources)localObject1).getDisplayMetrics();
      int i = Math.min(((DisplayMetrics)localObject2).widthPixels, ((DisplayMetrics)localObject2).heightPixels);
      localObject2 = getParent();
      if ((localObject2 instanceof View))
      {
        int j = ((View)localObject2).getWidth();
        if ((i != j) && (j > 0))
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("getPanelHeight , disWidth:");
          ((StringBuilder)localObject2).append(i);
          ((StringBuilder)localObject2).append(" winwidth:");
          ((StringBuilder)localObject2).append(j);
          QLog.d("Scribble", 2, ((StringBuilder)localObject2).toString());
          int k = (int)(j * 1.0F / 1.132931F) + Utils.a(81.0F, (Resources)localObject1);
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("getPanelHeight , disWidth:");
          ((StringBuilder)localObject1).append(i);
          ((StringBuilder)localObject1).append(" winwidth:");
          ((StringBuilder)localObject1).append(j);
          ((StringBuilder)localObject1).append(" nWinHeight:");
          ((StringBuilder)localObject1).append(k);
          QLog.d("Scribble", 2, ((StringBuilder)localObject1).toString());
          return k;
        }
      }
    }
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("getPanelHeight , use max height:");
    ((StringBuilder)localObject1).append(jdField_b_of_type_Int);
    QLog.d("Scribble", 2, ((StringBuilder)localObject1).toString());
    return jdField_b_of_type_Int;
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodlePanelListener = null;
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleControlColorPicker;
    if (localObject != null)
    {
      ((ColorPicker)localObject).b();
      this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleControlColorPicker = null;
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleControlGifTemplatePicker;
    if (localObject != null)
    {
      ((GifTemplatePicker)localObject).b();
      this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleControlGifTemplatePicker = null;
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleLayout;
    if (localObject != null)
    {
      ((DoodleLayout)localObject).a();
      this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleLayout = null;
    }
    this.jdField_a_of_type_MqqAppAppRuntime = null;
  }
  
  public void c()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleLayout;
    if (localObject != null) {
      ((DoodleLayout)localObject).a(true, true);
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleControlGifTemplatePicker;
    if (localObject != null) {
      ((GifTemplatePicker)localObject).a(((GifTemplatePicker)localObject).a(), false);
    }
    e();
  }
  
  void d()
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("cancelProgressDialog ");
      ((StringBuilder)localObject).append(System.currentTimeMillis());
      QLog.d("Scribble", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.jdField_a_of_type_AndroidAppProgressDialog;
    if ((localObject != null) && (((ProgressDialog)localObject).isShowing())) {
      this.jdField_a_of_type_AndroidAppProgressDialog.cancel();
    }
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    Object localObject;
    if (i == 2131369541)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleLayout;
      if (localObject != null) {
        ((DoodleLayout)localObject).b();
      }
      e();
      ReportController.b(this.jdField_a_of_type_MqqAppAppRuntime, "dc00898", "", "", "0X80081B6", "0X80081B6", 1, 0, "", "", "", "");
    }
    else if (i == 2131364052)
    {
      if (!b())
      {
        QLog.d("Scribble", 2, " onsend error, invalid click, return");
      }
      else if (this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodlePanelListener != null)
      {
        Bitmap localBitmap = this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleLayout.a();
        if (localBitmap == null)
        {
          QLog.d("Scribble", 2, " onsend error : bitmap is null");
        }
        else
        {
          DoodleItem localDoodleItem = this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleLayout.a();
          if (localDoodleItem == null)
          {
            QLog.d("Scribble", 2, " onsend error : doodleParam is null");
          }
          else
          {
            ReportController.b(this.jdField_a_of_type_MqqAppAppRuntime, "dc00898", "", "", "0X80081BB", "0X80081BB", 1, this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleLayout.a(false, true), "", "", "", "");
            int j = this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleLayout.a();
            if (this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleLayout.a() != null) {
              localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleLayout.a().a();
            } else {
              localObject = "";
            }
            i = j;
            if (j < 0) {
              i = 0;
            }
            ReportController.b(this.jdField_a_of_type_MqqAppAppRuntime, "dc00898", "", "", "0X8008326", "0X8008326", 0, 0, "", "", String.valueOf(i), (String)localObject);
            a(localBitmap, localDoodleItem, this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleLayout.a());
            this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodlePanelListener.a(localBitmap, localDoodleItem, this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleLayout.a());
          }
        }
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    if (this.jdField_b_of_type_Boolean)
    {
      if (((IDoodleXPanelContainer)QRoute.api(IDoodleXPanelContainer.class)).getExternalPanelheight() == this.c) {
        ((IDoodleXPanelContainer)QRoute.api(IDoodleXPanelContainer.class)).setExternalPanelheight(jdField_a_of_type_Int);
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onDetachedFromWindow, set mExternalPanelheight :");
      localStringBuilder.append(((IDoodleXPanelContainer)QRoute.api(IDoodleXPanelContainer.class)).getExternalPanelheight());
      QLog.d("Scribble", 2, localStringBuilder.toString());
    }
    this.jdField_b_of_type_Boolean = false;
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction() & 0xFF;
    if (i == 0) {
      getParent().requestDisallowInterceptTouchEvent(true);
    } else if ((i == 1) || (i == 3)) {
      getParent().requestDisallowInterceptTouchEvent(false);
    }
    return super.onInterceptTouchEvent(paramMotionEvent);
  }
  
  public boolean onLongClick(View paramView)
  {
    if (paramView.getId() == 2131369541)
    {
      paramView = new DoodlePanel.4(this);
      DialogUtil.a(getContext(), 230, null, getContext().getString(2131689846), getContext().getString(2131689844), getContext().getString(2131689845), paramView, paramView).show();
    }
    ReportController.b(this.jdField_a_of_type_MqqAppAppRuntime, "dc00898", "", "", "0X80081B7", "0X80081B7", 1, 0, "", "", "", "");
    return true;
  }
  
  protected void onVisibilityChanged(View paramView, int paramInt)
  {
    super.onVisibilityChanged(paramView, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.doodle.DoodlePanel
 * JD-Core Version:    0.7.0.1
 */