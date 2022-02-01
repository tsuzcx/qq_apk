package com.tencent.mobileqq.activity.aio.helper;

import android.annotation.SuppressLint;
import android.content.ClipData;
import android.content.ClipData.Item;
import android.content.ClipDescription;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Paint.FontMetrics;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.media.ThumbnailUtils;
import android.os.Build.VERSION;
import android.text.Editable;
import android.text.Editable.Factory;
import android.text.Html;
import android.text.Html.ImageGetter;
import android.text.Html.TagHandler;
import android.text.InputFilter;
import android.text.Selection;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.method.MovementMethod;
import android.text.style.ImageSpan;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import android.view.ActionMode.Callback;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.biz.anonymous.AnonymousChatHelper;
import com.tencent.common.config.AppSetting;
import com.tencent.image.Utils;
import com.tencent.imcore.message.Message;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.InputLinearLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.core.BaseTroopChatPie;
import com.tencent.mobileqq.activity.aio.core.FriendChatPie;
import com.tencent.mobileqq.activity.aio.core.TroopChatPie;
import com.tencent.mobileqq.activity.aio.core.helper.CoreHelperProvider;
import com.tencent.mobileqq.activity.aio.core.helper.OnFinishListener;
import com.tencent.mobileqq.activity.aio.core.input.AIOInput;
import com.tencent.mobileqq.activity.aio.core.tips.IMsgTipsFilter;
import com.tencent.mobileqq.activity.aio.core.tips.TipsController;
import com.tencent.mobileqq.activity.aio.coreui.input.AIOInputState;
import com.tencent.mobileqq.activity.aio.coreui.input.InputUIContainer;
import com.tencent.mobileqq.activity.aio.panel.PanelListener;
import com.tencent.mobileqq.activity.aio.panel.PanelManager;
import com.tencent.mobileqq.activity.aio.rebuild.PAContext;
import com.tencent.mobileqq.activity.aio.rebuild.StrangerChatPie;
import com.tencent.mobileqq.activity.aio.rebuild.tips.RobotContext;
import com.tencent.mobileqq.activity.aio.tips.TipsManager;
import com.tencent.mobileqq.apollo.script.api.ISpriteCommFunc;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForReplyText.SourceMsgInfo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.ThumbWidthHeightDP;
import com.tencent.mobileqq.doutu.DoutuHelper;
import com.tencent.mobileqq.doutu.api.IDoutuService;
import com.tencent.mobileqq.emoticon.QQSysFaceUtil;
import com.tencent.mobileqq.emoticonview.AIOEmoticonPanelHelper;
import com.tencent.mobileqq.mixedmsg.LinkMovementMethodExt;
import com.tencent.mobileqq.mixedmsg.MixedMsgInfo;
import com.tencent.mobileqq.mixedmsg.MixedMsgInfo.MsgNode;
import com.tencent.mobileqq.mixedmsg.MixedMsgInfo.PhotoItem;
import com.tencent.mobileqq.mixedmsg.MixedMsgInfo.PhotoMsgNode;
import com.tencent.mobileqq.mixedmsg.MixedMsgInfo.TextLocation;
import com.tencent.mobileqq.mixedmsg.MixedMsgInfo.TextMsgNode;
import com.tencent.mobileqq.mixedmsg.MixedMsgManager;
import com.tencent.mobileqq.ocr.api.IOCR;
import com.tencent.mobileqq.qmethodmonitor.monitor.ClipboardMonitor;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.receipt.ReceiptHelper;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.text.QQTextBuilder;
import com.tencent.mobileqq.transfile.CommonImgThumbHelper;
import com.tencent.mobileqq.troop.data.TroopAioTips;
import com.tencent.mobileqq.troop.essencemsg.TroopEssenceReportUtil;
import com.tencent.mobileqq.troop.essencemsg.TroopEssenceUtil;
import com.tencent.mobileqq.troop.navigatebar.AioTips;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.navbar.NavBarAIO;
import com.tencent.mobileqq.writetogether.api.IWriteTogetherConfig;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.widget.PatchedButton;
import com.tencent.widget.XEditTextEx;
import com.tencent.widget.XEditTextEx.OnKeyboardShowListener;
import com.tencent.widget.XEditTextEx.TextMenuListener;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;
import org.xml.sax.XMLReader;

