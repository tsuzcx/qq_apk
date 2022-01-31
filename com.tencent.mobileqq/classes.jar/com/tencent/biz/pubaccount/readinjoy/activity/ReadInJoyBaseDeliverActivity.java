package com.tencent.biz.pubaccount.readinjoy.activity;

import alud;
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
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
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
import apuc;
import apuf;
import apym;
import apza;
import apzf;
import aswh;
import azah;
import banh;
import bckx;
import bdep;
import bdin;
import bety;
import bhuf;
import bhus;
import bicy;
import bkbq;
import com.tencent.biz.pubaccount.readinjoy.biu.AtFriendsSpan;
import com.tencent.biz.pubaccount.readinjoy.biu.ReadInJoyDeliverBiuActivity;
import com.tencent.biz.pubaccount.readinjoy.model.ReadInJoyDraftboxItem.ReadInJoyDraftboxContent;
import com.tencent.biz.pubaccount.readinjoy.model.ReadInJoyUserInfoModule;
import com.tencent.biz.pubaccount.readinjoy.struct.ReadInJoyUserInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.TopicInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.VisibleSetParam;
import com.tencent.biz.pubaccount.readinjoy.ugc.ReadInJoyTopicSelectionFragment;
import com.tencent.biz.pubaccount.readinjoy.ugc.selectmember.ReadInJoySelectMemberFragment;
import com.tencent.biz.pubaccount.readinjoy.ugc.selectmember.ResultRecord;
import com.tencent.biz.pubaccount.readinjoy.view.text.TopicSpan;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.emoticonview.EmoticonMainPanel;
import com.tencent.mobileqq.hotpic.PublicAccountHotPicPanel;
import com.tencent.mobileqq.model.QueryTask;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.troop.activity.TroopBarPublishLocationSelectActivity;
import com.tencent.mobileqq.troop.data.TroopBarPOI;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XPanelContainer;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.UUID;
import mqq.os.MqqHandler;
import nrt;
import nyd;
import nye;
import nyf;
import nyg;
import nyh;
import nyi;
import nyj;
import nyk;
import nyl;
import nym;
import nyn;
import nyo;
import nyp;
import nyq;
import nyr;
import ohr;
import ojl;
import oqu;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import ors;
import owy;
import pgo;
import qnl;
import qqu;

public class ReadInJoyBaseDeliverActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener, bckx
{
  protected static int h;
  public int a;
  public long a;
  protected Dialog a;
  private Editable.Factory jdField_a_of_type_AndroidTextEditable$Factory = new nyl(this);
  protected TextWatcher a;
  protected ViewTreeObserver.OnGlobalLayoutListener a;
  public EditText a;
  protected ImageView a;
  protected TextView a;
  private apuc jdField_a_of_type_Apuc = new nyn(this);
  private aswh jdField_a_of_type_Aswh = new nyq(this);
  protected bety a;
  public bhuf a;
  private bicy jdField_a_of_type_Bicy = new nym(this);
  public ReadInJoyDraftboxItem.ReadInJoyDraftboxContent a;
  public VisibleSetParam a;
  private EmoticonMainPanel jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel;
  private PublicAccountHotPicPanel jdField_a_of_type_ComTencentMobileqqHotpicPublicAccountHotPicPanel;
  protected INetInfoHandler a;
  public TroopBarPOI a;
  public XPanelContainer a;
  protected String a;
  protected ArrayList<TroopBarPOI> a;
  public pgo a;
  public boolean a;
  public int b;
  protected ImageView b;
  private TextView b;
  public bhuf b;
  public ReadInJoyDraftboxItem.ReadInJoyDraftboxContent b;
  protected String b;
  public boolean b;
  protected int c;
  protected ImageView c;
  protected String c;
  protected boolean c;
  public int d;
  private ImageView d;
  protected String d;
  protected boolean d;
  public int e;
  private String e;
  public boolean e;
  public int f;
  protected boolean f = true;
  protected int g;
  protected boolean g;
  protected boolean h;
  protected int i;
  protected boolean i;
  public int j;
  protected boolean j;
  private int k;
  public boolean k;
  protected boolean l;
  public boolean m;
  protected boolean n;
  public boolean o;
  protected boolean p = true;
  private boolean q = true;
  
  static
  {
    jdField_h_of_type_Int = 8;
  }
  
