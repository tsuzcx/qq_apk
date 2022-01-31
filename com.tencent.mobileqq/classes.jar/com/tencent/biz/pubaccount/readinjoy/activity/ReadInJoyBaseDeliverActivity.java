package com.tencent.biz.pubaccount.readinjoy.activity;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Matrix;
import android.media.ExifInterface;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Looper;
import android.text.Editable;
import android.text.Editable.Factory;
import android.text.TextWatcher;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.Window;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.pubaccount.PublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.biu.AtFriendsSpan;
import com.tencent.biz.pubaccount.readinjoy.biu.BiuNicknameSpan;
import com.tencent.biz.pubaccount.readinjoy.biu.BiuTextBuilder;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyConstants;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.model.ReadInJoyUserInfoModule;
import com.tencent.biz.pubaccount.readinjoy.struct.ReadInJoyUserInfo;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.mobileqq.activity.selectmember.ResultRecord;
import com.tencent.mobileqq.activity.selectmember.SelectMemberActivity;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.emoticonview.EmoticonCallback;
import com.tencent.mobileqq.emoticonview.EmoticonInfo;
import com.tencent.mobileqq.emoticonview.EmoticonMainPanel;
import com.tencent.mobileqq.emoticonview.SmallEmoticonInfo;
import com.tencent.mobileqq.emoticonview.SystemAndEmojiEmoticonInfo;
import com.tencent.mobileqq.emoticonview.SystemEmoticonInfo;
import com.tencent.mobileqq.hotpic.PublicAccountGifListener;
import com.tencent.mobileqq.hotpic.PublicAccountHotPicPanel;
import com.tencent.mobileqq.model.QueryTask;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.mobileqq.service.message.MessageUtils;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.util.SystemUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import com.tencent.widget.XPanelContainer;
import com.tencent.widget.XPanelContainer.PanelCallback;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;
import cooperation.readinjoy.ReadInJoyHelper;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import lbq;
import lbr;
import lbt;
import lbu;
import lbv;
import lbw;
import lbx;
import lby;
import lbz;
import lca;
import lcb;
import lcc;
import lcd;
import lce;
import lcf;
import lcg;
import lch;
import mqq.os.MqqHandler;
import org.json.JSONException;
import org.json.JSONObject;

public class ReadInJoyBaseDeliverActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener
{
  protected static int g;
  public int a;
  protected Dialog a;
  private Editable.Factory jdField_a_of_type_AndroidTextEditable$Factory = new lca(this);
  public TextWatcher a;
  public ViewTreeObserver.OnGlobalLayoutListener a;
  public EditText a;
  public ImageView a;
  public TextView a;
  private EmoticonCallback jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonCallback = new lcc(this);
  private EmoticonMainPanel jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel;
  private PublicAccountGifListener jdField_a_of_type_ComTencentMobileqqHotpicPublicAccountGifListener = new lcf(this);
  private PublicAccountHotPicPanel jdField_a_of_type_ComTencentMobileqqHotpicPublicAccountHotPicPanel;
  protected INetInfoHandler a;
  protected QQProgressDialog a;
  public ActionSheet a;
  private XPanelContainer.PanelCallback jdField_a_of_type_ComTencentWidgetXPanelContainer$PanelCallback = new lcb(this);
  public XPanelContainer a;
  public String a;
  public boolean a;
  public int b;
  public ImageView b;
  public String b;
  public boolean b;
  public int c;
  private ImageView c;
  public boolean c;
  public int d;
  public boolean d;
  public int e;
  public boolean e;
  public int f;
  protected boolean f = true;
  public boolean g;
  public int h;
  protected boolean h;
  private int i;
  public boolean i;
  public boolean j;
  public boolean k;
  public boolean l;
  public boolean m;
  private boolean n = true;
  
  static
  {
    jdField_g_of_type_Int = 8;
  }
  
  public ReadInJoyBaseDeliverActivity()
  {
    this.jdField_a_of_type_Int = 1;
    this.jdField_b_of_type_Int = 1;
    this.jdField_c_of_type_Int = ReadInJoyConstants.jdField_a_of_type_Int;
    this.jdField_d_of_type_Int = 0;
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_g_of_type_Boolean = true;
    this.jdField_h_of_type_Boolean = true;
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_a_of_type_AndroidTextTextWatcher = new lcg(this);
    this.jdField_h_of_type_Int = -1;
  }
  
