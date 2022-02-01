package com.tencent.mobileqq.activity.aio.helper;

import android.annotation.SuppressLint;
import android.content.ClipData;
import android.content.ClipData.Item;
import android.content.ClipDescription;
import android.content.ClipboardManager;
import android.content.ClipboardManager.OnPrimaryClipChangedListener;
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
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.text.QQTextBuilder;
import com.tencent.mobileqq.transfile.CommonImgThumbHelper;
import com.tencent.mobileqq.troop.data.TroopAioTips;
import com.tencent.mobileqq.troop.essencemsg.TroopEssenceReportUtil;
import com.tencent.mobileqq.troop.essencemsg.TroopEssenceUtil;
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
  private static volatile boolean jdField_b_of_type_Boolean = true;
  private ClipData jdField_a_of_type_AndroidContentClipData;
  private ClipboardManager.OnPrimaryClipChangedListener jdField_a_of_type_AndroidContentClipboardManager$OnPrimaryClipChangedListener = new FullScreenInputHelper.11(this);
  private Context jdField_a_of_type_AndroidContentContext;
  private Html.ImageGetter jdField_a_of_type_AndroidTextHtml$ImageGetter = new FullScreenInputHelper.1(this);
  private Html.TagHandler jdField_a_of_type_AndroidTextHtml$TagHandler = new FullScreenInputHelper.2(this);
  public View a;
  private ViewTreeObserver.OnGlobalLayoutListener jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener;
  private CheckBox jdField_a_of_type_AndroidWidgetCheckBox;
  public ImageButton a;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private final AIOContext jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext;
  private BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
  private FullScreenInputHelper.TextChangeInfo jdField_a_of_type_ComTencentMobileqqActivityAioHelperFullScreenInputHelper$TextChangeInfo;
  private PatchedButton jdField_a_of_type_ComTencentWidgetPatchedButton;
  private XEditTextEx.TextMenuListener jdField_a_of_type_ComTencentWidgetXEditTextEx$TextMenuListener = new FullScreenInputHelper.10(this);
  private Map<String, Boolean> jdField_a_of_type_JavaUtilMap = new HashMap(40);
  private ClipData jdField_b_of_type_AndroidContentClipData;
  private View jdField_b_of_type_AndroidViewView;
  private ImageButton jdField_b_of_type_AndroidWidgetImageButton;
  private boolean c = false;
  private volatile boolean d = false;
  private boolean e = false;
  
  public FullScreenInputHelper(BaseChatPie paramBaseChatPie, CoreHelperProvider paramCoreHelperProvider)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext = paramBaseChatPie.b();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie = paramBaseChatPie;
    this.jdField_a_of_type_AndroidContentContext = paramBaseChatPie.jdField_a_of_type_AndroidContentContext;
    paramCoreHelperProvider.a(this);
    paramCoreHelperProvider.a(this);
  }
  
  private Editable a(String paramString)
  {
    paramString = (Editable)Html.fromHtml(paramString, this.jdField_a_of_type_AndroidTextHtml$ImageGetter, this.jdField_a_of_type_AndroidTextHtml$TagHandler);
    int i = paramString.length();
    do
    {
      i -= 1;
    } while ((i >= 0) && (paramString.charAt(i) == "\n".charAt(0)));
    return a(paramString.subSequence(0, i + 1));
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
    Map localMap = a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText());
    StringBuilder localStringBuilder = new StringBuilder();
    int j;
    for (int i = 0; i < paramSpanned.length(); i = j + 1)
    {
      char c1 = paramSpanned.charAt(i);
      Object localObject;
      if (c1 == "￼".charAt(0))
      {
        localObject = (String)localMap.get(Integer.valueOf(i + paramInt));
        j = i;
        if (!android.text.TextUtils.isEmpty((CharSequence)localObject))
        {
          localStringBuilder.append(a((String)localObject));
          j = i;
        }
      }
      else if (c1 == '\n')
      {
        localStringBuilder.append(a());
        j = i;
      }
      else if (c1 == '\024')
      {
        int k = i + 1;
        j = i;
        if (k < paramSpanned.length()) {
          if (QQSysFaceUtil.isValidFaceId(paramSpanned.charAt(k)))
          {
            localStringBuilder.append(a(paramSpanned.charAt(k)));
            j = k;
          }
          else
          {
            localObject = new char[4];
            j = i;
            if (i + 4 < paramSpanned.length())
            {
              j = 0;
              while (j < 4)
              {
                i += 1;
                localObject[j] = paramSpanned.charAt(i);
                j += 1;
              }
              localStringBuilder.append(a((char[])localObject));
              j = i;
            }
          }
        }
      }
      else
      {
        localStringBuilder.append(c1);
        j = i;
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
      int j = ((Integer)localField.get(localObject)).intValue();
      int i = 0;
      while (i < j)
      {
        int k = i * 5;
        localObject = paramXMLReader[(k + 1)];
        localField = paramXMLReader[(k + 4)];
        boolean bool = ((String)localObject).equalsIgnoreCase(paramString);
        if (bool) {
          return localField;
        }
        i += 1;
      }
      return null;
    }
    catch (Exception paramXMLReader)
    {
      paramXMLReader.printStackTrace();
    }
  }
  
  private Map<Integer, String> a(Spanned paramSpanned)
  {
    HashMap localHashMap = new HashMap(20);
    int j = paramSpanned.length();
    int i = 0;
    ImageSpan[] arrayOfImageSpan = (ImageSpan[])paramSpanned.getSpans(0, j, ImageSpan.class);
    j = arrayOfImageSpan.length;
    while (i < j)
    {
      Object localObject = arrayOfImageSpan[i];
      int k = paramSpanned.getSpanStart(localObject);
      localObject = ((ImageSpan)localObject).getSource();
      if ((k >= 0) && (!android.text.TextUtils.isEmpty((CharSequence)localObject)))
      {
        if ((!jdField_a_of_type_Boolean) && (localObject == null)) {
          throw new AssertionError();
        }
        localHashMap.put(Integer.valueOf(k), localObject);
      }
      i += 1;
    }
    return localHashMap;
  }
  
  private void a(Intent paramIntent)
  {
    int i;
    if ((paramIntent != null) && (paramIntent.getBooleanExtra("input_full_screen_mode", false))) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
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
  
  private String b(Spanned paramSpanned)
  {
    paramSpanned = a(paramSpanned);
    if (paramSpanned == null) {
      return "";
    }
    return paramSpanned.a();
  }
  
  private void b(View paramView)
  {
    VideoReport.setElementId(paramView, "em_aio_textbox_input_full_screen_button");
    VideoReport.setElementExposePolicy(paramView, ExposurePolicy.REPORT_ALL);
    VideoReport.setElementParam(paramView, "is_full_screen_button_open", Integer.valueOf(0));
  }
  
  private boolean b(int paramInt)
  {
    Editable localEditable = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText();
    if (((ImageSpan[])localEditable.getSpans(0, localEditable.length(), ImageSpan.class)).length + paramInt > 20)
    {
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), 2131694875, 0).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getResources().getDimensionPixelSize(2131299168));
      return true;
    }
    return false;
  }
  
  private int c()
  {
    int j = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int;
    if ((j >= 1000) && (j <= 1038)) {
      return 3;
    }
    int i = 1;
    if (j != 0)
    {
      if (j != 1) {
        return 4;
      }
      i = 2;
    }
    return i;
  }
  
  private void c(boolean paramBoolean)
  {
    g();
    int i;
    if (paramBoolean)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      i = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299293);
    }
    else
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      i = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299294);
    }
    Object localObject = this.jdField_b_of_type_AndroidViewView;
    if (localObject != null)
    {
      localObject = (FrameLayout.LayoutParams)((View)localObject).getLayoutParams();
      if (localObject != null) {
        ((FrameLayout.LayoutParams)localObject).leftMargin = i;
      }
      this.jdField_b_of_type_AndroidViewView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
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
  
  private void d(boolean paramBoolean)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
    if ((localObject != null) && (((BaseChatPie)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1) && (!AnonymousChatHelper.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)))
    {
      if (!TroopEssenceUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(), this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
        return;
      }
      h();
      localObject = this.jdField_b_of_type_AndroidViewView;
      if (localObject == null) {
        return;
      }
      if (paramBoolean)
      {
        ((View)localObject).setVisibility(0);
        localObject = (FrameLayout.LayoutParams)this.jdField_b_of_type_AndroidViewView.getLayoutParams();
        if (localObject != null)
        {
          TextView localTextView = this.jdField_a_of_type_AndroidWidgetTextView;
          if ((localTextView != null) && (localTextView.getVisibility() == 0)) {
            ((FrameLayout.LayoutParams)localObject).leftMargin = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299293);
          } else {
            ((FrameLayout.LayoutParams)localObject).leftMargin = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299294);
          }
          this.jdField_b_of_type_AndroidViewView.setLayoutParams((ViewGroup.LayoutParams)localObject);
          TroopEssenceReportUtil.e(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(), this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
          TroopEssenceReportUtil.f(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(), this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
        }
      }
      else
      {
        ((View)localObject).setVisibility(8);
      }
    }
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
  
  private void e(boolean paramBoolean)
  {
    this.d = paramBoolean;
  }
  
  private void f()
  {
    QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    ReportController.b(localQQAppInterface, "dc00898", "", "", "0X800AD27", "0X800AD27", c(), 0, "", "", "", "");
    boolean bool = true;
    e(true);
    AIOUtils.l = true;
    Object localObject = (AddFriendHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(113);
    if (localObject != null) {
      ((AddFriendHelper)localObject).e();
    }
    ((ISpriteCommFunc)QRoute.api(ISpriteCommFunc.class)).showOrHideSprite(localQQAppInterface, "full_screen_input", true);
    AIOUtils.m = true;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips.k();
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips.g();
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips.d = true;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.b().a();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a().a();
    ((DoutuHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(115)).b();
    ((ReceiptHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a(118)).a(8);
    localObject = (PhotoListHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a(7);
    if (localObject != null) {
      ((PhotoListHelper)localObject).d();
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a();
    int i = ((PanelManager)localObject).a();
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a() != null) && (i != 1) && (i != 3))
    {
      ((PanelManager)localObject).a(true);
      ((PanelManager)localObject).a(1, true);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(8);
    this.jdField_a_of_type_ComTencentWidgetPatchedButton.setVisibility(0);
    this.jdField_a_of_type_ComTencentWidgetPatchedButton.setEnabled(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.p());
    this.jdField_a_of_type_AndroidViewView.getLayoutParams().height = -1;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getLayoutParams().height = -1;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getLayoutParams().width = -1;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.setMaxLines(100);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.setGravity(48);
    this.jdField_b_of_type_AndroidWidgetImageButton.setVisibility(0);
    if ((b() == 0) && (f())) {
      c(true);
    } else {
      c(false);
    }
    localObject = ((ReplyHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(119)).a();
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie == null) || (localObject != null)) {
      bool = false;
    }
    d(bool);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.setPadding(0, 0, 0, 0);
    ((FrameLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getLayoutParams()).setMargins(0, 0, 0, 0);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.setPadding(AIOUtils.b(24.0F, localQQAppInterface.getApplication().getResources()), AIOUtils.b(10.0F, localQQAppInterface.getApplication().getResources()), AIOUtils.b(24.0F, localQQAppInterface.getApplication().getResources()), AIOUtils.b(40.0F, localQQAppInterface.getApplication().getResources()));
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.getLayoutParams().height = -1;
    ((AIOInputRightHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(117)).b();
    o();
  }
  
  private void f(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentWidgetPatchedButton.setEnabled(paramBoolean);
  }
  
  private boolean f()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (localObject != null)
    {
      bool1 = bool2;
      if (((IWriteTogetherConfig)QRoute.api(IWriteTogetherConfig.class)).isAllowShowEntrance(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))
      {
        localObject = (WriteTogetherHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(74);
        bool1 = bool2;
        if (localObject != null)
        {
          bool1 = bool2;
          if (((WriteTogetherHelper)localObject).a()) {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  @SuppressLint({"RtlHardcoded"})
  private void g()
  {
    if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
      return;
    }
    this.jdField_a_of_type_AndroidWidgetTextView = new TextView(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_AndroidWidgetTextView.setId(2131364108);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_AndroidContentContext.getResources().getText(2131720451));
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131167119));
    this.jdField_a_of_type_AndroidWidgetTextView.setBackgroundResource(2130850347);
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-2, -2);
    localLayoutParams.leftMargin = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299294);
    localLayoutParams.rightMargin = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299297);
    localLayoutParams.bottomMargin = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299292);
    localLayoutParams.gravity = 83;
    this.jdField_a_of_type_AndroidWidgetTextView.setLayoutParams(localLayoutParams);
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    if (AppSetting.d) {
      this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(HardCodeUtil.a(2131689522));
    }
    ((FrameLayout)this.jdField_a_of_type_AndroidViewView).addView(this.jdField_a_of_type_AndroidWidgetTextView);
  }
  
  private boolean g()
  {
    AIOContext localAIOContext = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext;
    return (!(localAIOContext instanceof PAContext)) && (!(localAIOContext instanceof RobotContext));
  }
  
  private void h()
  {
    if (this.jdField_b_of_type_AndroidViewView != null) {
      return;
    }
    this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a().getLayoutInflater().inflate(2131558806, null);
    this.jdField_b_of_type_AndroidViewView.setBackgroundResource(2130850347);
    Object localObject = new FrameLayout.LayoutParams(-2, -2);
    ((FrameLayout.LayoutParams)localObject).leftMargin = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299293);
    ((FrameLayout.LayoutParams)localObject).bottomMargin = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299292);
    ((FrameLayout.LayoutParams)localObject).gravity = 80;
    this.jdField_b_of_type_AndroidViewView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.jdField_a_of_type_AndroidWidgetCheckBox = ((CheckBox)this.jdField_b_of_type_AndroidViewView.findViewById(2131378162));
    this.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(false);
    this.jdField_a_of_type_AndroidWidgetCheckBox.setOnClickListener(this);
    localObject = (TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131378163);
    ((TextView)localObject).setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131167119));
    ((TextView)localObject).setOnClickListener(this);
    ((FrameLayout)this.jdField_a_of_type_AndroidViewView).addView(this.jdField_b_of_type_AndroidViewView);
  }
  
  private void i()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a().post(new FullScreenInputHelper.7(this));
  }
  
  private void j()
  {
    
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.setOnDragListener(new FullScreenInputHelper.8(this));
    }
  }
  
  private void k()
  {
    n();
    LinkMovementMethodExt.a();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.setOnDragListener(null);
    }
  }
  
  private void l()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx != null)
    {
      if (this.jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getViewTreeObserver().removeGlobalOnLayoutListener(this.jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener);
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.setFilters(new InputFilter[0]);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.setOnWindowFocusChangedListener(null);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.b(this.jdField_a_of_type_ComTencentWidgetXEditTextEx$TextMenuListener);
      if (Build.VERSION.SDK_INT >= 23) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.setCustomInsertionActionModeCallback(null);
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.setCustomSelectionActionModeCallback(null);
    }
    LinkMovementMethodExt.a(null);
    LinkMovementMethodExt.a(null);
    b(false);
  }
  
  private void m()
  {
    Object localObject = a();
    ClipboardMonitor.getPrimaryClipDescription((ClipboardManager)localObject);
    localObject = ((ClipboardManager)localObject).getPrimaryClipDescription();
    boolean bool;
    if ((localObject != null) && (((ClipDescription)localObject).getLabel() != null) && ("FullScreenInputHelper".equalsIgnoreCase(((ClipDescription)localObject).getLabel().toString()))) {
      bool = true;
    } else {
      bool = false;
    }
    this.e = bool;
    if ((this.e) && (this.jdField_a_of_type_AndroidContentClipData != null))
    {
      localObject = (ClipboardManager)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getSystemService("clipboard");
      ClipboardMonitor.getPrimaryClip((ClipboardManager)localObject);
      ClipData localClipData = ((ClipboardManager)localObject).getPrimaryClip();
      if (localClipData == null)
      {
        localClipData = this.jdField_a_of_type_AndroidContentClipData;
        ClipboardMonitor.setPrimaryClip((ClipboardManager)localObject, localClipData);
        ((ClipboardManager)localObject).setPrimaryClip(localClipData);
        return;
      }
      if ((this.jdField_b_of_type_AndroidContentClipData != null) && (localClipData.getItemAt(0).getText() != null) && (this.jdField_b_of_type_AndroidContentClipData.getItemAt(0).getText() != null) && (localClipData.getItemAt(0).getText().toString().equals(this.jdField_b_of_type_AndroidContentClipData.getItemAt(0).getText().toString())))
      {
        localClipData = this.jdField_a_of_type_AndroidContentClipData;
        ClipboardMonitor.setPrimaryClip((ClipboardManager)localObject, localClipData);
        ((ClipboardManager)localObject).setPrimaryClip(localClipData);
      }
    }
  }
  
  private void n()
  {
    if ((this.e) && (this.jdField_b_of_type_AndroidContentClipData != null))
    {
      ClipboardManager localClipboardManager = (ClipboardManager)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getSystemService("clipboard");
      ClipData localClipData = this.jdField_b_of_type_AndroidContentClipData;
      ClipboardMonitor.setPrimaryClip(localClipboardManager, localClipData);
      localClipboardManager.setPrimaryClip(localClipData);
    }
  }
  
  private void o()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a().a() == 3)
    {
      AIOEmoticonPanelHelper localAIOEmoticonPanelHelper = (AIOEmoticonPanelHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a(104);
      if (localAIOEmoticonPanelHelper != null) {
        localAIOEmoticonPanelHelper.doOnEmoticonPanelFullScreen();
      }
    }
  }
  
  public int a()
  {
    return 0;
  }
  
  ClipboardManager a()
  {
    return (ClipboardManager)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getSystemService("clipboard");
  }
  
  Drawable a(Context paramContext, String paramString)
  {
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    BitmapFactory.decodeFile(paramString, localOptions);
    Object localObject = CommonImgThumbHelper.getThumbWidthHeightDP(false);
    int k = ((ThumbWidthHeightDP)localObject).mMinWidth;
    int m = ((ThumbWidthHeightDP)localObject).mMinHeight;
    int n = ((ThumbWidthHeightDP)localObject).mMaxWidth;
    int i1 = ((ThumbWidthHeightDP)localObject).mMaxHeight;
    int j = localOptions.outWidth;
    int i = localOptions.outHeight;
    if ((j > 0) && (i > 0))
    {
      if ((j >= k) && (i >= m))
      {
        if ((j >= n) || (i >= i1))
        {
          float f2;
          if (j > i)
          {
            f1 = n;
            f2 = j;
          }
          else
          {
            f1 = i1;
            f2 = i;
          }
          float f3 = f1 / f2;
          if (j > i)
          {
            f1 = m;
            f2 = i;
          }
          else
          {
            f1 = k;
            f2 = j;
          }
          f1 = Math.max(f3, f1 / f2);
          k = (int)(j * f1 + 0.5F);
          m = (int)(i * f1 + 0.5F);
          j = k;
          i = m;
          if (QLog.isColorLevel())
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("scale2:");
            ((StringBuilder)localObject).append(f1);
            QLog.d("FullScreenInputHelper", 2, ((StringBuilder)localObject).toString());
            j = k;
            i = m;
          }
        }
      }
      else
      {
        if (j < i)
        {
          f1 = k / j;
          m = Math.min((int)(i * f1 + 0.5F), i1);
        }
        else
        {
          f1 = m / i;
          k = Math.min((int)(j * f1 + 0.5F), n);
        }
        j = k;
        i = m;
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("scale1:");
          ((StringBuilder)localObject).append(f1);
          QLog.d("FullScreenInputHelper", 2, ((StringBuilder)localObject).toString());
          j = k;
          i = m;
        }
      }
    }
    else
    {
      j = 99;
      i = 99;
    }
    float f1 = paramContext.getResources().getDisplayMetrics().densityDpi / 160.0F;
    j = (int)(j * f1 + 0.5F);
    i = (int)(i * f1 + 0.5F);
    localOptions.inSampleSize = Utils.calculateInSampleSize(localOptions, j, i);
    localOptions.inJustDecodeBounds = false;
    paramString = ThumbnailUtils.extractThumbnail(((IOCR)QRoute.api(IOCR.class)).safeDecode(paramString, localOptions, 1, 4), j, i, 2);
    paramContext = new BitmapDrawable(paramContext.getResources(), paramString);
    paramContext.setBounds(0, 0, j, i);
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder();
      paramString.append("thumb drawable setBounds, w:");
      paramString.append(j);
      paramString.append(", h:");
      paramString.append(i);
      QLog.d("FullScreenInputHelper", 2, paramString.toString());
    }
    return paramContext;
  }
  
  Editable a(CharSequence paramCharSequence)
  {
    return QQTextBuilder.EMOTION_INPUT_FACTORY.newEditable(paramCharSequence);
  }
  
  public MixedMsgInfo a()
  {
    return a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText());
  }
  
  public MixedMsgInfo a(Spanned paramSpanned)
  {
    if (paramSpanned.length() <= 0) {
      return null;
    }
    MixedMsgInfo localMixedMsgInfo = new MixedMsgInfo();
    Object localObject1 = (ImageSpan[])paramSpanned.getSpans(0, paramSpanned.length(), ImageSpan.class);
    SparseArray localSparseArray = new SparseArray();
    int j = localObject1.length;
    int i = 0;
    Object localObject2;
    while (i < j)
    {
      localObject2 = localObject1[i];
      localSparseArray.append(paramSpanned.getSpanStart(localObject2), localObject2);
      i += 1;
    }
    i = 0;
    int k;
    for (j = 0; i < localSparseArray.size(); j = k)
    {
      localObject2 = (ImageSpan)localSparseArray.valueAt(i);
      int m = paramSpanned.getSpanStart(localObject2);
      k = paramSpanned.getSpanEnd(localObject2);
      String str = paramSpanned.subSequence(j, m).toString();
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("[mix]getMixedText ImageSpan: ");
        ((StringBuilder)localObject1).append(((ImageSpan)localObject2).getSource());
        ((StringBuilder)localObject1).append(" {start: ");
        ((StringBuilder)localObject1).append(m);
        ((StringBuilder)localObject1).append(" end: ");
        ((StringBuilder)localObject1).append(k);
        ((StringBuilder)localObject1).append(" all: ");
        ((StringBuilder)localObject1).append(paramSpanned.length());
        ((StringBuilder)localObject1).append("} prefix: ");
        ((StringBuilder)localObject1).append(str);
        QLog.d("FullScreenInputHelper", 2, ((StringBuilder)localObject1).toString());
      }
      if (i == 0) {
        localObject1 = MixedMsgInfo.TextLocation.HEADER;
      } else {
        localObject1 = MixedMsgInfo.TextLocation.INLINE;
      }
      localMixedMsgInfo.a(a(str, (MixedMsgInfo.TextLocation)localObject1));
      localObject1 = ((ImageSpan)localObject2).getSource();
      localObject2 = (Boolean)this.jdField_a_of_type_JavaUtilMap.get(localObject1);
      boolean bool;
      if (localObject2 != null) {
        bool = ((Boolean)localObject2).booleanValue();
      } else {
        bool = false;
      }
      localMixedMsgInfo.a(new MixedMsgInfo.PhotoMsgNode(new MixedMsgInfo.PhotoItem((String)localObject1, bool)));
      i += 1;
    }
    localMixedMsgInfo.a(a(paramSpanned.subSequence(j, paramSpanned.length()).toString(), MixedMsgInfo.TextLocation.TAILOR));
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("[mix]mixedMsgInfo size:");
      ((StringBuilder)localObject1).append(localMixedMsgInfo.a().size());
      ((StringBuilder)localObject1).append(" [start: ");
      ((StringBuilder)localObject1).append(j);
      ((StringBuilder)localObject1).append(" end: ");
      ((StringBuilder)localObject1).append(paramSpanned.length());
      QLog.d("FullScreenInputHelper", 2, ((StringBuilder)localObject1).toString());
    }
    return localMixedMsgInfo;
  }
  
  public CharSequence a(AIOContext paramAIOContext, Intent paramIntent, MessageRecord paramMessageRecord, Message paramMessage)
  {
    return null;
  }
  
  public CharSequence a(AIOContext paramAIOContext, MessageRecord paramMessageRecord, Message paramMessage)
  {
    return null;
  }
  
  String a()
  {
    return "<newLine>";
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
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText();
    }
    return a((Spanned)localObject, 0);
  }
  
  public String a(CharSequence paramCharSequence)
  {
    Object localObject = paramCharSequence;
    if (paramCharSequence == null) {
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText();
    }
    if (localObject == null) {
      return null;
    }
    return ((CharSequence)localObject).toString().replaceAll("￼", "[图片]");
  }
  
  String a(String paramString)
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
  
  String a(char[] paramArrayOfChar)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("<");
    localStringBuilder.append("littleEmotion");
    int i = 0;
    while (i < 4)
    {
      localStringBuilder.append(" index");
      localStringBuilder.append(i);
      localStringBuilder.append("=\"");
      localStringBuilder.append(paramArrayOfChar[i]);
      localStringBuilder.append("\"");
      i += 1;
    }
    localStringBuilder.append(">");
    return localStringBuilder.toString();
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a(2131367405);
    this.jdField_a_of_type_AndroidWidgetImageButton = ((ImageButton)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a(2131367403));
    this.jdField_b_of_type_AndroidWidgetImageButton = ((ImageButton)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a(2131368177));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a(2131367418));
    this.jdField_a_of_type_ComTencentWidgetPatchedButton = ((PatchedButton)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a(2131367404));
    a(this.jdField_a_of_type_AndroidWidgetImageButton);
    this.jdField_a_of_type_AndroidWidgetImageButton.setOnClickListener(this);
    b(this.jdField_b_of_type_AndroidWidgetImageButton);
    this.jdField_b_of_type_AndroidWidgetImageButton.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentWidgetPatchedButton.setOnClickListener(this);
    if (AppSetting.d)
    {
      this.jdField_a_of_type_AndroidWidgetImageButton.setContentDescription(HardCodeUtil.a(2131705063));
      this.jdField_b_of_type_AndroidWidgetImageButton.setContentDescription(HardCodeUtil.a(2131705060));
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.setFilters(new InputFilter[] { new FullScreenInputHelper.4(this) });
    Object localObject = new FullScreenInputHelper.5(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.setCustomSelectionActionModeCallback((ActionMode.Callback)localObject);
    if (Build.VERSION.SDK_INT >= 23) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.setCustomInsertionActionModeCallback((ActionMode.Callback)localObject);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.a(this.jdField_a_of_type_ComTencentWidgetXEditTextEx$TextMenuListener);
    jdField_b_of_type_Boolean = true;
    localObject = new int[2];
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getLocationOnScreen((int[])localObject);
    localObject = LinkMovementMethodExt.a(localObject[0], ImageSpan.class);
    LinkMovementMethodExt.a(this);
    LinkMovementMethodExt.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.setMovementMethod((MovementMethod)localObject);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.setOnKeyboardShowListener((XEditTextEx.OnKeyboardShowListener)localObject);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.setOnWindowFocusChangedListener(new FullScreenInputHelper.6(this));
  }
  
  public void a(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    if (jdField_b_of_type_Boolean) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioHelperFullScreenInputHelper$TextChangeInfo = new FullScreenInputHelper.TextChangeInfo(paramCharSequence, paramInt1, paramInt2, paramInt3);
    }
  }
  
  public void a(String paramString)
  {
    paramString = a(paramString);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.setText(paramString);
  }
  
  public void a(List<String> paramList, boolean paramBoolean)
  {
    if (b(paramList.size())) {
      return;
    }
    Editable localEditable1 = a("");
    Editable localEditable2 = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText();
    int i = Selection.getSelectionStart(localEditable2);
    if ((i > 0) && (!localEditable2.subSequence(0, i).toString().endsWith("\n"))) {
      localEditable1.append("\n");
    }
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      localEditable1.append(a(a(str))).append("\n");
      this.jdField_a_of_type_JavaUtilMap.put(str, Boolean.valueOf(paramBoolean));
    }
    if (localEditable2.subSequence(i, localEditable2.length()).toString().startsWith("\n")) {
      localEditable1.delete(localEditable1.length() - 1, localEditable1.length());
    }
    jdField_b_of_type_Boolean = false;
    localEditable2.insert(i, localEditable1);
    i = Selection.getSelectionStart(localEditable2);
    if (localEditable2.charAt(i - 1) == "￼".charAt(0)) {
      Selection.setSelection(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText(), i + 1);
    }
    jdField_b_of_type_Boolean = true;
    MixedMsgManager.a("0X800AE19", paramList.size());
  }
  
  public void a(boolean paramBoolean)
  {
    if (!c()) {
      return;
    }
    QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    e(false);
    AIOUtils.l = false;
    Object localObject;
    if (!paramBoolean)
    {
      localObject = (AddFriendHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(113);
      if (localObject != null) {
        ((AddFriendHelper)localObject).e();
      }
      if (a()) {
        ((ISpriteCommFunc)QRoute.api(ISpriteCommFunc.class)).showOrHideSprite(localQQAppInterface, "full_screen_input", false);
      }
    }
    AIOUtils.m = false;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips.d = false;
    }
    ((IDoutuService)localQQAppInterface.getRuntimeService(IDoutuService.class, "")).setComboShowSwitch(true);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.l(this.jdField_a_of_type_ComTencentWidgetPatchedButton.isEnabled());
    this.jdField_a_of_type_ComTencentWidgetPatchedButton.setVisibility(8);
    this.jdField_b_of_type_AndroidWidgetImageButton.setVisibility(8);
    c(false);
    d(false);
    if (!paramBoolean)
    {
      localObject = (ReceiptHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a(118);
      if (((ReceiptHelper)localObject).jdField_a_of_type_Boolean) {
        ((ReceiptHelper)localObject).a(0);
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie instanceof TroopChatPie)) {
        ((HWTroopClassInfoTipsHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a(73)).b();
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.getLayoutParams().height = -2;
    this.jdField_a_of_type_AndroidViewView.getLayoutParams().height = -2;
    if (paramBoolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.setPadding(0, AIOUtils.b(8.0F, localQQAppInterface.getApplication().getResources()), 0, 0);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getLayoutParams().height = -2;
      ((FrameLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getLayoutParams()).setMargins(AIOUtils.b(14.0F, localQQAppInterface.getApplication().getResources()), 0, 0, 0);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.setMaxLines(6);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.setGravity(16);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.setPadding(AIOUtils.b(11.0F, localQQAppInterface.getApplication().getResources()), AIOUtils.b(6.0F, localQQAppInterface.getApplication().getResources()), AIOUtils.b(11.0F, localQQAppInterface.getApplication().getResources()), AIOUtils.b(6.0F, localQQAppInterface.getApplication().getResources()));
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.setPadding(0, AIOUtils.b(8.0F, localQQAppInterface.getApplication().getResources()), 0, 0);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getLayoutParams().height = -2;
    ((FrameLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getLayoutParams()).setMargins(AIOUtils.b(14.0F, localQQAppInterface.getApplication().getResources()), 0, 0, 0);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.setMaxLines(6);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.setGravity(16);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.setPadding(AIOUtils.b(11.0F, localQQAppInterface.getApplication().getResources()), AIOUtils.b(6.0F, localQQAppInterface.getApplication().getResources()), AIOUtils.b(11.0F, localQQAppInterface.getApplication().getResources()), AIOUtils.b(6.0F, localQQAppInterface.getApplication().getResources()));
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.requestLayout();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a().postDelayed(new FullScreenInputHelper.3(this), 100L);
    c();
    o();
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.b().a().a().a().a() != 2;
  }
  
  public boolean a(int paramInt)
  {
    return false;
  }
  
  public boolean a(Editable paramEditable)
  {
    if ((c()) && (f()))
    {
      boolean bool;
      if (b() == 0) {
        bool = true;
      } else {
        bool = false;
      }
      c(bool);
      MessageForReplyText.SourceMsgInfo localSourceMsgInfo = ((ReplyHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(119)).a();
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie != null) && (localSourceMsgInfo == null)) {
        bool = true;
      } else {
        bool = false;
      }
      d(bool);
    }
    if (jdField_b_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioHelperFullScreenInputHelper$TextChangeInfo.a(paramEditable);
      try
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioHelperFullScreenInputHelper$TextChangeInfo.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx);
      }
      catch (Throwable localThrowable)
      {
        localThrowable.printStackTrace();
      }
    }
    if (this.d)
    {
      if (paramEditable.length() > 0)
      {
        f(true);
        return true;
      }
      f(false);
      return true;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getLineCount() > 3) && (g()) && (a()) && (!SimpleUIUtil.a())) {
      this.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(0);
    } else {
      this.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(8);
    }
    if (paramEditable.length() == 0) {
      b(false);
    }
    return false;
  }
  
  public boolean a(AIOContext paramAIOContext, MessageRecord paramMessageRecord, Message paramMessage)
  {
    return c();
  }
  
  public boolean a(boolean paramBoolean)
  {
    return c();
  }
  
  public int b()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText();
    if ((localObject != null) && (((Spanned)localObject).length() > 0))
    {
      localObject = (ImageSpan[])((Spanned)localObject).getSpans(0, ((Spanned)localObject).length(), ImageSpan.class);
      if (localObject != null) {
        return localObject.length;
      }
    }
    return 0;
  }
  
  public void b()
  {
    this.jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener = new FullScreenInputHelper.9(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getViewTreeObserver().addOnGlobalLayoutListener(this.jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener);
  }
  
  public void b(boolean paramBoolean)
  {
    CheckBox localCheckBox = this.jdField_a_of_type_AndroidWidgetCheckBox;
    if (localCheckBox != null) {
      localCheckBox.setChecked(paramBoolean);
    }
  }
  
  public boolean b()
  {
    return this.c;
  }
  
  boolean b(boolean paramBoolean)
  {
    Object localObject1 = a();
    int i = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getSelectionStart();
    int j = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getSelectionEnd();
    Object localObject2 = (Spanned)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().subSequence(i, j);
    String str = a((Spanned)localObject2, i);
    localObject2 = b((Spanned)localObject2);
    if (android.text.TextUtils.isEmpty((CharSequence)localObject2)) {
      return false;
    }
    if (QLog.isColorLevel())
    {
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("[mix]ClipBoard CopyOrCut startIndex: ");
      ((StringBuilder)localObject3).append(i);
      ((StringBuilder)localObject3).append(" endIndex: ");
      ((StringBuilder)localObject3).append(j);
      QLog.d("FullScreenInputHelper", 2, ((StringBuilder)localObject3).toString());
    }
    Object localObject3 = ClipData.newPlainText("FullScreenInputHelper", (CharSequence)localObject2);
    Intent localIntent = new Intent();
    localIntent.putExtra("FullScreenInputHelper", str);
    ((ClipData)localObject3).addItem(new ClipData.Item(localIntent));
    ClipboardMonitor.setPrimaryClip((ClipboardManager)localObject1, (ClipData)localObject3);
    ((ClipboardManager)localObject1).setPrimaryClip((ClipData)localObject3);
    this.jdField_a_of_type_AndroidContentClipData = ((ClipData)localObject3);
    this.jdField_b_of_type_AndroidContentClipData = ClipData.newPlainText("FullScreenInputHelper", (CharSequence)localObject2);
    if (paramBoolean)
    {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText();
      ((Editable)localObject1).delete(i, j);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.setText((CharSequence)localObject1);
    }
    else
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.setSelection(j);
    }
    return true;
  }
  
  public void c()
  {
    float f = Math.abs(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getPaint().getFontMetrics().bottom - this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getPaint().getFontMetrics().top);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.setMaxHeight(Math.round(f * 6.0F));
  }
  
  public boolean c()
  {
    return this.d;
  }
  
  public void d()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.ak();
    this.jdField_a_of_type_JavaUtilMap.clear();
  }
  
  public void d(int paramInt) {}
  
  public boolean d()
  {
    return android.text.TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText());
  }
  
  public void e()
  {
    this.jdField_a_of_type_JavaUtilMap.clear();
  }
  
  boolean e()
  {
    Object localObject = a();
    ClipboardMonitor.getPrimaryClip((ClipboardManager)localObject);
    localObject = ((ClipboardManager)localObject).getPrimaryClip();
    if ((localObject != null) && (((ClipData)localObject).getItemCount() == 2) && (((ClipData)localObject).getItemAt(1).getIntent() != null))
    {
      localObject = ((ClipData)localObject).getItemAt(1).getIntent().getStringExtra("FullScreenInputHelper");
      Editable localEditable1 = a((String)localObject);
      if (b(((ImageSpan[])localEditable1.getSpans(0, localEditable1.length(), ImageSpan.class)).length)) {
        return true;
      }
      Editable localEditable2 = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText();
      localEditable2 = localEditable2.replace(Selection.getSelectionStart(localEditable2), Selection.getSelectionEnd(localEditable2), localEditable1, 0, localEditable1.length());
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("[mix] ClipBoard paste html: ");
        localStringBuilder.append((String)localObject);
        localStringBuilder.append(" text: ");
        localStringBuilder.append(localEditable1);
        localStringBuilder.append(" result: ");
        localStringBuilder.append(localEditable2);
        QLog.d("FullScreenInputHelper", 2, localStringBuilder.toString());
      }
      return true;
    }
    return false;
  }
  
  public String getTag()
  {
    return "FullScreenInputHelper";
  }
  
  public int[] interestedIn()
  {
    return new int[] { 0, 3, 7, 15, 11 };
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
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    switch (paramView.getId())
    {
    default: 
      break;
    case 2131378163: 
      localObject = this.jdField_a_of_type_AndroidWidgetCheckBox;
      if (localObject != null) {
        ((CheckBox)localObject).setChecked(((CheckBox)localObject).isChecked() ^ true);
      }
    case 2131378162: 
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
      if ((localObject == null) || (((BaseChatPie)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null)) {
        break label433;
      }
      TroopEssenceReportUtil.g(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(), this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      TroopEssenceReportUtil.h(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(), this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      break;
    case 2131368177: 
      ReportController.b((AppRuntime)localObject, "dc00898", "", "", "0X8009F36", "0X8009F36", c(), 0, "", "", "", "");
      a(false);
      break;
    case 2131367404: 
      ReportController.b((AppRuntime)localObject, "dc00898", "", "", "0X800AD28", "0X800AD28", c(), 0, "", "", "", "");
      int i;
      if (b() > 0) {
        i = b();
      } else {
        i = 21;
      }
      MixedMsgManager.a("0X800AE1A", i);
      if (c()) {
        a(true);
      }
      localObject = this.jdField_a_of_type_AndroidWidgetCheckBox;
      if ((localObject != null) && (((CheckBox)localObject).isChecked())) {
        this.c = true;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.R();
      this.c = false;
      break;
    case 2131367403: 
      ReportController.b((AppRuntime)localObject, "dc00898", "", "", "0X8009F27", "0X8009F27", c(), 0, "", "", "", "");
      f();
      break;
    }
    localObject = (WriteTogetherHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(74);
    if (localObject != null) {
      ((WriteTogetherHelper)localObject).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().toString(), 2);
    }
    localObject = (WriteTogetherEssenceMsgHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(99);
    if (localObject != null)
    {
      CheckBox localCheckBox = this.jdField_a_of_type_AndroidWidgetCheckBox;
      if ((localCheckBox != null) && (localCheckBox.isChecked())) {
        ((WriteTogetherEssenceMsgHelper)localObject).a(true);
      } else {
        ((WriteTogetherEssenceMsgHelper)localObject).a(false);
      }
    }
    label433:
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onHideAllPanel() {}
  
  public void onMoveToState(int paramInt)
  {
    if (paramInt == 15)
    {
      l();
      return;
    }
    if (paramInt == 7)
    {
      j();
      return;
    }
    if (paramInt == 11)
    {
      k();
      return;
    }
    if (paramInt == 0)
    {
      a();
      return;
    }
    if (paramInt == 3) {
      c();
    }
  }
  
  public void onPanelChanged(int paramInt1, int paramInt2) {}
  
  public void onPanelIconClickBeforeCreate(int paramInt)
  {
    if ((c()) && ((paramInt == 2) || (paramInt == 10) || (paramInt == 8))) {
      a(false);
    }
  }
  
  public void postOnPanelChanged(int paramInt1, int paramInt2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.FullScreenInputHelper
 * JD-Core Version:    0.7.0.1
 */