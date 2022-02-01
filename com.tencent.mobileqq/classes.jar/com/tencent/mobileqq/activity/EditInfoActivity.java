package com.tencent.mobileqq.activity;

import Override;
import QQService.EVIPSPEC;
import aemd;
import aeme;
import aemg;
import aemh;
import aemi;
import aemj;
import aemm;
import aemn;
import aemo;
import aemp;
import aemq;
import aemr;
import aems;
import aemt;
import aemu;
import aemv;
import aemx;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.text.Editable;
import android.text.InputFilter;
import android.text.Selection;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import anum;
import anuw;
import anyu;
import anyw;
import anzj;
import aogu;
import aogx;
import aoip;
import aojs;
import armv;
import armw;
import asmr;
import asmu;
import asrv;
import assj;
import assn;
import bacp;
import begb;
import begf;
import behh;
import bhgr;
import bhmg;
import bhnv;
import bhwq;
import bhws;
import bhwt;
import bhwv;
import bhww;
import bhwz;
import bhxf;
import bhxg;
import bhxs;
import bhzs;
import bhzu;
import bivt;
import biwb;
import biyy;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.emoticonview.EmoticonMainPanel;
import com.tencent.mobileqq.emoticonview.HorizontalListViewEx;
import com.tencent.mobileqq.emoticonview.SystemAndEmojiUniversalPanel;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.profile.view.SoftInputDetectView;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.troop.widget.EllipsizingTextView;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.mobileqq.widget.ClearableEditText;
import com.tencent.mobileqq.widget.ColorClearableEditText;
import com.tencent.mobileqq.widget.ColorNickTextView;
import com.tencent.mobileqq.widget.InputMethodLinearLayout;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import mqq.app.MobileQQ;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.oidb.cmd0x8fc.Oidb_0x8fc.CommCardNameBuf;
import tencent.im.oidb.cmd0x8fc.Oidb_0x8fc.RichCardNameElem;