  public static String a()
  {
    try
    {
      Object localObject = new JSONObject();
      ((JSONObject)localObject).put("folder_status", ReadInJoyUtils.jdField_d_of_type_Int);
      localObject = ((JSONObject)localObject).toString();
      return localObject;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return "";
  }
  
  public static String a(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyBaseDeliverActivity", 2, "beforeXml:" + paramString1);
    }
    if (android.text.TextUtils.isEmpty(paramString1)) {}
    do
    {
      return paramString1;
      if (Character.codePointCount(paramString1, 0, paramString1.length()) != paramString1.length()) {
        break;
      }
    } while (!paramString1.contains(new String(new char[] { '\024' })));
    StringBuilder localStringBuilder1 = new StringBuilder("[emoji:0x%05x");
    StringBuilder localStringBuilder2 = new StringBuilder("[sysEmo:%03d");
    if (!android.text.TextUtils.isEmpty(paramString2))
    {
      localStringBuilder1.append(paramString2);
      localStringBuilder2.append(paramString2);
    }
    localStringBuilder1.append(']');
    localStringBuilder2.append(']');
    paramString2 = null;
    if (QLog.isColorLevel()) {
      paramString2 = new StringBuilder(1024).append("beforeXml start");
    }
    int i4 = paramString1.length();
    int i3 = 0;
    String str1 = paramString1;
    if (i3 < i4)
    {
      int i5 = str1.codePointAt(i3);
      String str2;
      int i1;
      int i2;
      if (i5 > 65535)
      {
        str2 = str1.substring(i3, i3 + 2);
        paramString1 = String.format(localStringBuilder1.toString(), new Object[] { Integer.valueOf(i5) });
        str1 = str1.replace(str2, paramString1);
        i3 += paramString1.length() - 1;
        i4 = str1.length();
        i1 = i3;
        i2 = i4;
        paramString1 = str1;
        if (QLog.isColorLevel())
        {
          paramString2.append("\n").append("unicode").append(":").append(i5);
          paramString1 = str1;
          i2 = i4;
          i1 = i3;
        }
      }
      for (;;)
      {
        i3 = i1 + 1;
        i4 = i2;
        str1 = paramString1;
        break;
        i1 = i3;
        i2 = i4;
        paramString1 = str1;
        if (i5 == 20)
        {
          i1 = i3;
          i2 = i4;
          paramString1 = str1;
          if (i3 + 1 < i4)
          {
            i1 = str1.charAt(i3 + 1);
            paramString1 = str1.substring(i3, i3 + 2);
            str2 = String.format(localStringBuilder2.toString(), new Object[] { Integer.valueOf(i1) });
            paramString1 = str1.replace(paramString1, str2);
            i1 = i3 + (str2.length() - 1);
            i2 = paramString1.length();
          }
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyBaseDeliverActivity", 2, paramString2.toString());
    }
    return str1;
  }
  
  public static void a(EmoticonInfo paramEmoticonInfo, EditText paramEditText)
  {
    int i1;
    int i2;
    if ((paramEmoticonInfo instanceof SystemEmoticonInfo))
    {
      i1 = paramEditText.getSelectionStart();
      i2 = paramEditText.getSelectionEnd();
      if ((i1 < 0) || (i2 < 0) || (i2 < i1)) {}
    }
    do
    {
      int i3;
      int i4;
      do
      {
        try
        {
          paramEditText.getEditableText().replace(i1, i2, com.tencent.mobileqq.text.TextUtils.c(((SystemEmoticonInfo)paramEmoticonInfo).jdField_a_of_type_Int));
          return;
        }
        catch (IllegalArgumentException paramEmoticonInfo)
        {
          QLog.e("ReadInJoyBaseDeliverActivity", 2, "sendEmoticon: ", paramEmoticonInfo);
          return;
        }
        if (!(paramEmoticonInfo instanceof SystemAndEmojiEmoticonInfo)) {
          break;
        }
        paramEmoticonInfo = (SystemAndEmojiEmoticonInfo)paramEmoticonInfo;
        i1 = paramEditText.getSelectionStart();
        i2 = paramEditText.getSelectionEnd();
        i3 = paramEmoticonInfo.jdField_a_of_type_Int;
        i4 = paramEmoticonInfo.jdField_b_of_type_Int;
      } while ((i1 < 0) || (i2 < 0) || (i2 < i1) || ((i3 == 2) && (i4 == -1)));
      if (i3 == 1) {}
      for (paramEmoticonInfo = com.tencent.mobileqq.text.TextUtils.c(i4);; paramEmoticonInfo = com.tencent.mobileqq.text.TextUtils.a(i4))
      {
        paramEditText.getEditableText().replace(i1, i2, paramEmoticonInfo);
        paramEditText.requestFocus();
        return;
      }
    } while (!(paramEmoticonInfo instanceof SmallEmoticonInfo));
    paramEmoticonInfo = (SmallEmoticonInfo)paramEmoticonInfo;
    if (paramEmoticonInfo.a == null)
    {
      QLog.e("ReadInJoyBaseDeliverActivity", 1, "kandian fail to send small_emotion.");
      return;
    }
    new QueryTask(new lcd(), new lce(paramEditText)).a(paramEmoticonInfo);
  }
  
  public static String b(String paramString1, String paramString2)
  {
    if (android.text.TextUtils.isEmpty(paramString1)) {
      return paramString1;
    }
    Object localObject2 = new StringBuilder("\\[emoji:0x[a-fA-F0-9]{5}");
    Object localObject1 = new StringBuilder("\\[sysEmo:[0-9]{3}");
    if (!android.text.TextUtils.isEmpty(paramString2))
    {
      ((StringBuilder)localObject2).append(paramString2);
      ((StringBuilder)localObject1).append(paramString2);
    }
    for (int i2 = paramString2.length();; i2 = 0)
    {
      ((StringBuilder)localObject2).append("\\]");
      ((StringBuilder)localObject1).append("\\]");
      localObject2 = Pattern.compile(((StringBuilder)localObject2).toString()).matcher(paramString1);
      StringBuffer localStringBuffer = new StringBuffer();
      paramString2 = null;
      if (QLog.isColorLevel()) {
        paramString2 = new StringBuilder(1024).append("afterXml start");
      }
      for (int i1 = 0; ((Matcher)localObject2).find(); i1 = 1)
      {
        i1 = Integer.valueOf(paramString1.substring(((Matcher)localObject2).start() + 9, ((Matcher)localObject2).end() - 1 - i2), 16).intValue();
        if (i1 > 65535) {
          ((Matcher)localObject2).appendReplacement(localStringBuffer, new String(new int[] { i1 }, 0, 1));
        }
        if (QLog.isColorLevel()) {
          paramString2.append("\n").append("unicode").append(":").append(i1);
        }
      }
      ((Matcher)localObject2).appendTail(localStringBuffer);
      localObject2 = localStringBuffer.toString();
      localObject1 = Pattern.compile(((StringBuilder)localObject1).toString()).matcher((CharSequence)localObject2);
      localStringBuffer = new StringBuffer();
      while (((Matcher)localObject1).find())
      {
        i1 = Integer.valueOf(((String)localObject2).substring(((Matcher)localObject1).start() + 8, ((Matcher)localObject1).end() - 1 - i2), 10).intValue();
        ((Matcher)localObject1).appendReplacement(localStringBuffer, new String(new char[] { '\024' }));
        localStringBuffer.append((char)i1);
        i1 = 1;
      }
      ((Matcher)localObject1).appendTail(localStringBuffer);
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyBaseDeliverActivity", 2, paramString2.toString());
      }
      if (i1 == 0) {
        break;
      }
      return localStringBuffer.toString();
    }
  }
  
  private void i()
  {
    if (Looper.myLooper() != Looper.getMainLooper()) {
      ThreadManager.getUIHandler().post(new lbx(this));
    }
    while ((this.jdField_a_of_type_AndroidAppDialog == null) || (!this.jdField_a_of_type_AndroidAppDialog.isShowing())) {
      return;
    }
    this.jdField_a_of_type_AndroidAppDialog.dismiss();
  }
  
  public int a(String paramString)
  {
    try
    {
      int i1 = new ExifInterface(paramString).getAttributeInt("Orientation", 1);
      switch (i1)
      {
      case 4: 
      case 5: 
      case 7: 
      default: 
        return 0;
      case 6: 
        return 90;
      case 3: 
        return 180;
      }
      return 270;
    }
    catch (IOException paramString)
    {
      paramString.printStackTrace();
    }
    return 0;
  }
  
  public Dialog a(Context paramContext, String paramString1, String paramString2, View.OnClickListener paramOnClickListener1, String paramString3, View.OnClickListener paramOnClickListener2, String paramString4)
  {
    paramContext = new Dialog(paramContext, 2131624516);
    paramContext.setContentView(2130968842);
    TextView localTextView = (TextView)paramContext.findViewById(2131364034);
    if (localTextView != null)
    {
      if (paramString1 != null) {
        localTextView.setText(paramString1);
      }
    }
    else
    {
      paramString1 = (TextView)paramContext.findViewById(2131362776);
      if (paramString1 != null)
      {
        if (paramString4 == null) {
          break label156;
        }
        paramString1.setText(paramString4);
      }
      label72:
      paramString1 = (TextView)paramContext.findViewById(2131364037);
      if (paramString1 != null)
      {
        if (paramString2 == null) {
          break label165;
        }
        paramString1.setText(paramString2);
        if (paramOnClickListener1 != null) {
          paramString1.setOnClickListener(paramOnClickListener1);
        }
      }
    }
    for (;;)
    {
      paramString1 = (TextView)paramContext.findViewById(2131364038);
      if (paramString1 != null)
      {
        if (paramString3 == null) {
          break label174;
        }
        paramString1.setText(paramString3);
        if (paramOnClickListener2 != null) {
          paramString1.setOnClickListener(paramOnClickListener2);
        }
      }
      return paramContext;
      localTextView.setVisibility(8);
      break;
      label156:
      paramString1.setVisibility(8);
      break label72;
      label165:
      paramString1.setVisibility(8);
    }
    label174:
    paramString1.setVisibility(8);
    return paramContext;
  }
  
  public Bitmap a(int paramInt, Bitmap paramBitmap)
  {
    Matrix localMatrix = new Matrix();
    localMatrix.postRotate(paramInt);
    return Bitmap.createBitmap(paramBitmap, 0, 0, paramBitmap.getWidth(), paramBitmap.getHeight(), localMatrix, true);
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)findViewById(2131363497));
    this.jdField_a_of_type_AndroidWidgetEditText.requestFocus();
    try
    {
      this.jdField_a_of_type_AndroidWidgetEditText.setEditableFactory(this.jdField_a_of_type_AndroidTextEditable$Factory);
      this.jdField_a_of_type_AndroidWidgetEditText.getInputExtras(true).putInt("SOGOU_EXPRESSION", 1);
      this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131364075));
      this.jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(this);
      this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131366978));
      if (this.jdField_b_of_type_AndroidWidgetImageView != null) {
        this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
      }
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131366975));
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this, super.getTitleBarHeight());
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.setCanceledOnTouchOutside(true);
      this.jdField_a_of_type_ComTencentWidgetXPanelContainer = ((XPanelContainer)findViewById(2131362840));
      this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a(this.jdField_a_of_type_AndroidWidgetEditText, false);
      this.jdField_a_of_type_ComTencentWidgetXPanelContainer.setOnPanelChangeListener(this.jdField_a_of_type_ComTencentWidgetXPanelContainer$PanelCallback);
      if (this.jdField_h_of_type_Boolean)
      {
        this.e = XPanelContainer.jdField_c_of_type_Int;
        if (this.jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener == null) {
          this.jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener = new lbz(this);
        }
        this.jdField_a_of_type_ComTencentWidgetXPanelContainer.getViewTreeObserver().addOnGlobalLayoutListener(this.jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener);
      }
      if (ThemeUtil.isInNightMode(this.app))
      {
        View localView = new View(this);
        localView.setBackgroundColor(1996488704);
        addContentView(localView, new ViewGroup.LayoutParams(-1, -1));
      }
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.e("ReadInJoyBaseDeliverActivity", 1, "input set error", localException);
      }
    }
  }
  
  public void a(int paramInt)
  {
    if (ImmersiveUtils.isSupporImmersive() == 1)
    {
      super.getWindow().addFlags(67108864);
      if (this.mSystemBarComp == null) {
        this.mSystemBarComp = new SystemBarCompact(this, true, -1);
      }
      if ((Build.VERSION.SDK_INT < 23) || (SystemUtil.b()) || (SystemUtil.d())) {
        break label172;
      }
      getWindow().getDecorView().setSystemUiVisibility(9216);
      this.mSystemBarComp.init();
      this.mSystemBarComp.setStatusBarColor(-1);
    }
    for (;;)
    {
      getTitleBarView().setBackgroundColor(-1);
      String str = getString(paramInt);
      setTitle(str, str);
      this.centerView.setTextColor(-16777216);
      setLeftButton(2131438862, this);
      this.leftViewNotBack.setTextColor(-16777216);
      this.leftViewNotBack.setBackgroundColor(0);
      setRightButton(2131438863, this);
      this.rightViewText.setTextColor(Color.parseColor("#07D0B0"));
      this.rightViewText.setBackgroundColor(0);
      return;
      label172:
      this.mSystemBarComp.init();
      if (!SystemUtil.d())
      {
        this.mSystemBarComp.setStatusBarColor(-2368549);
      }
      else
      {
        this.mSystemBarComp.setStatusBarColor(-1);
        this.mSystemBarComp.setStatusBarDarkMode(true);
      }
    }
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.c(paramInt1);
      if (!this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
        this.rightViewText.postDelayed(new lby(this, paramInt2), paramInt3);
      }
    }
  }
  
  protected void a(int paramInt, Intent paramIntent)
  {
    if ((paramIntent == null) || (!this.jdField_g_of_type_Boolean)) {}
    Editable localEditable;
    do
    {
      do
      {
        return;
        paramIntent = paramIntent.getParcelableArrayListExtra("result_set");
      } while ((this.jdField_a_of_type_AndroidWidgetEditText == null) || (paramIntent == null));
      int i1 = this.jdField_a_of_type_AndroidWidgetEditText.getSelectionStart();
      localEditable = this.jdField_a_of_type_AndroidWidgetEditText.getEditableText();
      paramInt = i1;
      if (localEditable != null)
      {
        paramInt = i1;
        if (!android.text.TextUtils.isEmpty(localEditable.toString()))
        {
          paramInt = i1;
          if (i1 > 0)
          {
            paramInt = i1;
            if (localEditable.toString().substring(i1 - 1, i1).equals("@"))
            {
              localEditable.delete(i1 - 1, i1);
              paramInt = i1 - 1;
              this.jdField_a_of_type_AndroidWidgetEditText.setSelection(paramInt);
            }
          }
        }
      }
      if (this.i <= 0)
      {
        this.i = getResources().getDisplayMetrics().widthPixels;
        this.i = (this.i - this.jdField_a_of_type_AndroidWidgetEditText.getPaddingLeft() - this.jdField_a_of_type_AndroidWidgetEditText.getPaddingRight());
      }
    } while (localEditable == null);
    Iterator localIterator = paramIntent.iterator();
    for (;;)
    {
      if (localIterator.hasNext())
      {
        ResultRecord localResultRecord = (ResultRecord)localIterator.next();
        try
        {
          l1 = Long.parseLong(localResultRecord.jdField_a_of_type_JavaLangString);
          if (l1 != 0L)
          {
            paramIntent = ReadInJoyUserInfoModule.a(l1, null);
            if (paramIntent != null)
            {
              paramIntent = paramIntent.nick;
              paramIntent = "@" + BiuNicknameSpan.a(paramIntent) + " ";
              localEditable.insert(paramInt, paramIntent);
              localEditable.setSpan(new AtFriendsSpan(localResultRecord.jdField_a_of_type_JavaLangString, 0L, paramIntent, getApplicationContext(), this.jdField_a_of_type_AndroidWidgetEditText.getPaint(), this.i), paramInt, paramIntent.length() + paramInt, 33);
              paramInt = paramIntent.length() + paramInt;
            }
          }
        }
        catch (NumberFormatException paramIntent)
        {
          for (;;)
          {
            QLog.d("ReadInJoyBaseDeliverActivity", 2, paramIntent.getMessage());
            long l1 = 0L;
            continue;
            paramIntent = localResultRecord.jdField_a_of_type_JavaLangString;
          }
        }
      }
    }
    this.jdField_a_of_type_AndroidWidgetEditText.setSelection(paramInt);
  }
  
  public void a(int paramInt, CharSequence paramCharSequence)
  {
    QQToast.a(this, paramInt, paramCharSequence, 0).b(getTitleBarHeight());
  }
  
  public void a(Editable paramEditable)
  {
    int i1;
    if ((paramEditable instanceof BiuTextBuilder))
    {
      i1 = ((BiuTextBuilder)paramEditable).a();
      if (this.jdField_a_of_type_AndroidWidgetTextView != null)
      {
        if ((this.l) && (i1 - this.jdField_c_of_type_Int <= 0)) {
          break label119;
        }
        this.jdField_a_of_type_AndroidWidgetTextView.setText(String.valueOf(this.jdField_c_of_type_Int - i1));
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      }
      label62:
      if (i1 - this.jdField_c_of_type_Int <= 0) {
        break label138;
      }
      if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
        this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#FF4222"));
      }
    }
    for (this.jdField_d_of_type_Boolean = true;; this.jdField_d_of_type_Boolean = false)
    {
      if (!this.jdField_c_of_type_Boolean) {
        break label166;
      }
      this.jdField_c_of_type_Boolean = false;
      return;
      i1 = paramEditable.length();
      break;
      label119:
      if (!this.l) {
        break label62;
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      break label62;
      label138:
      if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
        this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#BBBBBB"));
      }
    }
    label166:
    this.jdField_b_of_type_Boolean = true;
  }
  
  public void a(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((this.jdField_g_of_type_Boolean) && (paramInt3 == 1) && (paramInt2 == 0) && (paramCharSequence.toString().substring(paramInt1, paramInt1 + 1).equals("@"))) {
      a("2");
    }
  }
  
  protected void a(String paramString)
  {
    this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a();
    Intent localIntent = new Intent(this, SelectMemberActivity.class);
    localIntent.putExtra("param_only_friends", true);
    localIntent.putExtra("param_min", 1);
    localIntent.putExtra("param_max", 10);
    startActivityForResult(localIntent, 10000);
    PublicAccountReportUtils.a(null, "", this.jdField_b_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, 0, 0, paramString, "", "", a(), false);
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.n != paramBoolean)
    {
      this.n = paramBoolean;
      this.rightViewText.setEnabled(paramBoolean);
      if (paramBoolean) {
        this.rightViewText.setTextColor(Color.parseColor("#07D0B0"));
      }
    }
    else
    {
      return;
    }
    this.rightViewText.setTextColor(Color.parseColor("#BBBBBB"));
  }
  
  public void a(boolean paramBoolean1, int paramInt, boolean paramBoolean2, long paramLong)
  {
    if (this.jdField_a_of_type_ComTencentWidgetActionSheet == null)
    {
      this.jdField_a_of_type_ComTencentWidgetActionSheet = ((ActionSheet)ActionSheetHelper.a(this, null));
      this.jdField_a_of_type_ComTencentWidgetActionSheet.a(2131438854);
      this.jdField_a_of_type_ComTencentWidgetActionSheet.a(2131438855, 3);
      this.jdField_a_of_type_ComTencentWidgetActionSheet.c(2131433015);
      this.jdField_a_of_type_ComTencentWidgetActionSheet.a(new lbr(this));
      this.jdField_a_of_type_ComTencentWidgetActionSheet.a(new lbt(this, paramBoolean2, paramLong, paramBoolean1, paramInt));
    }
    if (!this.jdField_a_of_type_ComTencentWidgetActionSheet.isShowing())
    {
      this.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentWidgetActionSheet.show();
    }
  }
  
  public boolean a()
  {
    if (this.jdField_d_of_type_Boolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyBaseDeliverActivity", 2, "onDeliver overlong!");
      }
      a(1, getString(2131438865));
      return false;
    }
    if (!NetworkUtil.g(getApplicationContext()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyBaseDeliverActivity", 2, "onDeliver network error!");
      }
      a(1, getString(2131438866));
      return false;
    }
    return true;
  }
  
  public boolean a(ArrayList paramArrayList)
  {
    if (this.jdField_a_of_type_AndroidWidgetEditText == null) {
      return true;
    }
    Editable localEditable = this.jdField_a_of_type_AndroidWidgetEditText.getText();
    String str1 = this.app.getCurrentAccountUin();
    int i1 = 0;
    if ((localEditable == null) || (android.text.TextUtils.isEmpty(localEditable.toString())))
    {
      paramArrayList.add(new ReadInJoyBaseDeliverActivity.UserBiuInfo(this, str1, 0L, ""));
      return false;
    }
    String str2 = UUID.randomUUID().toString();
    Object localObject1 = a(localEditable.toString(), str2).trim();
    if (android.text.TextUtils.isEmpty((CharSequence)localObject1))
    {
      paramArrayList.add(new ReadInJoyBaseDeliverActivity.UserBiuInfo(this, str1, 0L, ""));
      return true;
    }
    Object localObject4 = (BiuNicknameSpan[])localEditable.getSpans(0, localEditable.length(), BiuNicknameSpan.class);
    if ((localObject4 == null) || (localObject4.length <= 0))
    {
      if (this.m) {
        break label591;
      }
      localObject1 = ((String)localObject1).replaceAll("\n|\r\n", "");
    }
    label588:
    label591:
    for (;;)
    {
      paramArrayList.add(new ReadInJoyBaseDeliverActivity.UserBiuInfo(this, str1, 0L, MessageUtils.a(b(this.jdField_a_of_type_JavaLangString + (String)localObject1, str2))));
      return true;
      localObject1 = new ArrayList();
      ((ArrayList)localObject1).addAll(Arrays.asList((Object[])localObject4));
      Collections.sort((List)localObject1, new ReadInJoyBaseDeliverActivity.BiuSpanComparator(this, localEditable));
      long l1 = 0L;
      Iterator localIterator = ((ArrayList)localObject1).iterator();
      int i2 = 0;
      BiuNicknameSpan localBiuNicknameSpan;
      int i4;
      int i3;
      if (localIterator.hasNext())
      {
        localBiuNicknameSpan = (BiuNicknameSpan)localIterator.next();
        i4 = localEditable.getSpanStart(localBiuNicknameSpan);
        i3 = localEditable.getSpanEnd(localBiuNicknameSpan);
      }
      for (;;)
      {
        Object localObject2;
        try
        {
          localObject1 = localEditable.subSequence(i2, i4).toString();
          if (localObject1 != null)
          {
            localObject4 = a((String)localObject1, str2);
            localObject1 = localObject4;
            if (!this.m) {
              localObject1 = ((String)localObject4).replaceAll("\n|\r\n", "");
            }
            if (i2 != 0) {
              break label588;
            }
            localObject1 = ((String)localObject1).replaceAll("^\\s+", "");
            localObject1 = this.jdField_a_of_type_JavaLangString + (String)localObject1;
            paramArrayList.add(new ReadInJoyBaseDeliverActivity.UserBiuInfo(this, str1, l1, MessageUtils.a(b((String)localObject1, str2)), i1));
          }
          if ((localBiuNicknameSpan instanceof AtFriendsSpan))
          {
            i1 = 1;
            str1 = localBiuNicknameSpan.jdField_a_of_type_JavaLangString;
            l1 = localBiuNicknameSpan.jdField_a_of_type_Long;
            i2 = i3;
          }
        }
        catch (Exception localException1)
        {
          localException1.printStackTrace();
          localObject2 = null;
          continue;
          i1 = 0;
          continue;
        }
        try
        {
          localObject2 = localEditable.subSequence(i2, localEditable.length()).toString();
          if (localObject2 != null)
          {
            localObject4 = a((String)localObject2, str2);
            localObject2 = localObject4;
            if (!this.m) {
              localObject2 = ((String)localObject4).replaceAll("\n|\r\n", "");
            }
            paramArrayList.add(new ReadInJoyBaseDeliverActivity.UserBiuInfo(this, str1, l1, MessageUtils.a(b(((String)localObject2).replaceAll("\\s+$", ""), str2)), i1));
          }
          return false;
        }
        catch (Exception localException2)
        {
          for (;;)
          {
            localException2.printStackTrace();
            Object localObject3 = null;
          }
        }
      }
    }
  }
  
  public String b()
  {
    Object localObject = this.jdField_a_of_type_AndroidWidgetEditText.getEditableText();
    if ((localObject == null) || (((Editable)localObject).length() <= 0)) {
      localObject = "";
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyBaseDeliverActivity", 2, "getCommentString result=" + (String)localObject);
      }
      return localObject;
      String str2 = UUID.randomUUID().toString();
      String str1 = a(localObject.toString(), str2).trim();
      if (str1.length() <= 0)
      {
        localObject = "";
      }
      else
      {
        localObject = str1;
        if (!this.m) {
          localObject = str1.replaceAll("\n|\r\n", "");
        }
        localObject = MessageUtils.a(b((String)localObject, str2));
      }
    }
  }
  
  public void b()
  {
    if (!this.l)
    {
      int i1 = ReadInJoyHelper.l(this.app);
      if (i1 > 0) {
        this.jdField_c_of_type_Int = i1;
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setText(String.valueOf(this.jdField_c_of_type_Int));
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyBaseDeliverActivity", 2, "initData count=" + i1 + ", mMaxWordCount=" + this.jdField_c_of_type_Int);
      }
    }
    for (;;)
    {
      if (this.j)
      {
        this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler = new lch(this, null);
        AppNetConnInfo.registerConnectionChangeReceiver(this, this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler);
      }
      return;
      this.jdField_c_of_type_Int = ReadInJoyConstants.jdField_d_of_type_Int;
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyBaseDeliverActivity", 2, "initData unlimited mode");
      }
    }
  }
  
  public void b(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    if (paramInt == 1)
    {
      if (this.jdField_c_of_type_AndroidWidgetImageView != null) {
        this.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130840809);
      }
      if (this.jdField_a_of_type_AndroidWidgetImageView != null) {
        this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130840810);
      }
      if ((this.jdField_a_of_type_ComTencentWidgetXPanelContainer != null) && (this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a() != 1)) {
        this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a(1);
      }
    }
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            if (paramInt != 2) {
              break;
            }
            if (this.jdField_c_of_type_AndroidWidgetImageView != null) {
              this.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130845410);
            }
            if ((this.jdField_a_of_type_ComTencentWidgetXPanelContainer != null) && (this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a() != 3)) {
              this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a(3);
            }
          } while (this.jdField_a_of_type_AndroidWidgetImageView == null);
          this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130840810);
          return;
          if (paramInt != 0) {
            break;
          }
          if (this.jdField_a_of_type_AndroidWidgetImageView != null) {
            this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130840810);
          }
          if ((this.jdField_a_of_type_ComTencentWidgetXPanelContainer != null) && (this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a() != 0)) {
            this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a();
          }
        } while (this.jdField_c_of_type_AndroidWidgetImageView == null);
        this.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130840809);
        return;
      } while (paramInt != 3);
      if ((this.jdField_a_of_type_ComTencentWidgetXPanelContainer != null) && (this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a() != 24)) {
        this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a(24);
      }
      if (this.jdField_c_of_type_AndroidWidgetImageView != null) {
        this.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130840809);
      }
    } while (this.jdField_a_of_type_AndroidWidgetImageView == null);
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130845410);
  }
  
  public void b(String paramString) {}
  
  public void b(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyBaseDeliverActivity", 2, "onNet2None isFromWifi=" + paramBoolean);
    }
  }
  
  public void c()
  {
    onBackEvent();
  }
  
  public void c(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyBaseDeliverActivity", 2, "onNet2Mobile isFromWifi=" + paramBoolean);
    }
  }
  
  public void d() {}
  
  public void d(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyBaseDeliverActivity", 2, "onNet2Wifi isFromMobile=" + paramBoolean);
    }
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    if (this.jdField_a_of_type_AndroidWidgetEditText != null) {
      this.jdField_a_of_type_AndroidWidgetEditText.removeTextChangedListener(this.jdField_a_of_type_AndroidTextTextWatcher);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel != null) {
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.e();
    }
    if (this.jdField_a_of_type_ComTencentWidgetXPanelContainer != null)
    {
      this.jdField_a_of_type_ComTencentWidgetXPanelContainer.b();
      this.jdField_a_of_type_ComTencentWidgetXPanelContainer.setOnPanelChangeListener(null);
      this.jdField_a_of_type_ComTencentWidgetXPanelContainer.getViewTreeObserver().removeGlobalOnLayoutListener(this.jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler != null)
    {
      AppNetConnInfo.unregisterNetInfoHandler(this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler);
      this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqHotpicPublicAccountHotPicPanel != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqHotpicPublicAccountHotPicPanel.setPublicAccountGifListener(null);
      this.jdField_a_of_type_ComTencentMobileqqHotpicPublicAccountGifListener = null;
    }
  }
  
  public void doOnPause()
  {
    super.doOnPause();
    this.jdField_b_of_type_Int = this.jdField_a_of_type_Int;
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    ThreadManager.getUIHandler().postDelayed(new lbq(this), 300L);
  }
  
  protected void doOnStart()
  {
    super.doOnStart();
    ViewGroup localViewGroup = (ViewGroup)getWindow().getDecorView();
    int i1 = 0;
    for (;;)
    {
      if (i1 < localViewGroup.getChildCount())
      {
        View localView = localViewGroup.getChildAt(i1);
        if ((localView instanceof TopGestureLayout)) {
          ((TopGestureLayout)localView).setInterceptTouchFlag(false);
        }
      }
      else
      {
        return;
      }
      i1 += 1;
    }
  }
  
  protected void e()
  {
    if (this.jdField_g_of_type_Boolean) {
      a("1");
    }
  }
  
  public void f()
  {
    if (this.jdField_a_of_type_Int == 2)
    {
      b(1);
      return;
    }
    b(2);
  }
  
  public void finish()
  {
    if (this.jdField_a_of_type_ComTencentWidgetXPanelContainer != null) {
      this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a();
    }
    if (this.f) {
      setResult(this.jdField_d_of_type_Int, getIntent());
    }
    super.finish();
    overridePendingTransition(2131034121, 2131034122);
  }
  
  public void g()
  {
    if (Looper.myLooper() != Looper.getMainLooper())
    {
      ThreadManager.getUIHandler().post(new lbu(this));
      return;
    }
    lbv locallbv = new lbv(this);
    lbw locallbw = new lbw(this);
    String str = getString(2131438851);
    if (this.jdField_a_of_type_AndroidAppDialog == null)
    {
      this.jdField_a_of_type_AndroidAppDialog = a(this, null, getString(2131438852), locallbw, getString(2131438853), locallbv, str);
      this.jdField_a_of_type_AndroidAppDialog.setCanceledOnTouchOutside(false);
    }
    this.jdField_a_of_type_AndroidAppDialog.show();
  }
  
  public void h()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    switch (paramInt1)
    {
    default: 
      return;
    }
    a(paramInt2, paramIntent);
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131363473: 
      c();
      return;
    case 2131363428: 
      a();
      return;
    case 2131364075: 
      f();
      return;
    }
    e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyBaseDeliverActivity
 * JD-Core Version:    0.7.0.1
 */