public class FullScreenInputHelper
  implements View.OnClickListener, OnFinishListener, IMsgTipsFilter, ILifeCycleHelper, OnActivityResultCallback, PanelListener
{
  private static final int[] g = { 2130851875, 2130851873, 2130851874 };
  private static volatile boolean j = true;
  protected BaseChatPie a;
  public View b;
  public ImageButton c;
  protected ImageButton d;
  protected PatchedButton e;
  private final AIOContext h;
  private Context i;
  private FullScreenInputHelper.TextChangeInfo k;
  private ClipData l;
  private ClipData m;
  private Map<String, Boolean> n = new HashMap(40);
  private SimpleFullScreenHelper o;
  private TextView p;
  private LinearLayout q;
  private ViewTreeObserver.OnGlobalLayoutListener r;
  private View s;
  private CheckBox t;
  private boolean u = false;
  private volatile boolean v = false;
  private Html.ImageGetter w = new FullScreenInputHelper.1(this);
  private Html.TagHandler x = new FullScreenInputHelper.2(this);
  private XEditTextEx.TextMenuListener y = new FullScreenInputHelper.10(this);
  
  public FullScreenInputHelper(BaseChatPie paramBaseChatPie, CoreHelperProvider paramCoreHelperProvider)
  {
    this.h = paramBaseChatPie.bv();
    this.a = paramBaseChatPie;
    this.i = paramBaseChatPie.e;
    paramCoreHelperProvider.a(this);
    paramCoreHelperProvider.a(this);
  }
  
  private void A()
  {
    if (this.a.Y != null)
    {
      if (this.r != null) {
        this.a.Y.getViewTreeObserver().removeGlobalOnLayoutListener(this.r);
      }
      this.a.Y.setFilters(new InputFilter[0]);
      this.a.Y.setOnWindowFocusChangedListener(null);
      this.a.Y.b(this.y);
      this.a.Y.setOnLongClickListener(null);
      if (Build.VERSION.SDK_INT >= 23) {
        this.a.Y.setCustomInsertionActionModeCallback(null);
      }
      this.a.Y.setCustomSelectionActionModeCallback(null);
    }
    LinkMovementMethodExt.a(null);
    LinkMovementMethodExt.a(null);
    e(false);
  }
  
  private void B()
  {
    int i1 = this.e.getVisibility();
    this.c.setVisibility(0);
    if (i1 != 0) {
      SimpleFullInputReporter.a(this.a.d, "0X800BDCB", u(), "");
    }
  }
  
  private void C()
  {
    if (this.h.q().b() == 3)
    {
      AIOEmoticonPanelHelper localAIOEmoticonPanelHelper = (AIOEmoticonPanelHelper)this.h.a(104);
      if (localAIOEmoticonPanelHelper != null) {
        localAIOEmoticonPanelHelper.doOnEmoticonPanelFullScreen();
      }
    }
  }
  
  private boolean D()
  {
    AIOContext localAIOContext = this.h;
    return (!(localAIOContext instanceof PAContext)) && (!(localAIOContext instanceof RobotContext));
  }
  
  private MixedMsgInfo.MsgNode a(String paramString, MixedMsgInfo.TextLocation paramTextLocation)
  {
    if (android.text.TextUtils.isEmpty(paramString)) {
      return null;
    }
    String str = paramString;
    if (paramTextLocation == MixedMsgInfo.TextLocation.HEADER) {
      str = com.tencent.mobileqq.text.TextUtils.trimNewLine(paramString, true);
    }
    paramString = str;
    if (paramTextLocation == MixedMsgInfo.TextLocation.TAILOR) {
      paramString = com.tencent.mobileqq.text.TextUtils.trimNewLine(str, false);
    }
    return new MixedMsgInfo.TextMsgNode(paramString);
  }
  
  private String a(Spanned paramSpanned, int paramInt)
  {
    Map localMap = c(this.a.Y.getText());
    StringBuilder localStringBuilder = new StringBuilder();
    int i2;
    for (int i1 = 0; i1 < paramSpanned.length(); i1 = i2 + 1)
    {
      char c1 = paramSpanned.charAt(i1);
      Object localObject;
      if (c1 == "￼".charAt(0))
      {
        localObject = (String)localMap.get(Integer.valueOf(i1 + paramInt));
        i2 = i1;
        if (!android.text.TextUtils.isEmpty((CharSequence)localObject))
        {
          localStringBuilder.append(b((String)localObject));
          i2 = i1;
        }
      }
      else if (c1 == '\n')
      {
        localStringBuilder.append(m());
        i2 = i1;
      }
      else if (c1 == '\024')
      {
        int i3 = i1 + 1;
        i2 = i1;
        if (i3 < paramSpanned.length()) {
          if (QQSysFaceUtil.isValidFaceId(paramSpanned.charAt(i3)))
          {
            localStringBuilder.append(a(paramSpanned.charAt(i3)));
            i2 = i3;
          }
          else
          {
            localObject = new char[4];
            i2 = i1;
            if (i1 + 4 < paramSpanned.length())
            {
              i2 = 0;
              while (i2 < 4)
              {
                i1 += 1;
                localObject[i2] = paramSpanned.charAt(i1);
                i2 += 1;
              }
              localStringBuilder.append(a((char[])localObject));
              i2 = i1;
            }
          }
        }
      }
      else
      {
        localStringBuilder.append(c1);
        i2 = i1;
      }
    }
    return localStringBuilder.toString();
  }
  
  private String a(XMLReader paramXMLReader, String paramString)
  {
    try
    {
      Object localObject = paramXMLReader.getClass().getDeclaredField("theNewElement");
      ((Field)localObject).setAccessible(true);
      paramXMLReader = ((Field)localObject).get(paramXMLReader);
      localObject = paramXMLReader.getClass().getDeclaredField("theAtts");
      ((Field)localObject).setAccessible(true);
      localObject = ((Field)localObject).get(paramXMLReader);
      paramXMLReader = localObject.getClass().getDeclaredField("data");
      paramXMLReader.setAccessible(true);
      paramXMLReader = (String[])paramXMLReader.get(localObject);
      Field localField = localObject.getClass().getDeclaredField("length");
      localField.setAccessible(true);
      int i2 = ((Integer)localField.get(localObject)).intValue();
      int i1 = 0;
      while (i1 < i2)
      {
        int i3 = i1 * 5;
        localObject = paramXMLReader[(i3 + 1)];
        localField = paramXMLReader[(i3 + 4)];
        boolean bool = ((String)localObject).equalsIgnoreCase(paramString);
        if (bool) {
          return localField;
        }
        i1 += 1;
      }
      return null;
    }
    catch (Exception paramXMLReader)
    {
      paramXMLReader.printStackTrace();
    }
  }
  
  private void a(Intent paramIntent)
  {
    int i1;
    if ((paramIntent != null) && (paramIntent.getBooleanExtra("input_full_screen_mode", false))) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    if (i1 != 0)
    {
      paramIntent = paramIntent.getStringExtra("input_full_screen_mode_result");
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onActivityResult fullInputMode ");
        ((StringBuilder)localObject).append(paramIntent);
        QLog.d("FullScreenInputHelper", 2, ((StringBuilder)localObject).toString());
      }
      Object localObject = new ArrayList();
      ((ArrayList)localObject).add(paramIntent);
      a((List)localObject, false);
    }
  }
  
  private void a(View paramView)
  {
    VideoReport.setElementId(paramView, "em_aio_textbox_input_full_screen_button");
    VideoReport.setElementExposePolicy(paramView, ExposurePolicy.REPORT_ALL);
    VideoReport.setElementParam(paramView, "is_full_screen_button_open", Integer.valueOf(1));
  }
  
  private void b(int paramInt)
  {
    if (!e()) {
      return;
    }
    String str = null;
    if (paramInt == 1) {
      str = "2";
    } else if (paramInt == 2) {
      str = "3";
    }
    if (str == null) {
      return;
    }
    SimpleFullInputReporter.a(this.a.d, "0X800BDCF", 0, str);
  }
  
  private void b(View paramView)
  {
    VideoReport.setElementId(paramView, "em_aio_textbox_input_full_screen_button");
    VideoReport.setElementExposePolicy(paramView, ExposurePolicy.REPORT_ALL);
    VideoReport.setElementParam(paramView, "is_full_screen_button_open", Integer.valueOf(0));
  }
  
  private Editable c(String paramString)
  {
    paramString = (Editable)Html.fromHtml(paramString, this.w, this.x);
    int i1 = paramString.length();
    do
    {
      i1 -= 1;
    } while ((i1 >= 0) && (paramString.charAt(i1) == "\n".charAt(0)));
    return a(paramString.subSequence(0, i1 + 1));
  }
  
  private Map<Integer, String> c(Spanned paramSpanned)
  {
    HashMap localHashMap = new HashMap(20);
    int i2 = paramSpanned.length();
    int i1 = 0;
    ImageSpan[] arrayOfImageSpan = (ImageSpan[])paramSpanned.getSpans(0, i2, ImageSpan.class);
    i2 = arrayOfImageSpan.length;
    while (i1 < i2)
    {
      Object localObject = arrayOfImageSpan[i1];
      int i3 = paramSpanned.getSpanStart(localObject);
      localObject = ((ImageSpan)localObject).getSource();
      if ((i3 >= 0) && (!android.text.TextUtils.isEmpty((CharSequence)localObject)))
      {
        if ((!f) && (localObject == null)) {
          throw new AssertionError();
        }
        localHashMap.put(Integer.valueOf(i3), localObject);
      }
      i1 += 1;
    }
    return localHashMap;
  }
  
  private boolean c(int paramInt)
  {
    Editable localEditable = this.a.Y.getText();
    if (((ImageSpan[])localEditable.getSpans(0, localEditable.length(), ImageSpan.class)).length + paramInt > 20)
    {
      QQToast.makeText(this.a.d.getApp(), 2131892578, 0).show(this.a.d.getApp().getResources().getDimensionPixelSize(2131299920));
      return true;
    }
    return false;
  }
  
  private static boolean c(Editable paramEditable, String paramString)
  {
    boolean bool2 = android.text.TextUtils.isEmpty(paramEditable);
    boolean bool1 = false;
    if (bool2) {
      return false;
    }
    if (paramEditable.charAt(0) == paramString.charAt(0)) {
      bool1 = true;
    }
    return bool1;
  }
  
  private String d(Spanned paramSpanned)
  {
    paramSpanned = b(paramSpanned);
    if (paramSpanned == null) {
      return "";
    }
    return paramSpanned.b();
  }
  
  private static boolean d(Editable paramEditable, String paramString)
  {
    boolean bool2 = android.text.TextUtils.isEmpty(paramEditable);
    boolean bool1 = false;
    if (bool2) {
      return false;
    }
    if (paramEditable.charAt(paramEditable.length() - 1) == paramString.charAt(0)) {
      bool1 = true;
    }
    return bool1;
  }
  
  private void h(boolean paramBoolean)
  {
    this.v = paramBoolean;
  }
  
  private void i(boolean paramBoolean)
  {
    this.e.setEnabled(paramBoolean);
  }
  
  private int q()
  {
    if (QQTheme.isNowSimpleUI()) {
      return AIOUtils.b(25.0F, this.a.f.getResources());
    }
    return AIOUtils.b(50.0F, this.a.f.getResources());
  }
  
  private boolean r()
  {
    boolean bool1 = e();
    boolean bool2 = false;
    if ((bool1) && (QQTheme.isNowSimpleUI())) {
      return false;
    }
    bool1 = bool2;
    if (this.a.ah != null)
    {
      bool1 = bool2;
      if (((IWriteTogetherConfig)QRoute.api(IWriteTogetherConfig.class)).isAllowShowEntrance(this.a.d, this.a.ah.b))
      {
        WriteTogetherHelper localWriteTogetherHelper = (WriteTogetherHelper)this.a.q(74);
        bool1 = bool2;
        if (localWriteTogetherHelper != null)
        {
          bool1 = bool2;
          if (localWriteTogetherHelper.d()) {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  @SuppressLint({"RtlHardcoded"})
  private void s()
  {
    if (this.p != null) {
      return;
    }
    this.p = new TextView(this.i);
    this.p.setId(2131430074);
    this.p.setText(this.i.getResources().getText(2131918127));
    this.p.setTextColor(this.i.getResources().getColor(2131168097));
    this.p.setBackgroundResource(2130852138);
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-2, -2);
    localLayoutParams.leftMargin = this.i.getResources().getDimensionPixelSize(2131300089);
    localLayoutParams.rightMargin = this.i.getResources().getDimensionPixelSize(2131300092);
    localLayoutParams.bottomMargin = this.i.getResources().getDimensionPixelSize(2131300087);
    localLayoutParams.gravity = 83;
    this.p.setLayoutParams(localLayoutParams);
    this.p.setOnClickListener(this);
    this.p.setVisibility(8);
    if (AppSetting.e) {
      this.p.setContentDescription(HardCodeUtil.a(2131886130));
    }
    ((FrameLayout)this.b).addView(this.p);
  }
  
  private void t()
  {
    if (this.s != null) {
      return;
    }
    this.s = this.a.aX().getLayoutInflater().inflate(2131624426, null);
    this.s.setBackgroundResource(2130852138);
    Object localObject = new FrameLayout.LayoutParams(-2, -2);
    ((FrameLayout.LayoutParams)localObject).leftMargin = this.i.getResources().getDimensionPixelSize(2131300088);
    ((FrameLayout.LayoutParams)localObject).bottomMargin = this.i.getResources().getDimensionPixelSize(2131300087);
    ((FrameLayout.LayoutParams)localObject).gravity = 80;
    this.s.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.t = ((CheckBox)this.s.findViewById(2131446675));
    this.t.setChecked(false);
    this.t.setOnClickListener(this);
    localObject = (TextView)this.s.findViewById(2131446676);
    ((TextView)localObject).setTextColor(this.i.getResources().getColor(2131168097));
    ((TextView)localObject).setOnClickListener(this);
    ((FrameLayout)this.b).addView(this.s);
  }
  
  private int u()
  {
    BaseChatPie localBaseChatPie = this.a;
    if ((localBaseChatPie instanceof FriendChatPie)) {
      return 1;
    }
    if ((localBaseChatPie instanceof BaseTroopChatPie)) {
      return 2;
    }
    if ((localBaseChatPie instanceof StrangerChatPie)) {
      return 3;
    }
    return 4;
  }
  
  private void v()
  {
    ViewGroup.LayoutParams localLayoutParams1 = this.q.getLayoutParams();
    ViewGroup.LayoutParams localLayoutParams2 = this.q.findViewById(2131433922).getLayoutParams();
    View localView = this.a.f.findViewById(2131449307);
    if (!QQTheme.isNowSimpleUI())
    {
      if (localView != null) {
        localView.setVisibility(8);
      }
      localLayoutParams1.height = -2;
      localLayoutParams2.height = -2;
      return;
    }
    localLayoutParams1.height = -1;
    localLayoutParams2.height = -1;
    if (localView != null) {
      localView.setVisibility(0);
    }
  }
  
  private void w()
  {
    this.a.j().post(new FullScreenInputHelper.7(this));
  }
  
  private int x()
  {
    int i2 = this.a.ah.a;
    if ((i2 >= 1000) && (i2 <= 1038)) {
      return 3;
    }
    int i1 = 1;
    if (i2 != 0)
    {
      if (i2 != 1) {
        return 4;
      }
      i1 = 2;
    }
    return i1;
  }
  
  private void y()
  {
    
    if (this.a.Y != null) {
      this.a.Y.setOnDragListener(new FullScreenInputHelper.8(this));
    }
  }
  
  private void z()
  {
    
    if (this.a.Y != null) {
      this.a.Y.setOnDragListener(null);
    }
  }
  
  Drawable a(Context paramContext, String paramString)
  {
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    BitmapFactory.decodeFile(paramString, localOptions);
    Object localObject = CommonImgThumbHelper.getThumbWidthHeightDP(false);
    int i3 = ((ThumbWidthHeightDP)localObject).mMinWidth;
    int i4 = ((ThumbWidthHeightDP)localObject).mMinHeight;
    int i5 = ((ThumbWidthHeightDP)localObject).mMaxWidth;
    int i6 = ((ThumbWidthHeightDP)localObject).mMaxHeight;
    int i2 = localOptions.outWidth;
    int i1 = localOptions.outHeight;
    if ((i2 > 0) && (i1 > 0))
    {
      if ((i2 >= i3) && (i1 >= i4))
      {
        if ((i2 >= i5) || (i1 >= i6))
        {
          float f2;
          if (i2 > i1)
          {
            f1 = i5;
            f2 = i2;
          }
          else
          {
            f1 = i6;
            f2 = i1;
          }
          float f3 = f1 / f2;
          if (i2 > i1)
          {
            f1 = i4;
            f2 = i1;
          }
          else
          {
            f1 = i3;
            f2 = i2;
          }
          f1 = Math.max(f3, f1 / f2);
          i3 = (int)(i2 * f1 + 0.5F);
          i4 = (int)(i1 * f1 + 0.5F);
          i2 = i3;
          i1 = i4;
          if (QLog.isColorLevel())
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("scale2:");
            ((StringBuilder)localObject).append(f1);
            QLog.d("FullScreenInputHelper", 2, ((StringBuilder)localObject).toString());
            i2 = i3;
            i1 = i4;
          }
        }
      }
      else
      {
        if (i2 < i1)
        {
          f1 = i3 / i2;
          i4 = Math.min((int)(i1 * f1 + 0.5F), i6);
        }
        else
        {
          f1 = i4 / i1;
          i3 = Math.min((int)(i2 * f1 + 0.5F), i5);
        }
        i2 = i3;
        i1 = i4;
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("scale1:");
          ((StringBuilder)localObject).append(f1);
          QLog.d("FullScreenInputHelper", 2, ((StringBuilder)localObject).toString());
          i2 = i3;
          i1 = i4;
        }
      }
    }
    else
    {
      i2 = 99;
      i1 = 99;
    }
    float f1 = paramContext.getResources().getDisplayMetrics().densityDpi / 160.0F;
    i2 = (int)(i2 * f1 + 0.5F);
    i1 = (int)(i1 * f1 + 0.5F);
    localOptions.inSampleSize = Utils.calculateInSampleSize(localOptions, i2, i1);
    localOptions.inJustDecodeBounds = false;
    paramString = ThumbnailUtils.extractThumbnail(((IOCR)QRoute.api(IOCR.class)).safeDecode(paramString, localOptions, 1, 4), i2, i1, 2);
    paramContext = new BitmapDrawable(paramContext.getResources(), paramString);
    paramContext.setBounds(0, 0, i2, i1);
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder();
      paramString.append("thumb drawable setBounds, w:");
      paramString.append(i2);
      paramString.append(", h:");
      paramString.append(i1);
      QLog.d("FullScreenInputHelper", 2, paramString.toString());
    }
    return paramContext;
  }
  
  Editable a(CharSequence paramCharSequence)
  {
    return QQTextBuilder.EMOTION_INPUT_FACTORY.newEditable(paramCharSequence);
  }
  
  public CharSequence a(AIOContext paramAIOContext, Intent paramIntent, MessageRecord paramMessageRecord, Message paramMessage)
  {
    return null;
  }
  
  String a(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("<emotion id=\"");
    localStringBuilder.append(paramInt);
    localStringBuilder.append("\">");
    return localStringBuilder.toString();
  }
  
  public String a(Spanned paramSpanned)
  {
    Object localObject = paramSpanned;
    if (paramSpanned == null) {
      localObject = this.a.Y.getText();
    }
    return a((Spanned)localObject, 0);
  }
  
  String a(char[] paramArrayOfChar)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("<");
    localStringBuilder.append("littleEmotion");
    int i1 = 0;
    while (i1 < 4)
    {
      localStringBuilder.append(" index");
      localStringBuilder.append(i1);
      localStringBuilder.append("=\"");
      localStringBuilder.append(paramArrayOfChar[i1]);
      localStringBuilder.append("\"");
      i1 += 1;
    }
    localStringBuilder.append(">");
    return localStringBuilder.toString();
  }
  
  public void a(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    if (j) {
      this.k = new FullScreenInputHelper.TextChangeInfo(paramCharSequence, paramInt1, paramInt2, paramInt3);
    }
  }
  
  public void a(String paramString)
  {
    paramString = c(paramString);
    this.a.Y.setText(paramString);
  }
  
  public void a(List<String> paramList, boolean paramBoolean)
  {
    if (c(paramList.size())) {
      return;
    }
    Editable localEditable1 = a("");
    Editable localEditable2 = this.a.Y.getText();
    int i1 = Selection.getSelectionStart(localEditable2);
    if ((i1 > 0) && (!localEditable2.subSequence(0, i1).toString().endsWith("\n"))) {
      localEditable1.append("\n");
    }
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      localEditable1.append(c(b(str))).append("\n");
      this.n.put(str, Boolean.valueOf(paramBoolean));
    }
    if (localEditable2.subSequence(i1, localEditable2.length()).toString().startsWith("\n")) {
      localEditable1.delete(localEditable1.length() - 1, localEditable1.length());
    }
    j = false;
    localEditable2.insert(i1, localEditable1);
    i1 = Selection.getSelectionStart(localEditable2);
    if (localEditable2.charAt(i1 - 1) == "￼".charAt(0)) {
      Selection.setSelection(this.a.Y.getText(), i1 + 1);
    }
    j = true;
    MixedMsgManager.a("0X800AE19", paramList.size());
  }
  
  public boolean a()
  {
    return this.a.bv().p().d().a().a() != 2;
  }
  
  public boolean a(Editable paramEditable)
  {
    if ((e()) && (r()))
    {
      boolean bool;
      if (o() == 0) {
        bool = true;
      } else {
        bool = false;
      }
      c(bool);
      MessageForReplyText.SourceMsgInfo localSourceMsgInfo = ((ReplyHelper)this.a.q(119)).a();
      if ((this.a != null) && (localSourceMsgInfo == null)) {
        bool = true;
      } else {
        bool = false;
      }
      d(bool);
    }
    if (j)
    {
      this.k.a(paramEditable);
      try
      {
        this.k.a(this.a.Y);
      }
      catch (Throwable localThrowable)
      {
        localThrowable.printStackTrace();
      }
    }
    if (this.v)
    {
      if (paramEditable.length() > 0)
      {
        i(true);
        return true;
      }
      i(false);
      return true;
    }
    if ((this.a.Y.getLineCount() > 3) && (D()) && (a())) {
      B();
    } else {
      this.c.setVisibility(8);
    }
    if (paramEditable.length() == 0) {
      e(false);
    }
    return false;
  }
  
  public boolean a(AIOContext paramAIOContext, MessageRecord paramMessageRecord, Message paramMessage)
  {
    return e();
  }
  
  public boolean a(boolean paramBoolean)
  {
    return e();
  }
  
  public MixedMsgInfo b(Spanned paramSpanned)
  {
    if (paramSpanned.length() <= 0) {
      return null;
    }
    MixedMsgInfo localMixedMsgInfo = new MixedMsgInfo();
    Object localObject1 = (ImageSpan[])paramSpanned.getSpans(0, paramSpanned.length(), ImageSpan.class);
    SparseArray localSparseArray = new SparseArray();
    int i2 = localObject1.length;
    int i1 = 0;
    Object localObject2;
    while (i1 < i2)
    {
      localObject2 = localObject1[i1];
      localSparseArray.append(paramSpanned.getSpanStart(localObject2), localObject2);
      i1 += 1;
    }
    i1 = 0;
    int i3;
    for (i2 = 0; i1 < localSparseArray.size(); i2 = i3)
    {
      localObject2 = (ImageSpan)localSparseArray.valueAt(i1);
      int i4 = paramSpanned.getSpanStart(localObject2);
      i3 = paramSpanned.getSpanEnd(localObject2);
      String str = paramSpanned.subSequence(i2, i4).toString();
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("[mix]getMixedText ImageSpan: ");
        ((StringBuilder)localObject1).append(((ImageSpan)localObject2).getSource());
        ((StringBuilder)localObject1).append(" {start: ");
        ((StringBuilder)localObject1).append(i4);
        ((StringBuilder)localObject1).append(" end: ");
        ((StringBuilder)localObject1).append(i3);
        ((StringBuilder)localObject1).append(" all: ");
        ((StringBuilder)localObject1).append(paramSpanned.length());
        ((StringBuilder)localObject1).append("} prefix: ");
        ((StringBuilder)localObject1).append(str);
        QLog.d("FullScreenInputHelper", 2, ((StringBuilder)localObject1).toString());
      }
      if (i1 == 0) {
        localObject1 = MixedMsgInfo.TextLocation.HEADER;
      } else {
        localObject1 = MixedMsgInfo.TextLocation.INLINE;
      }
      localMixedMsgInfo.a(a(str, (MixedMsgInfo.TextLocation)localObject1));
      localObject1 = ((ImageSpan)localObject2).getSource();
      localObject2 = (Boolean)this.n.get(localObject1);
      boolean bool;
      if (localObject2 != null) {
        bool = ((Boolean)localObject2).booleanValue();
      } else {
        bool = false;
      }
      localMixedMsgInfo.a(new MixedMsgInfo.PhotoMsgNode(new MixedMsgInfo.PhotoItem((String)localObject1, bool)));
      i1 += 1;
    }
    localMixedMsgInfo.a(a(paramSpanned.subSequence(i2, paramSpanned.length()).toString(), MixedMsgInfo.TextLocation.TAILOR));
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("[mix]mixedMsgInfo size:");
      ((StringBuilder)localObject1).append(localMixedMsgInfo.a().size());
      ((StringBuilder)localObject1).append(" [start: ");
      ((StringBuilder)localObject1).append(i2);
      ((StringBuilder)localObject1).append(" end: ");
      ((StringBuilder)localObject1).append(paramSpanned.length());
      QLog.d("FullScreenInputHelper", 2, ((StringBuilder)localObject1).toString());
    }
    return localMixedMsgInfo;
  }
  
  public CharSequence b(AIOContext paramAIOContext, MessageRecord paramMessageRecord, Message paramMessage)
  {
    return null;
  }
  
  public String b(CharSequence paramCharSequence)
  {
    Object localObject = paramCharSequence;
    if (paramCharSequence == null) {
      localObject = this.a.Y.getText();
    }
    if (localObject == null) {
      return null;
    }
    return ((CharSequence)localObject).toString().replaceAll("￼", "[图片]");
  }
  
  String b(String paramString)
  {
    if (android.text.TextUtils.isEmpty(paramString)) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("<img src=\"");
    localStringBuilder.append(paramString);
    localStringBuilder.append("\">");
    return localStringBuilder.toString();
  }
  
  protected void b()
  {
    QQAppInterface localQQAppInterface = this.a.d;
    ReportController.b(localQQAppInterface, "dc00898", "", "", "0X800AD27", "0X800AD27", x(), 0, "", "", "", "");
    boolean bool = true;
    h(true);
    AIOUtils.l = true;
    Object localObject = (AddFriendHelper)this.a.q(113);
    if (localObject != null) {
      ((AddFriendHelper)localObject).g();
    }
    ((ISpriteCommFunc)QRoute.api(ISpriteCommFunc.class)).showOrHideSprite(localQQAppInterface, "full_screen_input", true);
    AIOUtils.m = true;
    if (this.a.au != null)
    {
      if ((this.a.au instanceof TroopAioTips)) {
        ((TroopAioTips)this.a.au).s();
      }
      this.a.au.e();
      this.a.au.k = true;
    }
    this.a.bx().e();
    this.a.J().c();
    ((DoutuHelper)this.a.q(115)).b();
    ((ReceiptHelper)this.h.a(118)).a(8);
    localObject = (PhotoListHelper)this.h.a(7);
    if (localObject != null) {
      ((PhotoListHelper)localObject).e();
    }
    localObject = this.h.q();
    int i1 = ((PanelManager)localObject).b();
    if ((this.h.C() != null) && (i1 != 1) && (i1 != 3))
    {
      ((PanelManager)localObject).a(true);
      ((PanelManager)localObject).a(1, true);
    }
    localObject = this.c.getLayoutParams();
    ViewGroup.LayoutParams localLayoutParams = this.d.getLayoutParams();
    ((ViewGroup.LayoutParams)localObject).width = q();
    ((ViewGroup.LayoutParams)localObject).height = q();
    localLayoutParams.width = q();
    localLayoutParams.height = q();
    int i3 = q();
    this.a.p.setVisibility(8);
    this.q.setVisibility(8);
    this.c.setVisibility(8);
    this.e.setVisibility(0);
    this.e.setEnabled(this.a.bn());
    this.b.getLayoutParams().height = -1;
    localObject = this.a.Y.getLayoutParams();
    ((ViewGroup.LayoutParams)localObject).height = -1;
    ((ViewGroup.LayoutParams)localObject).width = -1;
    if ((localObject instanceof ViewGroup.MarginLayoutParams))
    {
      int i2 = ImmersiveUtils.getStatusBarHeight(this.i);
      i1 = i2;
      if (QQTheme.isNowSimpleUI()) {
        i1 = i2 + AIOUtils.b(20.0F, this.a.f.getResources()) + i3;
      }
      ((ViewGroup.MarginLayoutParams)localObject).setMargins(0, i1, 0, 0);
    }
    this.a.Y.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.a.Y.setMaxLines(100);
    this.a.Y.setGravity(48);
    this.d.setVisibility(0);
    if ((o() == 0) && (r())) {
      c(true);
    } else {
      c(false);
    }
    localObject = ((ReplyHelper)this.a.q(119)).a();
    if ((this.a == null) || (localObject != null)) {
      bool = false;
    }
    d(bool);
    this.a.X.setPadding(0, 0, 0, 0);
    this.a.Y.setPadding(AIOUtils.b(24.0F, localQQAppInterface.getApplication().getResources()), AIOUtils.b(10.0F, localQQAppInterface.getApplication().getResources()), AIOUtils.b(24.0F, localQQAppInterface.getApplication().getResources()), AIOUtils.b(40.0F, localQQAppInterface.getApplication().getResources()));
    this.a.X.getLayoutParams().height = -1;
    ((AIOInputRightHelper)this.a.q(117)).b();
    C();
    this.o.a();
  }
  
  public void b(boolean paramBoolean)
  {
    if (!e()) {
      return;
    }
    QQAppInterface localQQAppInterface = this.a.d;
    h(false);
    AIOUtils.l = false;
    Object localObject;
    if (!paramBoolean)
    {
      localObject = (AddFriendHelper)this.a.q(113);
      if (localObject != null) {
        ((AddFriendHelper)localObject).g();
      }
      if (a()) {
        ((ISpriteCommFunc)QRoute.api(ISpriteCommFunc.class)).showOrHideSprite(localQQAppInterface, "full_screen_input", false);
      }
    }
    AIOUtils.m = false;
    if (this.a.au != null) {
      this.a.au.k = false;
    }
    this.o.b();
    ((IDoutuService)localQQAppInterface.getRuntimeService(IDoutuService.class, "")).setComboShowSwitch(true);
    this.a.p.setVisibility(0);
    this.q.setVisibility(0);
    this.a.o(this.e.isEnabled());
    this.e.setVisibility(8);
    this.d.setVisibility(8);
    c(false);
    d(false);
    if (!paramBoolean)
    {
      localObject = (ReceiptHelper)this.h.a(118);
      if (((ReceiptHelper)localObject).a) {
        ((ReceiptHelper)localObject).a(0);
      }
      if ((this.a instanceof TroopChatPie)) {
        ((HWTroopClassInfoTipsHelper)this.h.a(73)).d();
      }
    }
    this.a.X.getLayoutParams().height = -2;
    this.b.getLayoutParams().height = -2;
    if (paramBoolean)
    {
      this.a.X.setPadding(0, AIOUtils.b(8.0F, localQQAppInterface.getApplication().getResources()), 0, 0);
      this.a.Y.getLayoutParams().height = -2;
      ((FrameLayout.LayoutParams)this.a.Y.getLayoutParams()).setMargins(AIOUtils.b(14.0F, localQQAppInterface.getApplication().getResources()), 0, 0, 0);
      this.a.Y.setMaxLines(6);
      this.a.Y.setGravity(16);
      this.a.Y.setPadding(AIOUtils.b(11.0F, localQQAppInterface.getApplication().getResources()), AIOUtils.b(6.0F, localQQAppInterface.getApplication().getResources()), AIOUtils.b(11.0F, localQQAppInterface.getApplication().getResources()), AIOUtils.b(6.0F, localQQAppInterface.getApplication().getResources()));
      ((SimpleUIAIOHelper)this.a.q(29)).d();
      return;
    }
    this.a.X.setPadding(0, AIOUtils.b(8.0F, localQQAppInterface.getApplication().getResources()), 0, 0);
    this.a.Y.getLayoutParams().height = -2;
    ((FrameLayout.LayoutParams)this.a.Y.getLayoutParams()).setMargins(AIOUtils.b(14.0F, localQQAppInterface.getApplication().getResources()), 0, 0, 0);
    this.a.Y.setMaxLines(6);
    this.a.Y.setGravity(16);
    this.a.Y.setPadding(AIOUtils.b(11.0F, localQQAppInterface.getApplication().getResources()), AIOUtils.b(6.0F, localQQAppInterface.getApplication().getResources()), AIOUtils.b(11.0F, localQQAppInterface.getApplication().getResources()), AIOUtils.b(6.0F, localQQAppInterface.getApplication().getResources()));
    this.a.Y.requestLayout();
    this.a.j().postDelayed(new FullScreenInputHelper.3(this), 100L);
    h();
    C();
    ((SimpleUIAIOHelper)this.a.q(29)).d();
  }
  
  public int bM_()
  {
    return 0;
  }
  
  protected void c(boolean paramBoolean)
  {
    s();
    int i1;
    if (paramBoolean)
    {
      this.p.setVisibility(0);
      i1 = this.i.getResources().getDimensionPixelSize(2131300088);
    }
    else
    {
      this.p.setVisibility(8);
      i1 = this.i.getResources().getDimensionPixelSize(2131300089);
    }
    Object localObject = this.s;
    if (localObject != null)
    {
      localObject = (FrameLayout.LayoutParams)((View)localObject).getLayoutParams();
      if (localObject != null) {
        ((FrameLayout.LayoutParams)localObject).leftMargin = i1;
      }
      this.s.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
  }
  
  protected void d(boolean paramBoolean)
  {
    Object localObject = this.a;
    if ((localObject != null) && (((BaseChatPie)localObject).ah != null) && (this.a.ah.a == 1) && (!AnonymousChatHelper.a().a(this.a.ah.b)))
    {
      if (!TroopEssenceUtil.d(this.a.i(), this.a.ah.b)) {
        return;
      }
      t();
      localObject = this.s;
      if (localObject == null) {
        return;
      }
      if (paramBoolean)
      {
        ((View)localObject).setVisibility(0);
        localObject = (FrameLayout.LayoutParams)this.s.getLayoutParams();
        if (localObject != null)
        {
          TextView localTextView = this.p;
          if ((localTextView != null) && (localTextView.getVisibility() == 0)) {
            ((FrameLayout.LayoutParams)localObject).leftMargin = this.i.getResources().getDimensionPixelSize(2131300088);
          } else {
            ((FrameLayout.LayoutParams)localObject).leftMargin = this.i.getResources().getDimensionPixelSize(2131300089);
          }
          this.s.setLayoutParams((ViewGroup.LayoutParams)localObject);
          TroopEssenceReportUtil.e(this.a.i(), this.a.ah.b);
          TroopEssenceReportUtil.f(this.a.i(), this.a.ah.b);
        }
      }
      else
      {
        ((View)localObject).setVisibility(8);
      }
    }
  }
  
  public boolean d()
  {
    return this.u;
  }
  
  public boolean d(int paramInt)
  {
    return false;
  }
  
  public void e(int paramInt) {}
  
  public void e(boolean paramBoolean)
  {
    CheckBox localCheckBox = this.t;
    if (localCheckBox != null) {
      localCheckBox.setChecked(paramBoolean);
    }
  }
  
  public boolean e()
  {
    return this.v;
  }
  
  public void f()
  {
    this.b = this.h.d(2131433906);
    this.c = ((ImageButton)this.h.d(2131433904));
    this.d = ((ImageButton)this.h.d(2131435038));
    this.q = ((LinearLayout)this.h.d(2131433921));
    this.e = ((PatchedButton)this.h.d(2131433905));
    a(this.c);
    this.c.setOnClickListener(this);
    b(this.d);
    this.d.setOnClickListener(this);
    this.e.setOnClickListener(this);
    if (AppSetting.e)
    {
      this.c.setContentDescription(HardCodeUtil.a(2131902953));
      this.d.setContentDescription(HardCodeUtil.a(2131902950));
    }
    this.a.Y.setFilters(new InputFilter[] { new FullScreenInputHelper.4(this) });
    Object localObject = new FullScreenInputHelper.5(this);
    this.a.Y.setCustomSelectionActionModeCallback((ActionMode.Callback)localObject);
    if (Build.VERSION.SDK_INT >= 23) {
      this.a.Y.setCustomInsertionActionModeCallback((ActionMode.Callback)localObject);
    }
    this.a.Y.a(this.y);
    this.a.Y.setOnLongClickListener(new FullScreenInputHelper.6(this));
    j = true;
    localObject = new int[2];
    this.a.Y.getLocationOnScreen((int[])localObject);
    localObject = LinkMovementMethodExt.a(localObject[0], ImageSpan.class);
    LinkMovementMethodExt.a(this);
    LinkMovementMethodExt.a(this.a);
    this.a.Y.setMovementMethod((MovementMethod)localObject);
    this.a.Y.setOnKeyboardShowListener((XEditTextEx.OnKeyboardShowListener)localObject);
    v();
    this.o = new SimpleFullScreenHelper(this);
  }
  
  boolean f(boolean paramBoolean)
  {
    Object localObject1 = k();
    int i1 = this.a.Y.getSelectionStart();
    int i2 = this.a.Y.getSelectionEnd();
    Object localObject3 = (Spanned)this.a.Y.getText().subSequence(i1, i2);
    Object localObject2 = a((Spanned)localObject3, i1);
    localObject3 = d((Spanned)localObject3);
    if (android.text.TextUtils.isEmpty((CharSequence)localObject3)) {
      return false;
    }
    if (QLog.isColorLevel())
    {
      localObject4 = new StringBuilder();
      ((StringBuilder)localObject4).append("[mix]ClipBoard CopyOrCut startIndex: ");
      ((StringBuilder)localObject4).append(i1);
      ((StringBuilder)localObject4).append(" endIndex: ");
      ((StringBuilder)localObject4).append(i2);
      QLog.d("FullScreenInputHelper", 2, ((StringBuilder)localObject4).toString());
    }
    Object localObject4 = ClipData.newPlainText("FullScreenInputHelper", (CharSequence)localObject3);
    Intent localIntent = new Intent();
    localIntent.putExtra("FullScreenInputHelper", (String)localObject2);
    ((ClipData)localObject4).addItem(new ClipData.Item(localIntent));
    this.l = ((ClipData)localObject4);
    this.m = ClipData.newPlainText("FullScreenInputHelper", (CharSequence)localObject3);
    localObject2 = this.m;
    ClipboardMonitor.setPrimaryClip((ClipboardManager)localObject1, (ClipData)localObject2);
    ((ClipboardManager)localObject1).setPrimaryClip((ClipData)localObject2);
    if (paramBoolean)
    {
      localObject1 = this.a.Y.getText();
      ((Editable)localObject1).delete(i1, i2);
      this.a.Y.setText((CharSequence)localObject1);
    }
    else
    {
      this.a.Y.setSelection(i2);
    }
    return true;
  }
  
  public void g()
  {
    this.r = new FullScreenInputHelper.9(this);
    this.a.Y.getViewTreeObserver().addOnGlobalLayoutListener(this.r);
  }
  
  public String getTag()
  {
    return "FullScreenInputHelper";
  }
  
  public void h()
  {
    float f1 = Math.abs(this.a.Y.getPaint().getFontMetrics().bottom - this.a.Y.getPaint().getFontMetrics().top);
    this.a.Y.setMaxHeight(Math.round(f1 * 6.0F));
  }
  
  public boolean i()
  {
    return android.text.TextUtils.isEmpty(this.a.Y.getText());
  }
  
  public int[] interestedIn()
  {
    return new int[] { 0, 3, 7, 15, 11 };
  }
  
  public void j()
  {
    this.a.bh();
    this.n.clear();
  }
  
  ClipboardManager k()
  {
    return (ClipboardManager)this.a.f.getSystemService("clipboard");
  }
  
  boolean l()
  {
    Object localObject1 = k();
    ClipboardMonitor.getPrimaryClip((ClipboardManager)localObject1);
    localObject1 = ((ClipboardManager)localObject1).getPrimaryClip();
    Object localObject2 = ((ClipData)localObject1).getDescription();
    if ((localObject2 != null) && (((ClipDescription)localObject2).getLabel() != null) && ("FullScreenInputHelper".equalsIgnoreCase(((ClipDescription)localObject2).getLabel().toString()))) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    if ((i1 != 0) && (this.l != null))
    {
      if (localObject1 == null) {}
      while ((this.m != null) && (((ClipData)localObject1).getItemAt(0).getText() != null) && (this.m.getItemAt(0).getText() != null) && (((ClipData)localObject1).getItemAt(0).getText().toString().equals(this.m.getItemAt(0).getText().toString())))
      {
        i1 = 1;
        break;
      }
    }
    int i1 = 0;
    if (i1 != 0) {
      localObject1 = this.l;
    }
    if ((localObject1 != null) && (((ClipData)localObject1).getItemCount() == 2) && (((ClipData)localObject1).getItemAt(1).getIntent() != null))
    {
      localObject1 = ((ClipData)localObject1).getItemAt(1).getIntent().getStringExtra("FullScreenInputHelper");
      localObject2 = c((String)localObject1);
      if (c(((ImageSpan[])((Editable)localObject2).getSpans(0, ((Editable)localObject2).length(), ImageSpan.class)).length)) {
        return true;
      }
      Editable localEditable = this.a.Y.getText();
      localEditable = localEditable.replace(Selection.getSelectionStart(localEditable), Selection.getSelectionEnd(localEditable), (CharSequence)localObject2, 0, ((Editable)localObject2).length());
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("[mix] ClipBoard paste html: ");
        localStringBuilder.append((String)localObject1);
        localStringBuilder.append(" text: ");
        localStringBuilder.append(localObject2);
        localStringBuilder.append(" result: ");
        localStringBuilder.append(localEditable);
        QLog.d("FullScreenInputHelper", 2, localStringBuilder.toString());
      }
      return true;
    }
    return false;
  }
  
  String m()
  {
    return "<newLine>";
  }
  
  public MixedMsgInfo n()
  {
    return b(this.a.Y.getText());
  }
  
  public int o()
  {
    Object localObject = this.a.Y.getText();
    if ((localObject != null) && (((Spanned)localObject).length() > 0))
    {
      localObject = (ImageSpan[])((Spanned)localObject).getSpans(0, ((Spanned)localObject).length(), ImageSpan.class);
      if (localObject != null) {
        return localObject.length;
      }
    }
    return 0;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt2 == -1)
    {
      if (paramInt1 == 10017)
      {
        ArrayList localArrayList = paramIntent.getStringArrayListExtra("input_full_screen_mode_result");
        boolean bool = false;
        if (paramIntent.getIntExtra("PhotoConst.SEND_SIZE_SPEC", 0) == 2) {
          bool = true;
        }
        a(localArrayList, bool);
        return;
      }
      if (paramInt1 == 11) {
        a(paramIntent);
      }
    }
  }
  
  public void onClick(View paramView)
  {
    Object localObject = this.a.d;
    switch (paramView.getId())
    {
    default: 
      break;
    case 2131446676: 
      localObject = this.t;
      if (localObject != null) {
        ((CheckBox)localObject).setChecked(((CheckBox)localObject).isChecked() ^ true);
      }
    case 2131446675: 
      localObject = this.a;
      if ((localObject == null) || (((BaseChatPie)localObject).ah == null)) {
        break label498;
      }
      TroopEssenceReportUtil.g(this.a.i(), this.a.ah.b);
      TroopEssenceReportUtil.h(this.a.i(), this.a.ah.b);
      break;
    case 2131435038: 
      ReportController.b((AppRuntime)localObject, "dc00898", "", "", "0X8009F36", "0X8009F36", x(), 0, "", "", "", "");
      if (QQTheme.isNowSimpleUI())
      {
        this.o.d();
        SimpleFullInputReporter.a(this.a.d, "0X800BDCD", 0, "");
      }
      else
      {
        b(false);
      }
      break;
    case 2131433905: 
      ReportController.b((AppRuntime)localObject, "dc00898", "", "", "0X800AD28", "0X800AD28", x(), 0, "", "", "", "");
      int i1;
      if (o() > 0) {
        i1 = o();
      } else {
        i1 = 21;
      }
      MixedMsgManager.a("0X800AE1A", i1);
      if (e()) {
        b(true);
      }
      localObject = this.t;
      if ((localObject != null) && (((CheckBox)localObject).isChecked())) {
        this.u = true;
      }
      this.a.ax();
      this.u = false;
      SimpleFullInputReporter.a(this.a.d, "0X800BDA3", 0, "");
      break;
    case 2131433904: 
      ReportController.b((AppRuntime)localObject, "dc00898", "", "", "0X8009F27", "0X8009F27", x(), 0, "", "", "", "");
      if (QQTheme.isNowSimpleUI())
      {
        SimpleFullInputReporter.a(this.a.d, "0X800BDCC", u(), "");
        this.o.c();
      }
      else
      {
        b();
      }
      break;
    }
    localObject = (WriteTogetherHelper)this.a.q(74);
    if (localObject != null) {
      ((WriteTogetherHelper)localObject).b(this.a.Y.getText().toString(), 2);
    }
    localObject = (WriteTogetherEssenceMsgHelper)this.a.q(99);
    if (localObject != null)
    {
      CheckBox localCheckBox = this.t;
      if ((localCheckBox != null) && (localCheckBox.isChecked())) {
        ((WriteTogetherEssenceMsgHelper)localObject).a(true);
      } else {
        ((WriteTogetherEssenceMsgHelper)localObject).a(false);
      }
    }
    label498:
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onHideAllPanel() {}
  
  public void onMoveToState(int paramInt)
  {
    if (paramInt == 15)
    {
      A();
      return;
    }
    if (paramInt == 7)
    {
      y();
      return;
    }
    if (paramInt == 11)
    {
      z();
      return;
    }
    if (paramInt == 0)
    {
      f();
      return;
    }
    if (paramInt == 3) {
      h();
    }
  }
  
  public void onPanelChanged(int paramInt1, int paramInt2) {}
  
  public void onPanelIconClickBeforeCreate(int paramInt)
  {
    if ((e()) && ((paramInt == 2) || (paramInt == 10) || (paramInt == 8))) {
      b(false);
    }
  }
  
  public void p()
  {
    this.n.clear();
  }
  
  public void postOnPanelChanged(int paramInt1, int paramInt2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.FullScreenInputHelper
 * JD-Core Version:    0.7.0.1
 */