public class EditInfoActivity
  extends IphoneTitleBarActivity
  implements Handler.Callback, View.OnClickListener, asmr, bacp, bhwv, bivt, biyy
{
  protected int a;
  protected Drawable a;
  public Handler a;
  RecyclerView.LayoutManager jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$LayoutManager;
  RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  protected ViewGroup a;
  public EditText a;
  public ImageView a;
  public LinearLayout a;
  RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  TextView jdField_a_of_type_AndroidWidgetTextView = null;
  private anuw jdField_a_of_type_Anuw = new aemg(this);
  private anyu jdField_a_of_type_Anyu = new aemh(this);
  private aogx jdField_a_of_type_Aogx = new aemi(this);
  aojs jdField_a_of_type_Aojs = new aeme(this);
  bhwq jdField_a_of_type_Bhwq;
  private bhwt jdField_a_of_type_Bhwt = new aemm(this);
  private bhzs jdField_a_of_type_Bhzs = new aemj(this);
  EmoticonMainPanel jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel;
  SystemAndEmojiUniversalPanel jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemAndEmojiUniversalPanel = null;
  SoftInputDetectView jdField_a_of_type_ComTencentMobileqqProfileViewSoftInputDetectView;
  public EllipsizingTextView a;
  ColorNickTextView jdField_a_of_type_ComTencentMobileqqWidgetColorNickTextView;
  InputMethodLinearLayout jdField_a_of_type_ComTencentMobileqqWidgetInputMethodLinearLayout;
  protected String a;
  private ArrayList<bhws> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  public boolean a;
  private bhws[] jdField_a_of_type_ArrayOfBhws = { new bhws(2, null, 0, null) };
  protected int b;
  ImageView jdField_b_of_type_AndroidWidgetImageView;
  RelativeLayout jdField_b_of_type_AndroidWidgetRelativeLayout;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  public String b;
  private ArrayList<Integer> jdField_b_of_type_JavaUtilArrayList = new ArrayList();
  public boolean b;
  public int c;
  ImageView jdField_c_of_type_AndroidWidgetImageView;
  RelativeLayout jdField_c_of_type_AndroidWidgetRelativeLayout;
  TextView jdField_c_of_type_AndroidWidgetTextView;
  public String c;
  protected boolean c;
  public int d;
  ImageView jdField_d_of_type_AndroidWidgetImageView;
  RelativeLayout jdField_d_of_type_AndroidWidgetRelativeLayout;
  TextView jdField_d_of_type_AndroidWidgetTextView;
  String jdField_d_of_type_JavaLangString = "";
  protected boolean d;
  public int e;
  RelativeLayout jdField_e_of_type_AndroidWidgetRelativeLayout;
  public String e;
  boolean jdField_e_of_type_Boolean = true;
  public int f;
  public String f;
  boolean f;
  public int g;
  String g;
  public boolean g;
  public int h;
  protected String h;
  boolean h;
  private int jdField_i_of_type_Int;
  String jdField_i_of_type_JavaLangString;
  boolean jdField_i_of_type_Boolean = false;
  private int j;
  public boolean j;
  private int jdField_k_of_type_Int;
  boolean jdField_k_of_type_Boolean = true;
  private boolean l;
  private boolean m;
  
  public EditInfoActivity()
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout = null;
    this.jdField_a_of_type_Int = -1;
    this.jdField_b_of_type_Int = -1;
    this.jdField_c_of_type_JavaLangString = "";
    this.jdField_c_of_type_Int = 0;
    this.jdField_d_of_type_Int = -1;
    this.jdField_f_of_type_Boolean = false;
    this.jdField_g_of_type_Boolean = false;
    this.jdField_h_of_type_Boolean = false;
    this.jdField_e_of_type_Int = 0;
    this.jdField_f_of_type_Int = 0;
    this.jdField_g_of_type_Int = 0;
    this.jdField_h_of_type_Int = 0;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(this);
  }
  
  private int a()
  {
    if (a(new aemx(null)))
    {
      localObject1 = ((ColorClearableEditText)this.jdField_a_of_type_AndroidWidgetEditText).a();
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = ((ArrayList)localObject1).iterator();
      if (localIterator.hasNext())
      {
        localObject1 = (biwb)localIterator.next();
        Oidb_0x8fc.RichCardNameElem localRichCardNameElem = new Oidb_0x8fc.RichCardNameElem();
        switch (((biwb)localObject1).jdField_c_of_type_Int)
        {
        }
        for (;;)
        {
          localArrayList.add(localRichCardNameElem);
          break;
          localRichCardNameElem.bytes_text.set(ByteStringMicro.copyFrom(((biwb)localObject1).jdField_a_of_type_JavaLangString.getBytes()));
          continue;
          Object localObject2 = ((biwb)localObject1).jdField_a_of_type_JavaLangString;
          localObject1 = localObject2;
          if (((String)localObject2).substring(0, 1).equals("<")) {
            localObject1 = ((String)localObject2).substring(1);
          }
          localObject2 = localObject1;
          if (((String)localObject1).substring(((String)localObject1).length() - 1).equals(">")) {
            localObject2 = ((String)localObject1).substring(0, ((String)localObject1).length() - 1);
          }
          localRichCardNameElem.bytes_ctrl.set(ByteStringMicro.copyFrom(((String)localObject2).getBytes()));
        }
      }
      localObject1 = new Oidb_0x8fc.CommCardNameBuf();
      ((Oidb_0x8fc.CommCardNameBuf)localObject1).rpt_rich_card_name.set(localArrayList);
      return ((Oidb_0x8fc.CommCardNameBuf)localObject1).toByteArray().length;
    }
    Object localObject1 = this.jdField_a_of_type_AndroidWidgetEditText.getText();
    if (localObject1 == null) {}
    int n;
    for (localObject1 = "";; localObject1 = localObject1.toString())
    {
      n = ((String)localObject1).trim().length();
      try
      {
        int i1 = ((String)localObject1).trim().getBytes("utf-8").length;
        return i1;
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        if (!QLog.isColorLevel()) {
          return n;
        }
        QLog.d("ColorNick", 2, "UnsupportedEncodingException:" + localUnsupportedEncodingException.getMessage());
      }
    }
    return n;
  }
  
  private void a(int paramInt)
  {
    this.app.addObserver(this.jdField_a_of_type_Aogx);
    ((aogu)this.app.a(13)).e(paramInt);
  }
  
  private boolean a()
  {
    return (this.jdField_g_of_type_Boolean) && (this.jdField_f_of_type_JavaLangString.equals(this.app.getCurrentAccountUin()));
  }
  
  private boolean a(aemx paramaemx)
  {
    boolean bool2 = false;
    if (paramaemx != null)
    {
      paramaemx.jdField_b_of_type_Boolean = false;
      paramaemx.jdField_a_of_type_Boolean = false;
    }
    Object localObject1;
    if ((this.jdField_a_of_type_AndroidWidgetEditText instanceof ColorClearableEditText))
    {
      localObject1 = (ColorClearableEditText)this.jdField_a_of_type_AndroidWidgetEditText;
      ((ColorClearableEditText)localObject1).a();
      localObject1 = ((ColorClearableEditText)localObject1).a();
      if ((localObject1 == null) || (((ArrayList)localObject1).size() <= 0)) {}
    }
    try
    {
      localObject1 = ((ArrayList)localObject1).iterator();
      bool2 = false;
      bool1 = false;
      biwb localbiwb;
      int n;
      boolean bool3;
      boolean bool4;
      label173:
      if (paramaemx == null) {
        break label244;
      }
    }
    finally
    {
      try
      {
        if (((Iterator)localObject1).hasNext())
        {
          localbiwb = (biwb)((Iterator)localObject1).next();
          n = localbiwb.jdField_c_of_type_Int;
          if (n == 1)
          {
            bool3 = true;
            bool4 = bool1;
          }
          do
          {
            for (;;)
            {
              bool2 = bool3;
              bool1 = bool4;
              if (!bool4) {
                break;
              }
              bool2 = bool3;
              bool1 = bool4;
              if (!bool3) {
                break;
              }
              if (paramaemx != null)
              {
                paramaemx.jdField_b_of_type_Boolean = bool4;
                paramaemx.jdField_a_of_type_Boolean = bool3;
              }
              return true;
              if (localbiwb.jdField_c_of_type_Int != 3) {
                break label173;
              }
              bool4 = true;
              bool3 = bool2;
            }
            n = localbiwb.jdField_c_of_type_Int;
            bool3 = bool2;
            bool4 = bool1;
          } while (n != 2);
          if (paramaemx != null)
          {
            paramaemx.jdField_b_of_type_Boolean = bool1;
            paramaemx.jdField_a_of_type_Boolean = bool2;
          }
          return true;
        }
        if (paramaemx != null)
        {
          paramaemx.jdField_b_of_type_Boolean = bool1;
          paramaemx.jdField_a_of_type_Boolean = bool2;
        }
        return false;
      }
      finally
      {
        boolean bool1;
        break label229;
      }
      localObject2 = finally;
      bool1 = false;
    }
    label229:
    paramaemx.jdField_b_of_type_Boolean = bool1;
    paramaemx.jdField_a_of_type_Boolean = bool2;
    label244:
    throw localObject2;
  }
  
  private void b(int paramInt)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.jdField_i_of_type_Int = 0;
      return;
      if (this.jdField_k_of_type_Int == 1)
      {
        a();
      }
      else
      {
        this.jdField_k_of_type_Int = 1;
        this.jdField_d_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
        bhwz.a(this.app).jdField_a_of_type_AndroidOsHandler = this.jdField_a_of_type_AndroidOsHandler;
        this.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130847074);
        this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130847079);
        this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
        this.jdField_c_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
        this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setVisibility(8);
        ((RelativeLayout.LayoutParams)this.jdField_b_of_type_AndroidWidgetRelativeLayout.getLayoutParams()).height = bhgr.a(this, 387.0F);
        ((RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetRelativeLayout.getLayoutParams()).bottomMargin = bhgr.a(this, 387.0F);
        if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel == null)
        {
          this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel = ((EmoticonMainPanel)View.inflate(getBaseContext(), 2131559123, null));
          if (this.jdField_d_of_type_Int == 0) {
            this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.setFilterSysFaceBeyond255Enable(true);
          }
          this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.setCallBack(this);
          this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.jdField_c_of_type_Boolean = true;
          this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.jdField_f_of_type_Boolean = true;
          this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.jdField_a_of_type_Boolean = false;
          this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.jdField_b_of_type_Boolean = true;
          this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.jdField_e_of_type_Boolean = true;
          this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.a(this.app, 100001, this, getTitleBarHeight(), null, null, false, bhwz.a(this.app).jdField_a_of_type_Bhxg);
          this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.jdField_a_of_type_ComTencentMobileqqEmoticonviewHorizontalListViewEx.setOverScrollMode(2);
          this.jdField_c_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel);
          continue;
          if (this.jdField_k_of_type_Int == 2)
          {
            a();
          }
          else
          {
            this.jdField_k_of_type_Int = 2;
            this.jdField_d_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
            bhwz.a(this.app).jdField_a_of_type_AndroidOsHandler = this.jdField_a_of_type_AndroidOsHandler;
            this.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130847073);
            this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130847080);
            this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
            this.jdField_c_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
            this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setVisibility(0);
            ((RelativeLayout.LayoutParams)this.jdField_b_of_type_AndroidWidgetRelativeLayout.getLayoutParams()).height = bhgr.a(this, 388.0F);
            ((RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetRelativeLayout.getLayoutParams()).bottomMargin = bhgr.a(this, 388.0F);
          }
        }
      }
    }
  }
  
  private boolean b()
  {
    armv localarmv = armw.c();
    if (localarmv == null) {
      return a();
    }
    return (localarmv.jdField_a_of_type_Boolean) && (a());
  }
  
  private void d(boolean paramBoolean)
  {
    Object localObject = new ArrayList();
    Collections.addAll((Collection)localObject, this.jdField_a_of_type_ArrayOfBhws);
    ((ArrayList)localObject).addAll(this.jdField_a_of_type_JavaUtilArrayList);
    this.jdField_a_of_type_Bhwq.a((List)localObject, paramBoolean);
    localObject = ((anyw)this.app.getManager(51)).e(this.jdField_f_of_type_JavaLangString);
    if (localObject != null)
    {
      if (((Friends)localObject).isServiceEnabled(EVIPSPEC.E_SP_SUPERVIP))
      {
        this.jdField_b_of_type_AndroidWidgetTextView.setText(getString(2131690742));
        this.jdField_c_of_type_AndroidWidgetTextView.setText(getString(2131690743));
      }
    }
    else {
      return;
    }
    this.jdField_b_of_type_AndroidWidgetTextView.setText(getString(2131690740));
    this.jdField_c_of_type_AndroidWidgetTextView.setText(getString(2131690741));
  }
  
  private void p()
  {
    SpannableString localSpannableString = new begb(this.jdField_a_of_type_AndroidWidgetEditText.getText().toString(), 32).a();
    bhwz.a(this.app, this.jdField_a_of_type_AndroidWidgetEditText, localSpannableString);
  }
  
  public void a()
  {
    InputMethodManager localInputMethodManager = (InputMethodManager)getSystemService("input_method");
    if ((this.jdField_a_of_type_AndroidWidgetEditText != null) && (this.jdField_k_of_type_Boolean))
    {
      if (QLog.isColorLevel()) {
        QLog.i("EditInfoActivity", 2, String.format("showInputMethod()", new Object[0]));
      }
      localInputMethodManager.showSoftInput(this.jdField_a_of_type_AndroidWidgetEditText, 2);
    }
  }
  
  public void a(Intent paramIntent) {}
  
  protected void a(EditText paramEditText)
  {
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131365893));
    this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_c_of_type_JavaLangString);
    paramEditText.addTextChangedListener(new aemt(this, paramEditText));
  }
  
  public void a(asmu paramasmu)
  {
    if ((this.jdField_a_of_type_AndroidWidgetEditText instanceof ColorClearableEditText))
    {
      this.m = true;
      if ((paramasmu instanceof assj))
      {
        paramasmu = (assj)paramasmu;
        if (paramasmu.jdField_b_of_type_Int != -1) {}
      }
      while (!(paramasmu instanceof asrv))
      {
        return;
        int n = this.jdField_a_of_type_AndroidWidgetEditText.getSelectionStart();
        int i1 = this.jdField_a_of_type_AndroidWidgetEditText.getSelectionEnd();
        this.jdField_a_of_type_AndroidWidgetEditText.getEditableText().replace(n, i1, behh.c(paramasmu.jdField_b_of_type_Int));
        this.jdField_a_of_type_AndroidWidgetEditText.requestFocus();
        return;
      }
      bhwz.a((asrv)paramasmu, this.app, this.jdField_a_of_type_AndroidWidgetEditText);
      return;
    }
    paramasmu.a(this.app, this, this.jdField_a_of_type_AndroidWidgetEditText, null);
  }
  
  public void a(asmu paramasmu1, asmu paramasmu2, Drawable paramDrawable) {}
  
  public void a(bhws parambhws)
  {
    ColorClearableEditText localColorClearableEditText;
    String str;
    int i1;
    int n;
    if ((this.jdField_a_of_type_AndroidWidgetEditText instanceof ColorClearableEditText))
    {
      this.m = true;
      localColorClearableEditText = (ColorClearableEditText)this.jdField_a_of_type_AndroidWidgetEditText;
      str = bhwz.a(parambhws);
      bhxs[] arrayOfbhxs = (bhxs[])this.jdField_a_of_type_AndroidWidgetEditText.getEditableText().getSpans(0, this.jdField_a_of_type_AndroidWidgetEditText.getEditableText().length(), bhxs.class);
      if ((arrayOfbhxs == null) || (arrayOfbhxs.length <= 0)) {
        break label274;
      }
      i1 = this.jdField_a_of_type_AndroidWidgetEditText.getEditableText().getSpanStart(arrayOfbhxs[0]);
      n = this.jdField_a_of_type_AndroidWidgetEditText.getEditableText().getSpanEnd(arrayOfbhxs[0]);
      this.jdField_a_of_type_AndroidWidgetEditText.getEditableText().removeSpan(arrayOfbhxs[0]);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetEditText.getEditableText().replace(i1, n, str);
      switch (parambhws.jdField_a_of_type_Int)
      {
      }
      do
      {
        return;
        if (parambhws.jdField_b_of_type_Int != 0) {
          localColorClearableEditText.setTextColor(parambhws.jdField_b_of_type_Int);
        }
        for (;;)
        {
          localColorClearableEditText.setSpecialColor(0, null, null, 0, null);
          return;
          localColorClearableEditText.setTextColor(getResources().getColor(2131167089));
        }
        localColorClearableEditText.setTextColor(getResources().getColor(2131167089));
        parambhws = bhwz.a(this.app).a(parambhws.jdField_b_of_type_Int);
      } while (parambhws == null);
      localColorClearableEditText.setSpecialColor(parambhws.jdField_a_of_type_Int, parambhws.jdField_a_of_type_ArrayOfInt, parambhws.jdField_a_of_type_ArrayOfFloat, parambhws.jdField_b_of_type_Int, parambhws.jdField_a_of_type_AndroidGraphicsBitmap);
      return;
      label274:
      n = 0;
      i1 = 0;
    }
  }
  
  public void a(String paramString)
  {
    Object localObject;
    switch (this.jdField_g_of_type_Int)
    {
    default: 
      localObject = new Intent();
      ((Intent)localObject).putExtra("type", this.jdField_a_of_type_Int);
      ((Intent)localObject).putExtra("subtype", this.jdField_b_of_type_Int);
      ((Intent)localObject).putExtra("result", paramString);
      a((Intent)localObject);
      setResult(-1, (Intent)localObject);
      e(this);
    case 1: 
      do
      {
        return;
        if (!bhnv.d(this.app.getApplication().getApplicationContext()))
        {
          QQToast.a(this, 1, 2131693965, 0).b(getTitleBarHeight());
          return;
        }
        if (QLog.isColorLevel()) {
          QLog.d("EditInfoActivity", 2, String.format("edit self nick, uin: %s, result: %s", new Object[] { this.jdField_f_of_type_JavaLangString, paramString }));
        }
      } while ((TextUtils.isEmpty(paramString.trim())) || (!this.jdField_f_of_type_JavaLangString.equals(this.app.getCurrentAccountUin())));
      b(true);
      localObject = new Bundle();
      ((Bundle)localObject).putString("nick", paramString.trim());
      ((anum)this.app.a(2)).a((Bundle)localObject);
      this.jdField_j_of_type_Boolean = true;
      return;
    }
    if (!bhnv.d(this.app.getApplication().getApplicationContext()))
    {
      QQToast.a(this, 1, 2131693965, 0).b(getTitleBarHeight());
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("EditInfoActivity", 2, String.format("edit friend remark, uin: %s, result: %s", new Object[] { this.jdField_f_of_type_JavaLangString, paramString }));
    }
    b(true);
    ((FriendListHandler)this.app.a(1)).a(this.jdField_f_of_type_JavaLangString, paramString, false);
    this.jdField_j_of_type_Boolean = true;
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetInputMethodLinearLayout == null) {}
    do
    {
      do
      {
        return;
        if (!paramBoolean) {
          break;
        }
      } while ((this.jdField_a_of_type_AndroidWidgetLinearLayout == null) || (this.jdField_a_of_type_AndroidWidgetImageView == null));
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130847906);
      this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(anzj.a(2131702527));
      return;
    } while ((!this.jdField_a_of_type_Boolean) || (this.jdField_a_of_type_AndroidWidgetLinearLayout == null));
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    this.l = paramBoolean;
    if (paramBoolean)
    {
      this.jdField_a_of_type_AndroidWidgetEditText.setCursorVisible(true);
      this.jdField_k_of_type_Int = 0;
      if (this.jdField_b_of_type_AndroidWidgetRelativeLayout != null) {
        this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      }
      if (this.jdField_a_of_type_AndroidWidgetRelativeLayout != null)
      {
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
        ((RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetRelativeLayout.getLayoutParams()).bottomMargin = 0;
        this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130847080);
        this.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130847074);
      }
      return;
    }
    if (this.jdField_i_of_type_Int > 0)
    {
      b(this.jdField_i_of_type_Int);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetEditText.setCursorVisible(false);
    this.jdField_e_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
  }
  
  public boolean a(asmu paramasmu)
  {
    return false;
  }
  
  public boolean a(String paramString)
  {
    boolean bool = false;
    if (paramString.length() > 20) {
      return true;
    }
    int i1 = paramString.length();
    int n = 0;
    while (n < i1)
    {
      int i2 = paramString.charAt(n);
      if ((i2 < 48) || (i2 > 57)) {
        bool = true;
      }
      n += 1;
    }
    return bool;
  }
  
  public boolean a(String paramString1, String paramString2)
  {
    if (this.jdField_g_of_type_Int == 1)
    {
      if (TextUtils.isEmpty(paramString2))
      {
        if (TextUtils.isEmpty(paramString1))
        {
          QQToast.a(this, getString(2131692999), 0).b(getTitleBarHeight());
          return false;
        }
        QQToast.a(this, getString(2131693000), 0).b(getTitleBarHeight());
        return false;
      }
    }
    else if ((this.jdField_g_of_type_Int == 2) && (TextUtils.isEmpty(paramString2)) && (!TextUtils.isEmpty(paramString1)))
    {
      QQToast.a(this, getString(2131693002), 0).b(getTitleBarHeight());
      return false;
    }
    return true;
  }
  
  public void b()
  {
    behh.a(this.jdField_a_of_type_AndroidWidgetEditText);
  }
  
  public void b(asmu paramasmu) {}
  
  public void b(boolean paramBoolean)
  {
    if (this.centerView == null) {
      this.centerView = ((TextView)findViewById(2131369088));
    }
    if (paramBoolean)
    {
      this.rightViewText.setEnabled(false);
      if ((this.jdField_a_of_type_JavaLangString != null) && (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null))
      {
        this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = getResources().getDrawable(2130839410);
        this.centerView.setCompoundDrawablesWithIntrinsicBounds(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable, null, null, null);
        ((Animatable)this.jdField_a_of_type_AndroidGraphicsDrawableDrawable).start();
      }
    }
    do
    {
      return;
      this.rightViewText.setEnabled(true);
    } while ((this.jdField_a_of_type_JavaLangString == null) || (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null));
    ((Animatable)this.jdField_a_of_type_AndroidGraphicsDrawableDrawable).stop();
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = null;
    this.centerView.setCompoundDrawables(null, null, null, null);
  }
  
  public void c() {}
  
  public void c(boolean paramBoolean)
  {
    if (paramBoolean) {
      this.app.getPreferences().edit().putString("color_nick_last_edit", "").commit();
    }
    if ((!paramBoolean) && (a(null)) && (this.m) && (!this.jdField_a_of_type_AndroidWidgetEditText.getText().toString().equals(this.jdField_b_of_type_JavaLangString))) {
      this.app.getPreferences().edit().putString("color_nick_last_edit", this.jdField_a_of_type_AndroidWidgetEditText.getText().toString()).commit();
    }
  }
  
  public void d() {}
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool);
    return bool;
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    l();
    f();
    setContentBackgroundResource(2130838778);
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(new EditInfoActivity.1(this), 500L);
    if (this.jdField_g_of_type_Boolean)
    {
      addObserver(this.jdField_a_of_type_Aojs);
      addObserver(this.jdField_a_of_type_Bhzs);
    }
    if (this.jdField_g_of_type_Int == 1) {
      addObserver(this.jdField_a_of_type_Anuw);
    }
    for (;;)
    {
      if (!this.jdField_k_of_type_Boolean) {
        getWindow().setSoftInputMode(3);
      }
      return true;
      if (this.jdField_g_of_type_Int == 2) {
        addObserver(this.jdField_a_of_type_Anyu);
      }
    }
  }
  
  public void e()
  {
    InputMethodManager localInputMethodManager = (InputMethodManager)getSystemService("input_method");
    View localView = getWindow().peekDecorView();
    if ((localView != null) && (localView.getWindowToken() != null)) {
      localInputMethodManager.hideSoftInputFromWindow(localView.getWindowToken(), 0);
    }
  }
  
  void f()
  {
    switch (this.jdField_a_of_type_Int)
    {
    }
    for (;;)
    {
      int n = this.jdField_a_of_type_AndroidWidgetEditText.getText().length();
      Selection.setSelection(this.jdField_a_of_type_AndroidWidgetEditText.getEditableText(), n);
      setTitle(this.jdField_a_of_type_JavaLangString);
      setRightButton(2131692262, new aemn(this));
      if (this.jdField_g_of_type_JavaLangString != null)
      {
        this.rightViewText.setText(this.jdField_g_of_type_JavaLangString);
        this.rightViewText.setContentDescription(getString(2131697102, new Object[] { this.jdField_g_of_type_JavaLangString }));
      }
      if (this.jdField_h_of_type_JavaLangString != null)
      {
        this.leftView.setText(this.jdField_h_of_type_JavaLangString);
        this.leftView.setContentDescription(getString(2131697102, new Object[] { this.jdField_h_of_type_JavaLangString }));
      }
      if (!this.jdField_k_of_type_Boolean) {
        this.rightViewText.setVisibility(8);
      }
      if ((this.jdField_g_of_type_Boolean) && (!this.jdField_k_of_type_Boolean)) {
        this.jdField_a_of_type_AndroidWidgetEditText.setOnClickListener(this);
      }
      if (this.jdField_h_of_type_Boolean) {
        this.jdField_a_of_type_AndroidWidgetEditText.setOnClickListener(this);
      }
      if (this.jdField_i_of_type_JavaLangString != null)
      {
        TextView localTextView = (TextView)findViewById(2131378702);
        if (localTextView != null)
        {
          localTextView.setVisibility(0);
          localTextView.setText(this.jdField_i_of_type_JavaLangString);
          localTextView.setOnClickListener(new aemo(this));
        }
      }
      return;
      g();
      continue;
      i();
      continue;
      h();
    }
  }
  
  protected void g()
  {
    super.setContentView(2131559120);
    j();
    Object localObject = findViewById(2131369947);
    View localView = findViewById(2131369948);
    if ("1103".equals(ThemeUtil.getCurrentThemeInfo().getString("themeId")))
    {
      ((View)localObject).setVisibility(8);
      localView.setVisibility(8);
    }
    if (a()) {
      VasWebviewUtil.reportCommercialDrainage(this.app.c(), "group_nickname", "uv", "", 1, 0, 0, "", "", "");
    }
    if (b())
    {
      this.jdField_a_of_type_ComTencentMobileqqProfileViewSoftInputDetectView = ((SoftInputDetectView)super.findViewById(2131368740));
      this.jdField_a_of_type_ComTencentMobileqqProfileViewSoftInputDetectView.setOnImStateChangedListener(this);
      this.jdField_a_of_type_AndroidWidgetEditText.setEditableFactory(begf.a);
      this.jdField_a_of_type_AndroidWidgetEditText.setOnClickListener(this);
      this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)super.findViewById(2131364708));
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = ((RecyclerView)super.findViewById(2131364693));
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$LayoutManager = new GridLayoutManager(this, 3);
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setLayoutManager(this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$LayoutManager);
      this.jdField_a_of_type_Bhwq = new bhwq(this, this);
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setAdapter(this.jdField_a_of_type_Bhwq);
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.addOnScrollListener(this.jdField_a_of_type_Bhwt);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)super.findViewById(2131364690));
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131364691));
      this.jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(this);
      this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131364694));
      this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
      this.jdField_c_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)super.findViewById(2131364695));
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131364707));
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131364705));
      this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(this);
      this.jdField_d_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)super.findViewById(2131364701));
      this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131364699));
      this.jdField_d_of_type_AndroidWidgetImageView.setOnClickListener(this);
      this.jdField_a_of_type_ComTencentMobileqqWidgetColorNickTextView = ((ColorNickTextView)super.findViewById(2131364702));
      this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131364700));
      this.jdField_d_of_type_AndroidWidgetTextView.setOnClickListener(this);
      this.jdField_e_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)super.findViewById(2131364698));
      d(false);
      a(0);
      localObject = this.app.getPreferences().getString("color_nick_last_edit", "");
      if (TextUtils.isEmpty((CharSequence)localObject))
      {
        this.jdField_d_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
        if (!this.app.getPreferences().getBoolean("color_nick_guide_tips", false))
        {
          this.jdField_e_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
          this.app.getPreferences().edit().putBoolean("color_nick_guide_tips", true).commit();
        }
        if ((this.jdField_a_of_type_AndroidWidgetEditText instanceof ColorClearableEditText)) {
          ((ColorClearableEditText)this.jdField_a_of_type_AndroidWidgetEditText).setTextClearedListener(this);
        }
        this.jdField_a_of_type_AndroidWidgetEditText.setFilters(new InputFilter[] { new aemv(this) });
      }
    }
    while ((!this.jdField_g_of_type_Boolean) || (!a(null))) {
      for (;;)
      {
        return;
        this.jdField_d_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
        localObject = new begb((CharSequence)localObject, 16).a();
        this.jdField_a_of_type_ComTencentMobileqqWidgetColorNickTextView.setText((CharSequence)localObject);
        bhwz.a(this.app, this.jdField_a_of_type_ComTencentMobileqqWidgetColorNickTextView, (Spannable)localObject);
        c(true);
      }
    }
    this.jdField_a_of_type_AndroidWidgetEditText.setText("");
  }
  
  protected void h()
  {
    g();
    if ((this.jdField_a_of_type_AndroidWidgetEditText instanceof ClearableEditText))
    {
      this.jdField_a_of_type_AndroidWidgetEditText.setInputType(131072);
      ((ClearableEditText)this.jdField_a_of_type_AndroidWidgetEditText).setCanMultiLine(true);
      this.jdField_a_of_type_AndroidWidgetEditText.setSingleLine(false);
      aemp localaemp = new aemp(this);
      this.jdField_a_of_type_AndroidWidgetEditText.setFilters(new InputFilter[] { localaemp });
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return true;
      if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.jdField_i_of_type_Boolean = false;
        this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.a(0);
        continue;
        p();
        continue;
        c(false);
        j();
        continue;
        bhwz.a(this.app).jdField_a_of_type_Bhxg.a(this.jdField_b_of_type_JavaUtilArrayList);
        if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel != null) {
          this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.a(this.app, 100001, this, getTitleBarHeight(), null, null, false, bhwz.a(this.app).jdField_a_of_type_Bhxg);
        }
      }
    }
  }
  
  protected void i()
  {
    super.setContentView(2131559119);
    this.jdField_a_of_type_ComTencentMobileqqWidgetInputMethodLinearLayout = ((InputMethodLinearLayout)super.findViewById(2131376925));
    this.jdField_a_of_type_ComTencentMobileqqWidgetInputMethodLinearLayout.setOnSizeChangedListenner(this);
    j();
    if (!this.jdField_i_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidWidgetEditText.getLayoutParams().height = ((int)bhmg.a(this, 149.0F));
      LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqWidgetInputMethodLinearLayout.findViewById(2131365875).getLayoutParams();
      localLayoutParams.height = ((int)bhmg.a(this, 151.0F));
      localLayoutParams.weight = 0.0F;
    }
    this.jdField_a_of_type_AndroidWidgetEditText.setEditableFactory(new aemq(this));
    if (this.jdField_f_of_type_Boolean) {
      k();
    }
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  protected void j()
  {
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)super.findViewById(2131365891));
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)super.findViewById(2131376925));
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
      this.jdField_a_of_type_AndroidWidgetEditText.setContentDescription(this.jdField_a_of_type_JavaLangString);
    }
    if (!TextUtils.isEmpty(this.jdField_d_of_type_JavaLangString)) {
      this.jdField_a_of_type_AndroidWidgetEditText.setHint(this.jdField_d_of_type_JavaLangString);
    }
    if ((this.jdField_b_of_type_JavaLangString != null) && (this.jdField_b_of_type_JavaLangString.length() > 0)) {
      if (b()) {
        this.jdField_a_of_type_AndroidWidgetEditText.setText(this.jdField_b_of_type_JavaLangString);
      }
    }
    for (;;)
    {
      int n;
      try
      {
        if (this.jdField_f_of_type_Int == 0) {
          n = this.jdField_a_of_type_AndroidWidgetEditText.getText().toString().getBytes("utf-8").length;
        }
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException1)
      {
        n = 0;
      }
      try
      {
        this.jdField_c_of_type_JavaLangString = ("" + (this.jdField_c_of_type_Int - n));
        if (this.jdField_d_of_type_Int == 3) {
          break label450;
        }
        if ((!this.jdField_e_of_type_Boolean) || (n > this.jdField_c_of_type_Int)) {
          break label427;
        }
        this.rightViewText.setEnabled(true);
        a(this.jdField_a_of_type_AndroidWidgetEditText);
        if (this.jdField_d_of_type_Boolean) {
          this.jdField_a_of_type_ComTencentMobileqqTroopWidgetEllipsizingTextView = ((EllipsizingTextView)super.findViewById(2131365892));
        }
        if (b())
        {
          this.jdField_a_of_type_AndroidWidgetEditText.setTextColor(getResources().getColor(2131167089));
          p();
        }
        if (!this.jdField_k_of_type_Boolean)
        {
          this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
          this.jdField_a_of_type_AndroidWidgetEditText.clearFocus();
          this.jdField_a_of_type_AndroidWidgetEditText.setFocusable(false);
          this.jdField_a_of_type_AndroidWidgetEditText.setFocusableInTouchMode(false);
          this.jdField_a_of_type_AndroidWidgetEditText.setOnLongClickListener(new aemr(this));
          this.jdField_a_of_type_AndroidWidgetEditText.setLongClickable(false);
          this.jdField_a_of_type_AndroidWidgetEditText.setTextIsSelectable(false);
          this.jdField_a_of_type_AndroidWidgetEditText.setCustomSelectionActionModeCallback(new aems(this));
        }
        return;
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException2)
      {
        label389:
        label427:
        label450:
        break label389;
      }
      if (this.jdField_g_of_type_Boolean)
      {
        this.jdField_a_of_type_AndroidWidgetEditText.setText(bhwz.b(this.jdField_b_of_type_JavaLangString));
      }
      else
      {
        this.jdField_a_of_type_AndroidWidgetEditText.setText(this.jdField_b_of_type_JavaLangString);
        continue;
        n = this.jdField_a_of_type_AndroidWidgetEditText.getText().toString().length();
        continue;
        localUnsupportedEncodingException1.printStackTrace();
        continue;
        this.jdField_c_of_type_JavaLangString = ("" + this.jdField_c_of_type_Int);
        n = 0;
        continue;
        if ((n == 0) || (n > this.jdField_c_of_type_Int))
        {
          this.rightViewText.setEnabled(false);
          continue;
          this.rightViewText.setEnabled(true);
        }
      }
    }
  }
  
  void k()
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)super.findViewById(2131365960));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131378289));
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new aemu(this));
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemAndEmojiUniversalPanel = new assn(this).a(true).a(this).a(this.jdField_a_of_type_AndroidWidgetEditText).a();
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemAndEmojiUniversalPanel.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemAndEmojiUniversalPanel);
    this.jdField_a_of_type_AndroidWidgetEditText.setOnClickListener(new aemd(this));
  }
  
  protected void l()
  {
    Object localObject1 = getIntent();
    Object localObject2 = ((Intent)localObject1).getStringExtra("options");
    if (!TextUtils.isEmpty((CharSequence)localObject2)) {}
    for (;;)
    {
      try
      {
        localObject2 = new JSONObject((String)localObject2);
        this.jdField_a_of_type_JavaLangString = ((JSONObject)localObject2).optString("title");
        this.jdField_b_of_type_JavaLangString = ((JSONObject)localObject2).optString("defaultText");
        this.jdField_e_of_type_JavaLangString = ((JSONObject)localObject2).optString("gc");
        this.jdField_f_of_type_JavaLangString = ((JSONObject)localObject2).optString("uin");
        this.jdField_c_of_type_Int = ((JSONObject)localObject2).optInt("maxLength");
        this.jdField_d_of_type_Int = ((JSONObject)localObject2).optInt("src");
        this.jdField_h_of_type_JavaLangString = anzj.a(2131702531);
        this.jdField_g_of_type_JavaLangString = anzj.a(2131702528);
        this.jdField_g_of_type_Boolean = true;
        this.jdField_h_of_type_Int = 0;
        this.jdField_a_of_type_Int = ((Intent)localObject1).getIntExtra("edit_type", 0);
        this.jdField_b_of_type_Int = ((Intent)localObject1).getIntExtra("edit_subtype", -1);
        this.jdField_e_of_type_Boolean = ((Intent)localObject1).getBooleanExtra("canPostNull", true);
        this.jdField_f_of_type_Boolean = ((Intent)localObject1).getBooleanExtra("support_emotion", false);
        this.jdField_i_of_type_Boolean = ((Intent)localObject1).getBooleanExtra("full_screen", false);
        this.jdField_d_of_type_JavaLangString = ((Intent)localObject1).getStringExtra("default_hint");
        this.jdField_e_of_type_Int = ((Intent)localObject1).getIntExtra("send_type", 0);
        this.jdField_g_of_type_Int = ((Intent)localObject1).getIntExtra("edit_action", 0);
        this.jdField_g_of_type_JavaLangString = ((Intent)localObject1).getStringExtra("right_btn");
        this.jdField_f_of_type_Int = ((Intent)localObject1).getIntExtra("count_type", 0);
        this.jdField_h_of_type_JavaLangString = ((Intent)localObject1).getStringExtra("left_btn");
        this.jdField_i_of_type_JavaLangString = ((Intent)localObject1).getStringExtra("link_text");
        this.jdField_k_of_type_Boolean = ((Intent)localObject1).getBooleanExtra("edit_mode", true);
        this.jdField_c_of_type_Boolean = ((Intent)localObject1).getBooleanExtra("auto_remark", false);
        if ((this.jdField_c_of_type_Boolean) && (this.app != null) && (this.app.getCurrentAccountUin() != null) && (this.jdField_f_of_type_JavaLangString != null) && (!this.app.getCurrentAccountUin().equals(this.jdField_f_of_type_JavaLangString)) && (TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)))
        {
          localObject1 = (aoip)this.app.a(20);
          if (localObject1 != null) {
            ((aoip)localObject1).x(this.jdField_f_of_type_JavaLangString);
          }
          this.jdField_d_of_type_Boolean = true;
        }
        return;
      }
      catch (JSONException localJSONException)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e(".troop.memberCard", 2, "EditInfoActivity.initData optionArgs parse error.", localJSONException);
        continue;
      }
      this.jdField_a_of_type_JavaLangString = ((Intent)localObject1).getStringExtra("title");
      this.jdField_b_of_type_JavaLangString = ((Intent)localObject1).getStringExtra("default_text");
      this.jdField_e_of_type_JavaLangString = ((Intent)localObject1).getStringExtra("troopUin");
      this.jdField_f_of_type_JavaLangString = ((Intent)localObject1).getStringExtra("uin");
      this.jdField_c_of_type_Int = ((Intent)localObject1).getIntExtra("max_num", 0);
      this.jdField_d_of_type_Int = ((Intent)localObject1).getIntExtra("from", -1);
      this.jdField_g_of_type_Boolean = ((Intent)localObject1).getBooleanExtra("isTroopNick", false);
      this.jdField_h_of_type_Boolean = ((Intent)localObject1).getBooleanExtra("isTroopName", false);
      this.jdField_h_of_type_Int = ((Intent)localObject1).getIntExtra("max_limit_mode", 0);
    }
  }
  
  public void m()
  {
    this.jdField_a_of_type_AndroidWidgetEditText.setTextColor(getResources().getColor(2131167089));
    if ((this.jdField_a_of_type_AndroidWidgetEditText instanceof ColorClearableEditText)) {
      ((ColorClearableEditText)this.jdField_a_of_type_AndroidWidgetEditText).setSpecialColor(0, null, null, 0, null);
    }
    this.jdField_a_of_type_Bhwq.a(-1);
    this.jdField_a_of_type_Bhwq.a.a(-1);
  }
  
  public void n() {}
  
  public void o() {}
  
  public boolean onBackEvent()
  {
    VasWebviewUtil.reportCommercialDrainage(this.app.c(), "group_nickname", "group_nickname_8", "", 1, 0, 0, "", "", "");
    e();
    c(false);
    return super.onBackEvent();
  }
  
  public void onClick(View paramView)
  {
    int n = 0;
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (this.jdField_e_of_type_AndroidWidgetRelativeLayout.getVisibility() == 0) {
        this.jdField_e_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      }
      Object localObject = "1";
      if (this.jdField_k_of_type_Int == 2) {
        localObject = "2";
      }
      if (this.l)
      {
        this.jdField_i_of_type_Int = 2;
        e();
      }
      for (;;)
      {
        VasWebviewUtil.reportCommercialDrainage(this.app.c(), "group_nickname", "group_nickname_6", "", 1, 0, 0, "", (String)localObject, "");
        break;
        b(2);
      }
      if (this.jdField_e_of_type_AndroidWidgetRelativeLayout.getVisibility() == 0) {
        this.jdField_e_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      }
      localObject = "1";
      if (this.jdField_k_of_type_Int == 1) {
        localObject = "2";
      }
      if (this.l)
      {
        this.jdField_i_of_type_Int = 1;
        e();
      }
      for (;;)
      {
        VasWebviewUtil.reportCommercialDrainage(this.app.c(), "group_nickname", "group_nickname_5", "", 1, 0, 0, "", (String)localObject, "");
        break;
        b(1);
      }
      bhzu.a(this, "mvip.g.a.qnc_kt", "CJCLUBT", -1, false, true);
      VasWebviewUtil.reportCommercialDrainage(this.app.c(), "group_nickname", "group_nickname_3", "", 1, 0, 0, "", "", "");
      continue;
      this.jdField_d_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      continue;
      localObject = new begb(this.jdField_a_of_type_ComTencentMobileqqWidgetColorNickTextView.getText().toString(), 32).a();
      this.jdField_a_of_type_AndroidWidgetEditText.setText((CharSequence)localObject);
      bhwz.a(this.app, this.jdField_a_of_type_AndroidWidgetEditText, (Spannable)localObject);
      this.jdField_d_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      continue;
      if ((this.jdField_k_of_type_Boolean) || (!this.jdField_h_of_type_Boolean)) {
        continue;
      }
      if (!TextUtils.isEmpty(this.jdField_e_of_type_JavaLangString)) {
        n = 1;
      }
      if (n != 0) {}
      try
      {
        for (localObject = String.format(getString(2131719012), new Object[] { this.jdField_b_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString }); !TextUtils.isEmpty((CharSequence)localObject); localObject = String.format(getString(2131719013), new Object[] { this.jdField_b_of_type_JavaLangString }))
        {
          if (Build.VERSION.SDK_INT >= 11) {
            break label499;
          }
          ((android.text.ClipboardManager)getSystemService("clipboard")).setText((CharSequence)localObject);
          QQToast.a(this, 2131698492, 1).a();
          break;
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          localException.printStackTrace();
          String str = "";
          continue;
          label499:
          ((android.content.ClipboardManager)getSystemService("clipboard")).setText(str);
        }
      }
    }
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.jdField_g_of_type_Boolean)
    {
      removeObserver(this.jdField_a_of_type_Aojs);
      removeObserver(this.jdField_a_of_type_Bhzs);
    }
    if (this.jdField_a_of_type_AndroidOsHandler != null) {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemAndEmojiUniversalPanel != null) {
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemAndEmojiUniversalPanel.b();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel != null) {
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.g();
    }
    this.app.removeObserver(this.jdField_a_of_type_Aogx);
    bhwz.a(this.app).jdField_a_of_type_AndroidOsHandler = null;
    try
    {
      this.jdField_a_of_type_AndroidWidgetEditText.setFocusable(false);
      this.jdField_a_of_type_AndroidWidgetEditText.setFocusableInTouchMode(false);
      this.jdField_a_of_type_AndroidWidgetEditText.setVisibility(8);
      this.jdField_a_of_type_AndroidViewViewGroup.removeView(this.jdField_a_of_type_AndroidWidgetEditText);
      removeObserver(this.jdField_a_of_type_Anuw);
      removeObserver(this.jdField_a_of_type_Anyu);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("EditInfoActivity", 2, "onDestroy" + localException.toString());
        }
      }
    }
  }
  
  public void onPause()
  {
    e();
    super.onPause();
  }
  
  public void onResume()
  {
    if (this.jdField_k_of_type_Boolean) {
      a();
    }
    for (;;)
    {
      super.onResume();
      return;
      e();
    }
  }
  
  public void setting() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.EditInfoActivity
 * JD-Core Version:    0.7.0.1
 */