  public ReadInJoyBaseDeliverActivity()
  {
    this.jdField_a_of_type_Int = 1;
    this.jdField_b_of_type_Int = 1;
    this.jdField_c_of_type_Int = oqu.jdField_a_of_type_Int;
    this.jdField_d_of_type_Int = 0;
    this.jdField_g_of_type_Boolean = true;
    this.jdField_i_of_type_Boolean = true;
    this.jdField_j_of_type_Boolean = true;
    this.jdField_a_of_type_Pgo = owy.a().a();
    this.jdField_a_of_type_Long = -1L;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVisibleSetParam = VisibleSetParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVisibleSetParam;
    this.jdField_d_of_type_JavaLangString = "";
    this.jdField_a_of_type_AndroidTextTextWatcher = new nyd(this);
    this.jdField_j_of_type_Int = -1;
  }
  
  public static int a(String paramString)
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
  
  public static Bitmap a(int paramInt, Bitmap paramBitmap)
  {
    Matrix localMatrix = new Matrix();
    localMatrix.postRotate(paramInt);
    return Bitmap.createBitmap(paramBitmap, 0, 0, paramBitmap.getWidth(), paramBitmap.getHeight(), localMatrix, true);
  }
  
  public static String a()
  {
    try
    {
      Object localObject = new JSONObject();
      ((JSONObject)localObject).put("folder_status", ors.jdField_d_of_type_Int);
      localObject = ((JSONObject)localObject).toString();
      return localObject;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return "";
  }
  
  public static void a(QQAppInterface paramQQAppInterface, apuf paramapuf, EditText paramEditText)
  {
    int i1;
    int i2;
    if ((paramapuf instanceof apzf))
    {
      i1 = paramEditText.getSelectionStart();
      i2 = paramEditText.getSelectionEnd();
      if ((i1 < 0) || (i2 < 0) || (i2 < i1)) {}
    }
    do
    {
      apza localapza;
      int i3;
      int i4;
      do
      {
        try
        {
          paramEditText.getEditableText().replace(i1, i2, banh.c(((apzf)paramapuf).jdField_a_of_type_Int));
          return;
        }
        catch (IllegalArgumentException paramQQAppInterface)
        {
          QLog.e("ReadInJoyBaseDeliverActivity", 2, "sendEmoticon: ", paramQQAppInterface);
          return;
        }
        if (!(paramapuf instanceof apza)) {
          break;
        }
        localapza = (apza)paramapuf;
        i1 = paramEditText.getSelectionStart();
        i2 = paramEditText.getSelectionEnd();
        i3 = localapza.jdField_a_of_type_Int;
        i4 = localapza.jdField_b_of_type_Int;
      } while ((i1 < 0) || (i2 < 0) || (i2 < i1) || (i4 == -1));
      if (i3 == 1) {}
      for (;;)
      {
        try
        {
          paramapuf = banh.c(i4);
          paramEditText.getEditableText().replace(i1, i2, paramapuf);
          paramEditText.requestFocus();
        }
        catch (IllegalArgumentException paramapuf)
        {
          QLog.e("ReadInJoyBaseDeliverActivity", 2, "sendEmoticon: ", paramapuf);
          continue;
        }
        localapza.a(paramQQAppInterface, null);
        return;
        paramapuf = banh.a(i4);
      }
    } while (!(paramapuf instanceof apym));
    paramQQAppInterface = (apym)paramapuf;
    if (paramQQAppInterface.a == null)
    {
      QLog.e("ReadInJoyBaseDeliverActivity", 1, "kandian fail to send small_emotion.");
      return;
    }
    new QueryTask(new nyo(), new nyp(paramEditText)).a(paramQQAppInterface);
  }
  
  private void e(boolean paramBoolean)
  {
    if (this.jdField_b_of_type_AndroidWidgetTextView != null) {
      this.jdField_b_of_type_AndroidWidgetTextView.setSelected(paramBoolean);
    }
  }
  
  private void n()
  {
    if (Looper.myLooper() != Looper.getMainLooper()) {
      ThreadManager.getUIHandler().post(new ReadInJoyBaseDeliverActivity.18(this));
    }
    while ((this.jdField_a_of_type_AndroidAppDialog == null) || (!this.jdField_a_of_type_AndroidAppDialog.isShowing())) {
      return;
    }
    this.jdField_a_of_type_AndroidAppDialog.dismiss();
  }
  
  protected Dialog a(Context paramContext, String paramString1, String paramString2, View.OnClickListener paramOnClickListener1, String paramString3, View.OnClickListener paramOnClickListener2, String paramString4)
  {
    paramContext = new Dialog(paramContext, 2131755801);
    paramContext.setContentView(2131558919);
    TextView localTextView = (TextView)paramContext.findViewById(2131365237);
    if (localTextView != null)
    {
      if (paramString1 != null) {
        localTextView.setText(paramString1);
      }
    }
    else
    {
      paramString1 = (TextView)paramContext.findViewById(2131365233);
      if (paramString1 != null)
      {
        if (paramString4 == null) {
          break label156;
        }
        paramString1.setText(paramString4);
      }
      label72:
      paramString1 = (TextView)paramContext.findViewById(2131365222);
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
      paramString1 = (TextView)paramContext.findViewById(2131365228);
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
  
  protected Integer a()
  {
    Object localObject = this.jdField_a_of_type_AndroidWidgetEditText.getEditableText();
    localObject = (TopicSpan[])((Editable)localObject).getSpans(0, ((Editable)localObject).length(), TopicSpan.class);
    if (localObject != null) {
      return Integer.valueOf(localObject.length);
    }
    return Integer.valueOf(0);
  }
  
  protected void a()
  {
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)findViewById(2131368343));
    if (this.p) {
      this.jdField_a_of_type_AndroidWidgetEditText.requestFocus();
    }
    this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(this.jdField_a_of_type_AndroidTextTextWatcher);
    try
    {
      this.jdField_a_of_type_AndroidWidgetEditText.setEditableFactory(this.jdField_a_of_type_AndroidTextEditable$Factory);
      this.jdField_a_of_type_AndroidWidgetEditText.getInputExtras(true).putInt("SOGOU_EXPRESSION", 1);
      this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131365645));
      this.jdField_d_of_type_AndroidWidgetImageView.setOnClickListener(this);
      this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131362865));
      if (this.jdField_b_of_type_AndroidWidgetImageView != null) {
        this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
      }
      this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131378186));
      if (this.jdField_c_of_type_AndroidWidgetImageView != null) {
        this.jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(this);
      }
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131364120));
      this.jdField_a_of_type_Bety = new bety(this, super.getTitleBarHeight());
      this.jdField_a_of_type_Bety.setCanceledOnTouchOutside(true);
      this.jdField_a_of_type_ComTencentWidgetXPanelContainer = ((XPanelContainer)findViewById(2131376034));
      this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a(this.jdField_a_of_type_AndroidWidgetEditText, false);
      this.jdField_a_of_type_ComTencentWidgetXPanelContainer.setOnPanelChangeListener(this.jdField_a_of_type_Bicy);
      if (this.jdField_j_of_type_Boolean)
      {
        this.jdField_e_of_type_Int = XPanelContainer.jdField_c_of_type_Int;
        if (this.jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener == null) {
          this.jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener = new nyk(this);
        }
        this.jdField_a_of_type_ComTencentWidgetXPanelContainer.getViewTreeObserver().addOnGlobalLayoutListener(this.jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener);
      }
      Object localObject;
      if (ThemeUtil.isInNightMode(this.app))
      {
        localObject = new View(this);
        ((View)localObject).setBackgroundColor(1996488704);
        addContentView((View)localObject, new ViewGroup.LayoutParams(-1, -1));
      }
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131363806));
      if (this.jdField_b_of_type_AndroidWidgetTextView != null)
      {
        this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
        localObject = this.jdField_b_of_type_AndroidWidgetTextView;
        if (((Integer)bkbq.a(ojl.READINJOY_UGC_LBS, Integer.valueOf(1))).intValue() == 1)
        {
          i1 = 0;
          ((TextView)localObject).setVisibility(i1);
        }
      }
      else
      {
        return;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.e("ReadInJoyBaseDeliverActivity", 1, "input set error", localException);
        continue;
        int i1 = 8;
      }
    }
  }
  
  protected void a(int paramInt)
  {
    if (ImmersiveUtils.isSupporImmersive() == 1)
    {
      super.getWindow().addFlags(67108864);
      if (this.mSystemBarComp == null) {
        this.mSystemBarComp = new SystemBarCompact(this, true, -1);
      }
      if ((Build.VERSION.SDK_INT < 23) || (bdep.b()) || (bdep.d())) {
        break label182;
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
      setLeftButton(2131718822, this);
      this.leftViewNotBack.setTextColor(-16777216);
      this.leftViewNotBack.setBackgroundColor(0);
      setRightButton(2131718838, this);
      this.rightViewText.setTextColor(Color.parseColor("#07D0B0"));
      this.rightViewText.setBackgroundColor(0);
      getWindow().setBackgroundDrawableResource(2131167194);
      return;
      label182:
      this.mSystemBarComp.init();
      if (!bdep.d())
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
        if (!TextUtils.isEmpty(localEditable.toString()))
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
      if (this.k <= 0)
      {
        this.k = getResources().getDisplayMetrics().widthPixels;
        this.k = (this.k - this.jdField_a_of_type_AndroidWidgetEditText.getPaddingLeft() - this.jdField_a_of_type_AndroidWidgetEditText.getPaddingRight());
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
          l1 = Long.parseLong(localResultRecord.a());
          if (l1 != 0L)
          {
            paramIntent = ReadInJoyUserInfoModule.a(l1, null);
            if (paramIntent != null)
            {
              paramIntent = paramIntent.nick;
              paramIntent = new SpannableStringBuilder("@" + paramIntent + " ");
              paramIntent.setSpan(new AtFriendsSpan(localResultRecord.a(), 0L, paramIntent, getApplicationContext(), this.jdField_a_of_type_AndroidWidgetEditText.getPaint(), this.k), 0, paramIntent.length(), 33);
              localEditable.insert(paramInt, paramIntent);
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
            paramIntent = ReadInJoyUserInfoModule.a();
          }
        }
      }
    }
    this.jdField_a_of_type_AndroidWidgetEditText.setSelection(paramInt);
  }
  
  public void a(int paramInt, CharSequence paramCharSequence)
  {
    ThreadManager.getUIHandler().post(new ReadInJoyBaseDeliverActivity.19(this, paramInt, paramCharSequence));
  }
  
  protected void a(int paramInt, String... paramVarArgs)
  {
    int i1 = 0;
    switch (paramInt)
    {
    default: 
      paramVarArgs = "";
      paramInt = i1;
      if (this.jdField_b_of_type_AndroidWidgetTextView != null) {
        this.jdField_b_of_type_AndroidWidgetTextView.setText(paramVarArgs);
      }
      if (AppSetting.jdField_c_of_type_Boolean) {
        if (paramInt == 0) {
          break label226;
        }
      }
      break;
    }
    for (;;)
    {
      if (this.jdField_b_of_type_AndroidWidgetTextView != null) {
        this.jdField_b_of_type_AndroidWidgetTextView.setContentDescription(paramVarArgs);
      }
      return;
      paramVarArgs = alud.a(2131713210);
      e(false);
      paramInt = i1;
      break;
      String str = getString(2131718311);
      if ((paramVarArgs != null) && (paramVarArgs.length > 0)) {
        QQToast.a(this, paramVarArgs[0], 1).b(getTitleBarHeight());
      }
      e(false);
      paramVarArgs = str;
      paramInt = i1;
      break;
      paramVarArgs = getString(2131718312);
      e(false);
      paramInt = i1;
      break;
      if ((paramVarArgs != null) && (paramVarArgs.length > 0) && (!TextUtils.isEmpty(paramVarArgs[0])))
      {
        if (TextUtils.isEmpty(paramVarArgs[0]))
        {
          a(3, new String[0]);
          return;
        }
        paramVarArgs = paramVarArgs[0];
        e(true);
        paramInt = 1;
        break;
      }
      a(0, new String[0]);
      e(false);
      return;
      label226:
      paramVarArgs = getString(2131696725);
    }
  }
  
  public void a(Editable paramEditable)
  {
    int i1;
    if ((paramEditable instanceof ohr))
    {
      i1 = ((ohr)paramEditable).a();
      if (this.jdField_a_of_type_AndroidWidgetTextView != null)
      {
        if ((this.n) && (i1 - this.jdField_c_of_type_Int <= 0)) {
          break label170;
        }
        this.jdField_a_of_type_AndroidWidgetTextView.setText(String.valueOf(this.jdField_c_of_type_Int - i1));
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      }
      label62:
      if (i1 - this.jdField_c_of_type_Int <= 0) {
        break label189;
      }
      if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
        this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#FF4222"));
      }
      this.jdField_d_of_type_Boolean = true;
      label96:
      if (!this.jdField_c_of_type_Boolean) {
        break label217;
      }
      this.jdField_c_of_type_Boolean = false;
    }
    for (;;)
    {
      if ((this.jdField_i_of_type_Boolean) && (qqu.a(this.jdField_a_of_type_AndroidWidgetEditText.getText())))
      {
        if (!(this instanceof ReadInJoyDeliverBiuActivity)) {
          break label225;
        }
        nrt.a(null, "", "0X8009579", "0X8009579", 0, 0, "", "", "", a(), false);
      }
      return;
      i1 = paramEditable.length();
      break;
      label170:
      if (!this.n) {
        break label62;
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      break label62;
      label189:
      if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
        this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#BBBBBB"));
      }
      this.jdField_d_of_type_Boolean = false;
      break label96;
      label217:
      this.jdField_b_of_type_Boolean = true;
    }
    label225:
    nrt.a(null, "", "0X800953B", "0X800953B", 0, 0, "", "", "", a(), false);
  }
  
  protected void a(TopicInfo paramTopicInfo)
  {
    if ((this.jdField_a_of_type_AndroidWidgetEditText != null) && (paramTopicInfo != null))
    {
      int i2 = this.jdField_a_of_type_AndroidWidgetEditText.getSelectionStart();
      Editable localEditable = this.jdField_a_of_type_AndroidWidgetEditText.getEditableText();
      if (localEditable != null)
      {
        int i1 = i2;
        if (!TextUtils.isEmpty(localEditable.toString()))
        {
          i1 = i2;
          if (i2 > 0)
          {
            i1 = i2;
            if (localEditable.toString().substring(i2 - 1, i2).equals("#"))
            {
              localEditable.delete(i2 - 1, i2);
              i1 = i2 - 1;
              this.jdField_a_of_type_AndroidWidgetEditText.setSelection(i1);
            }
          }
        }
        SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder(paramTopicInfo.a() + " ");
        localSpannableStringBuilder.setSpan(new TopicSpan(paramTopicInfo), 0, localSpannableStringBuilder.length(), 33);
        localEditable.insert(i1, localSpannableStringBuilder);
        i2 = localSpannableStringBuilder.length();
        this.jdField_a_of_type_AndroidWidgetEditText.setSelection(i1 + i2);
      }
    }
  }
  
  public void a(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramInt3 == 1) && (paramInt2 == 0) && (isResume()))
    {
      paramCharSequence = paramCharSequence.toString().substring(paramInt1, paramInt1 + 1);
      if ((this.jdField_g_of_type_Boolean) && (paramCharSequence.equals("@"))) {
        a("2");
      }
      if ((this.jdField_h_of_type_Boolean) && (paramCharSequence.equals("#")) && (a().intValue() < 10)) {
        g();
      }
    }
  }
  
  protected void a(String paramString)
  {
    this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a();
    PublicFragmentActivity.a(this, new Intent(), ReadInJoySelectMemberFragment.class, 10000);
  }
  
  public void a(JSONObject paramJSONObject, int paramInt, Bundle paramBundle)
  {
    if (isFinishing()) {
      return;
    }
    switch (paramInt)
    {
    default: 
      return;
    }
    if (paramJSONObject != null) {}
    for (;;)
    {
      try
      {
        paramJSONObject = paramJSONObject.getJSONArray("poilist");
        if (this.jdField_a_of_type_JavaUtilArrayList == null)
        {
          this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
          break label318;
          if (paramInt < paramJSONObject.length())
          {
            this.jdField_a_of_type_JavaUtilArrayList.add(new TroopBarPOI(paramJSONObject.getJSONObject(paramInt)));
            paramInt += 1;
            continue;
          }
        }
        else
        {
          this.jdField_a_of_type_JavaUtilArrayList.clear();
        }
      }
      catch (JSONException paramJSONObject)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ReadInJoyBaseDeliverActivity", 2, "get poi list error: " + paramJSONObject.toString());
        }
        if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI != null)
        {
          if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI.jdField_c_of_type_JavaLangString))
          {
            paramJSONObject = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI.jdField_d_of_type_JavaLangString;
            a(1, new String[] { paramJSONObject });
            return;
            if (this.jdField_a_of_type_JavaUtilArrayList.size() > 0) {
              this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI = ((TroopBarPOI)this.jdField_a_of_type_JavaUtilArrayList.get(0));
            }
            if (!QLog.isColorLevel()) {
              continue;
            }
            if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI != null)
            {
              paramJSONObject = String.format("current poi = (name:%s lati:%d long:%d)", new Object[] { this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI.jdField_c_of_type_JavaLangString, Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI.jdField_b_of_type_Int), Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI.jdField_a_of_type_Int) });
              QLog.d("ReadInJoyBaseDeliverActivity", 2, paramJSONObject);
              continue;
            }
            paramJSONObject = "current poi null";
            continue;
          }
          paramJSONObject = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI.jdField_c_of_type_JavaLangString;
          continue;
        }
        a(0, new String[0]);
        return;
      }
      a(3, new String[0]);
      return;
      label318:
      paramInt = 0;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.q != paramBoolean)
    {
      this.q = paramBoolean;
      this.rightViewText.setEnabled(paramBoolean);
      if (paramBoolean) {
        this.rightViewText.setTextColor(Color.parseColor("#262626"));
      }
    }
    else
    {
      return;
    }
    this.rightViewText.setTextColor(Color.parseColor("#BBBBBB"));
  }
  
  protected void a(boolean paramBoolean1, int paramInt, boolean paramBoolean2, long paramLong)
  {
    if (this.jdField_a_of_type_Bhuf == null)
    {
      this.jdField_a_of_type_Bhuf = ((bhuf)bhus.a(this, null));
      this.jdField_a_of_type_Bhuf.a(2131718844);
      this.jdField_a_of_type_Bhuf.a(2131718843, 3);
      this.jdField_a_of_type_Bhuf.c(2131690648);
      this.jdField_a_of_type_Bhuf.a(new nyg(this));
      this.jdField_a_of_type_Bhuf.a(new nyh(this, paramBoolean2, paramLong, paramBoolean1, paramInt));
    }
    if (!this.jdField_a_of_type_Bhuf.isShowing())
    {
      this.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_Bhuf.show();
    }
  }
  
  public boolean a()
  {
    if (this.jdField_d_of_type_Boolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyBaseDeliverActivity", 2, "onDeliver overlong!");
      }
      a(1, getString(2131718837));
      return false;
    }
    if (!bdin.g(getApplicationContext()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyBaseDeliverActivity", 2, "onDeliver network error!");
      }
      a(1, getString(2131718836));
      return false;
    }
    return true;
  }
  
  public String b()
  {
    try
    {
      Object localObject = new JSONObject();
      ((JSONObject)localObject).put("folder_status", ors.jdField_d_of_type_Int);
      ((JSONObject)localObject).put("topicid", d());
      ((JSONObject)localObject).put("topic_num", a());
      localObject = ((JSONObject)localObject).toString();
      return localObject;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return "";
  }
  
  protected void b()
  {
    Intent localIntent = getIntent();
    this.jdField_g_of_type_Int = localIntent.getIntExtra("arg_ad_tag", 0);
    this.jdField_a_of_type_JavaLangString = localIntent.getStringExtra("arg_topic_id");
    this.jdField_b_of_type_JavaLangString = localIntent.getStringExtra("arg_topic_name");
    this.jdField_e_of_type_JavaLangString = localIntent.getStringExtra("arg_callback");
    this.jdField_c_of_type_JavaLangString = getIntent().getStringExtra("arg_ugc_edit_cookie");
    if (this.jdField_h_of_type_Boolean) {}
    for (;;)
    {
      try
      {
        a(TopicInfo.a().a(Long.valueOf(this.jdField_a_of_type_JavaLangString).longValue()).a("#" + this.jdField_b_of_type_JavaLangString).a());
        if (this.n) {
          break label349;
        }
        int i1 = bkbq.j(this.app);
        if (i1 > 0) {
          this.jdField_c_of_type_Int = i1;
        }
        this.jdField_a_of_type_AndroidWidgetTextView.setText(String.valueOf(this.jdField_c_of_type_Int));
        if (QLog.isColorLevel()) {
          QLog.d("ReadInJoyBaseDeliverActivity", 2, "initData count=" + i1 + ", mMaxWordCount=" + this.jdField_c_of_type_Int);
        }
        if (this.l)
        {
          this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler = new nyr(this, null);
          AppNetConnInfo.registerConnectionChangeReceiver(this, this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler);
        }
        i1 = ((Integer)bkbq.a("sp_key_deliver_ugc_paste_link_hint_count", Integer.valueOf(0))).intValue();
        if ((i1 < 2) && (this.jdField_i_of_type_Boolean) && (!(this instanceof ReadInJoyDeliverBiuActivity)))
        {
          this.jdField_a_of_type_AndroidWidgetEditText.setHint(2131718864);
          if (TextUtils.isEmpty(this.jdField_a_of_type_AndroidWidgetEditText.getEditableText())) {
            bkbq.a("sp_key_deliver_ugc_paste_link_hint_count", Integer.valueOf(i1 + 1));
          }
        }
        if (this.jdField_b_of_type_AndroidWidgetTextView != null) {
          this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
        }
        return;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        QLog.d("ReadInJoyBaseDeliverActivity", 2, "initData: fail to add topic from intent");
        continue;
      }
      if (this.jdField_c_of_type_AndroidWidgetImageView != null)
      {
        this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(4);
        continue;
        label349:
        this.jdField_c_of_type_Int = oqu.jdField_d_of_type_Int;
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
        if (QLog.isColorLevel()) {
          QLog.d("ReadInJoyBaseDeliverActivity", 2, "initData unlimited mode");
        }
      }
    }
  }
  
  public void b(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    if (paramInt == 1)
    {
      if (this.jdField_d_of_type_AndroidWidgetImageView != null) {
        this.jdField_d_of_type_AndroidWidgetImageView.setImageResource(2130842576);
      }
      if (this.jdField_a_of_type_AndroidWidgetImageView != null) {
        this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130842578);
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
            if (this.jdField_d_of_type_AndroidWidgetImageView != null) {
              this.jdField_d_of_type_AndroidWidgetImageView.setImageResource(2130848885);
            }
            if ((this.jdField_a_of_type_ComTencentWidgetXPanelContainer != null) && (this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a() != 3)) {
              this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a(3);
            }
          } while (this.jdField_a_of_type_AndroidWidgetImageView == null);
          this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130842578);
          return;
          if (paramInt != 0) {
            break;
          }
          if (this.jdField_a_of_type_AndroidWidgetImageView != null) {
            this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130842578);
          }
          if ((this.jdField_a_of_type_ComTencentWidgetXPanelContainer != null) && (this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a() != 0)) {
            this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a();
          }
        } while (this.jdField_d_of_type_AndroidWidgetImageView == null);
        this.jdField_d_of_type_AndroidWidgetImageView.setImageResource(2130842576);
        return;
      } while (paramInt != 3);
      if ((this.jdField_a_of_type_ComTencentWidgetXPanelContainer != null) && (this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a() != 24)) {
        this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a(24);
      }
      if (this.jdField_d_of_type_AndroidWidgetImageView != null) {
        this.jdField_d_of_type_AndroidWidgetImageView.setImageResource(2130842576);
      }
    } while (this.jdField_a_of_type_AndroidWidgetImageView == null);
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130848885);
  }
  
  protected void b(String paramString) {}
  
  public void b(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyBaseDeliverActivity", 2, "onNet2None isFromWifi=" + paramBoolean);
    }
  }
  
  public String c()
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
      String str1 = qqu.a(localObject.toString(), str2).trim();
      if (str1.length() <= 0)
      {
        localObject = "";
      }
      else
      {
        localObject = str1;
        if (!this.o) {
          localObject = str1.replaceAll("\n|\r\n", "");
        }
        localObject = azah.a(qqu.b((String)localObject, str2));
      }
    }
  }
  
  protected void c()
  {
    nrt.a(null, "", "0X80096D8", "0X80096D8", 0, 0, "", "", "", "", false);
    Intent localIntent = new Intent(this, TroopBarPublishLocationSelectActivity.class);
    localIntent.putParcelableArrayListExtra("current_location_list", this.jdField_a_of_type_JavaUtilArrayList);
    localIntent.putExtra("key_selected_poi", this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI);
    startActivityForResult(localIntent, 1002);
    overridePendingTransition(2130771992, 2130771993);
  }
  
  protected void c(int paramInt)
  {
    if (this.jdField_a_of_type_Bety != null)
    {
      this.jdField_a_of_type_Bety.c(paramInt);
      if (!this.jdField_a_of_type_Bety.isShowing()) {
        this.jdField_a_of_type_Bety.show();
      }
    }
  }
  
  public void c(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyBaseDeliverActivity", 2, "onNet2Mobile isFromWifi=" + paramBoolean);
    }
  }
  
  protected String d()
  {
    Object localObject = this.jdField_a_of_type_AndroidWidgetEditText.getEditableText();
    localObject = (TopicSpan[])((Editable)localObject).getSpans(0, ((Editable)localObject).length(), TopicSpan.class);
    if ((localObject != null) && (localObject.length > 0))
    {
      StringBuilder localStringBuilder = new StringBuilder().append(localObject[0].a().a());
      int i2 = localObject.length;
      int i1 = 1;
      while (i1 < i2)
      {
        localStringBuilder.append("|").append(localObject[i1].a().a());
        i1 += 1;
      }
      return localStringBuilder.toString();
    }
    return "0";
  }
  
  protected void d()
  {
    onBackEvent();
  }
  
  public void d(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyBaseDeliverActivity", 2, "onNet2Wifi isFromMobile=" + paramBoolean);
    }
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    switch (paramInt1)
    {
    }
    do
    {
      do
      {
        return;
        a(paramInt2, paramIntent);
        return;
      } while ((paramIntent == null) || (paramInt2 != -1));
      a((TopicInfo)paramIntent.getParcelableExtra("EXTRA_SELECTED_TOPIC"));
      return;
    } while ((paramIntent == null) || (paramInt2 != -1));
    this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI = ((TroopBarPOI)paramIntent.getParcelableExtra("key_selected_poi"));
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder().append("onActivityResult: ").append(paramInt2);
      if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI != null)
      {
        paramIntent = String.format("current poi = (name:%s lati:%d long:%d)", new Object[] { this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI.jdField_c_of_type_JavaLangString, Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI.jdField_b_of_type_Int), Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI.jdField_a_of_type_Int) });
        QLog.d("ReadInJoyBaseDeliverActivity", 2, paramIntent);
      }
    }
    else
    {
      if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI == null) {
        break label253;
      }
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI.jdField_c_of_type_JavaLangString)) {
        break label242;
      }
    }
    label242:
    for (paramIntent = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI.jdField_d_of_type_JavaLangString;; paramIntent = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI.jdField_c_of_type_JavaLangString)
    {
      a(1, new String[] { paramIntent });
      return;
      paramIntent = "current poi null";
      break;
    }
    label253:
    a(0, new String[0]);
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel != null) {
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.g();
    }
    if (this.jdField_a_of_type_AndroidWidgetEditText != null) {
      this.jdField_a_of_type_AndroidWidgetEditText.removeTextChangedListener(this.jdField_a_of_type_AndroidTextTextWatcher);
    }
    if (this.jdField_a_of_type_ComTencentWidgetXPanelContainer != null)
    {
      this.jdField_a_of_type_ComTencentWidgetXPanelContainer.d();
      this.jdField_a_of_type_ComTencentWidgetXPanelContainer.setOnPanelChangeListener(null);
      this.jdField_a_of_type_ComTencentWidgetXPanelContainer.getViewTreeObserver().removeGlobalOnLayoutListener(this.jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener);
    }
    if (this.jdField_a_of_type_Bety != null)
    {
      this.jdField_a_of_type_Bety.dismiss();
      this.jdField_a_of_type_Bety = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler != null)
    {
      AppNetConnInfo.unregisterNetInfoHandler(this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler);
      this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqHotpicPublicAccountHotPicPanel != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqHotpicPublicAccountHotPicPanel.setPublicAccountGifListener(null);
      this.jdField_a_of_type_Aswh = null;
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
    if (!this.p) {
      return;
    }
    ThreadManager.getUIHandler().postDelayed(new ReadInJoyBaseDeliverActivity.1(this), 300L);
  }
  
  public void doOnStart()
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
  
  public void e() {}
  
  protected void f()
  {
    if (this.jdField_g_of_type_Boolean) {
      a("1");
    }
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
    overridePendingTransition(2130771977, 2130771978);
  }
  
  protected void g()
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("searchTopicFrom", this.jdField_i_of_type_Int);
    PublicFragmentActivity.a(this, localIntent, ReadInJoyTopicSelectionFragment.class, 3001);
  }
  
  protected void h()
  {
    if (this.jdField_a_of_type_Int == 2)
    {
      b(1);
      return;
    }
    b(2);
  }
  
  protected void i()
  {
    if (this.jdField_b_of_type_Bhuf == null)
    {
      this.jdField_b_of_type_Bhuf = ((bhuf)bhus.a(this, null));
      this.jdField_b_of_type_Bhuf.a(alud.a(2131713186));
      this.jdField_b_of_type_Bhuf.a(alud.a(2131713336), 9, "#ff000000");
      this.jdField_b_of_type_Bhuf.a(alud.a(2131713225), 3);
      this.jdField_b_of_type_Bhuf.d(alud.a(2131713147));
      this.jdField_b_of_type_Bhuf.a(new nye(this));
      this.jdField_b_of_type_Bhuf.a(new nyf(this));
    }
    if (!this.jdField_b_of_type_Bhuf.isShowing())
    {
      this.jdField_a_of_type_Boolean = false;
      this.jdField_b_of_type_Bhuf.show();
    }
  }
  
  public void j() {}
  
  public void k() {}
  
  protected void l()
  {
    if (Looper.myLooper() != Looper.getMainLooper())
    {
      ThreadManager.getUIHandler().post(new ReadInJoyBaseDeliverActivity.15(this));
      return;
    }
    nyi localnyi = new nyi(this);
    nyj localnyj = new nyj(this);
    String str = getString(2131718850);
    if (this.jdField_a_of_type_AndroidAppDialog == null)
    {
      this.jdField_a_of_type_AndroidAppDialog = a(this, null, getString(2131718847), localnyj, getString(2131718848), localnyi, str);
      this.jdField_a_of_type_AndroidAppDialog.setCanceledOnTouchOutside(false);
    }
    this.jdField_a_of_type_AndroidAppDialog.show();
  }
  
  public void m()
  {
    if ((this.jdField_a_of_type_Bety != null) && (this.jdField_a_of_type_Bety.isShowing())) {
      this.jdField_a_of_type_Bety.dismiss();
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131368626: 
      d();
      return;
    case 2131368655: 
      a();
      return;
    case 2131365645: 
      h();
      return;
    case 2131362865: 
      f();
      return;
    case 2131378186: 
      if (a().intValue() >= 10)
      {
        QQToast.a(this, 2131719064, 0).a();
        return;
      }
      g();
      return;
    }
    c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyBaseDeliverActivity
 * JD-Core Version:    0.7.0.1
 */