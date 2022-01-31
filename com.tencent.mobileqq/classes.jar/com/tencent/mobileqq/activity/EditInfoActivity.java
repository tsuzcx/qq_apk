package com.tencent.mobileqq.activity;

import QQService.EVIPSPEC;
import aaqj;
import aaql;
import aaqm;
import aaqn;
import aaqo;
import aaqr;
import aaqs;
import aaqt;
import aaqu;
import aaqv;
import aaqw;
import aaqx;
import aaqy;
import aaqz;
import aara;
import aarc;
import ajfi;
import ajfo;
import ajjh;
import ajjj;
import ajjy;
import ajrm;
import ajrp;
import ajtg;
import ajuc;
import amiu;
import amiv;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
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
import anhs;
import anht;
import anlr;
import anmf;
import aubg;
import axjq;
import axjt;
import axkn;
import axku;
import azvv;
import bacc;
import badq;
import balz;
import bamb;
import bamc;
import bame;
import bamf;
import bami;
import bamo;
import bamp;
import banb;
import baox;
import baoz;
import bbgv;
import bbha;
import bbju;
import bbmy;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.emoticonview.EmoticonMainPanel;
import com.tencent.mobileqq.emoticonview.HorizontalListViewEx;
import com.tencent.mobileqq.emoticonview.SystemAndEmojiEmoticonPanel;
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
import com.tencent.qphone.base.util.QLog;
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
  implements Handler.Callback, View.OnClickListener, anhs, aubg, bame, bbgv, bbju
{
  protected int a;
  private ajfo jdField_a_of_type_Ajfo = new aaql(this);
  private ajjh jdField_a_of_type_Ajjh = new aaqm(this);
  private ajrp jdField_a_of_type_Ajrp = new aaqn(this);
  ajuc jdField_a_of_type_Ajuc = new aaqj(this);
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
  balz jdField_a_of_type_Balz;
  private bamc jdField_a_of_type_Bamc = new aaqr(this);
  private baox jdField_a_of_type_Baox = new aaqo(this);
  EmoticonMainPanel jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel;
  SystemAndEmojiEmoticonPanel jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemAndEmojiEmoticonPanel = null;
  SoftInputDetectView jdField_a_of_type_ComTencentMobileqqProfileViewSoftInputDetectView;
  public EllipsizingTextView a;
  ColorNickTextView jdField_a_of_type_ComTencentMobileqqWidgetColorNickTextView;
  InputMethodLinearLayout jdField_a_of_type_ComTencentMobileqqWidgetInputMethodLinearLayout;
  protected String a;
  private ArrayList<bamb> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  public boolean a;
  private bamb[] jdField_a_of_type_ArrayOfBamb = { new bamb(2, null, 0, null) };
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
    if (a(new aarc(null)))
    {
      localObject1 = ((ColorClearableEditText)this.jdField_a_of_type_AndroidWidgetEditText).a();
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = ((ArrayList)localObject1).iterator();
      if (localIterator.hasNext())
      {
        localObject1 = (bbha)localIterator.next();
        Oidb_0x8fc.RichCardNameElem localRichCardNameElem = new Oidb_0x8fc.RichCardNameElem();
        switch (((bbha)localObject1).jdField_c_of_type_Int)
        {
        }
        for (;;)
        {
          localArrayList.add(localRichCardNameElem);
          break;
          localRichCardNameElem.bytes_text.set(ByteStringMicro.copyFrom(((bbha)localObject1).jdField_a_of_type_JavaLangString.getBytes()));
          continue;
          Object localObject2 = ((bbha)localObject1).jdField_a_of_type_JavaLangString;
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
    this.app.addObserver(this.jdField_a_of_type_Ajrp);
    ((ajrm)this.app.a(13)).e(paramInt);
  }
  
  private boolean a()
  {
    return (this.jdField_g_of_type_Boolean) && (this.jdField_f_of_type_JavaLangString.equals(this.app.getCurrentAccountUin()));
  }
  
  private boolean a(aarc paramaarc)
  {
    boolean bool2 = false;
    if (paramaarc != null)
    {
      paramaarc.jdField_b_of_type_Boolean = false;
      paramaarc.jdField_a_of_type_Boolean = false;
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
      bbha localbbha;
      int n;
      boolean bool3;
      boolean bool4;
      label173:
      if (paramaarc == null) {
        break label244;
      }
    }
    finally
    {
      try
      {
        if (((Iterator)localObject1).hasNext())
        {
          localbbha = (bbha)((Iterator)localObject1).next();
          n = localbbha.jdField_c_of_type_Int;
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
              if (paramaarc != null)
              {
                paramaarc.jdField_b_of_type_Boolean = bool4;
                paramaarc.jdField_a_of_type_Boolean = bool3;
              }
              return true;
              if (localbbha.jdField_c_of_type_Int != 3) {
                break label173;
              }
              bool4 = true;
              bool3 = bool2;
            }
            n = localbbha.jdField_c_of_type_Int;
            bool3 = bool2;
            bool4 = bool1;
          } while (n != 2);
          if (paramaarc != null)
          {
            paramaarc.jdField_b_of_type_Boolean = bool1;
            paramaarc.jdField_a_of_type_Boolean = bool2;
          }
          return true;
        }
        if (paramaarc != null)
        {
          paramaarc.jdField_b_of_type_Boolean = bool1;
          paramaarc.jdField_a_of_type_Boolean = bool2;
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
    paramaarc.jdField_b_of_type_Boolean = bool1;
    paramaarc.jdField_a_of_type_Boolean = bool2;
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
        bami.a(this.app).jdField_a_of_type_AndroidOsHandler = this.jdField_a_of_type_AndroidOsHandler;
        this.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130845976);
        this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130845981);
        this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
        this.jdField_c_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
        this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setVisibility(8);
        ((RelativeLayout.LayoutParams)this.jdField_b_of_type_AndroidWidgetRelativeLayout.getLayoutParams()).height = azvv.a(this, 387.0F);
        ((RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetRelativeLayout.getLayoutParams()).bottomMargin = azvv.a(this, 387.0F);
        if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel == null)
        {
          this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel = ((EmoticonMainPanel)View.inflate(getBaseContext(), 2131493455, null));
          this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.setCallBack(this);
          this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.jdField_c_of_type_Boolean = true;
          this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.jdField_f_of_type_Boolean = true;
          this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.jdField_a_of_type_Boolean = false;
          this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.jdField_b_of_type_Boolean = true;
          this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.jdField_e_of_type_Boolean = true;
          this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.a(this.app, 100001, this, getTitleBarHeight(), null, null, false, bami.a(this.app).jdField_a_of_type_Bamp);
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
            bami.a(this.app).jdField_a_of_type_AndroidOsHandler = this.jdField_a_of_type_AndroidOsHandler;
            this.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130845975);
            this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130845982);
            this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
            this.jdField_c_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
            this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setVisibility(0);
            ((RelativeLayout.LayoutParams)this.jdField_b_of_type_AndroidWidgetRelativeLayout.getLayoutParams()).height = azvv.a(this, 388.0F);
            ((RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetRelativeLayout.getLayoutParams()).bottomMargin = azvv.a(this, 388.0F);
          }
        }
      }
    }
  }
  
  private boolean b()
  {
    amiu localamiu = amiv.c();
    if (localamiu == null) {
      return a();
    }
    return (localamiu.jdField_a_of_type_Boolean) && (a());
  }
  
  private void d(boolean paramBoolean)
  {
    Object localObject = new ArrayList();
    Collections.addAll((Collection)localObject, this.jdField_a_of_type_ArrayOfBamb);
    ((ArrayList)localObject).addAll(this.jdField_a_of_type_JavaUtilArrayList);
    this.jdField_a_of_type_Balz.a((List)localObject, paramBoolean);
    localObject = ((ajjj)this.app.getManager(51)).e(this.jdField_f_of_type_JavaLangString);
    if (localObject != null)
    {
      if (((Friends)localObject).isServiceEnabled(EVIPSPEC.E_SP_SUPERVIP))
      {
        this.jdField_b_of_type_AndroidWidgetTextView.setText(getString(2131625285));
        this.jdField_c_of_type_AndroidWidgetTextView.setText(getString(2131625286));
      }
    }
    else {
      return;
    }
    this.jdField_b_of_type_AndroidWidgetTextView.setText(getString(2131625283));
    this.jdField_c_of_type_AndroidWidgetTextView.setText(getString(2131625284));
  }
  
  private void p()
  {
    SpannableString localSpannableString = new axjq(this.jdField_a_of_type_AndroidWidgetEditText.getText().toString(), 32).a();
    bami.a(this.app, this.jdField_a_of_type_AndroidWidgetEditText, localSpannableString);
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
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131299949));
    this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_c_of_type_JavaLangString);
    paramEditText.addTextChangedListener(new aaqx(this, paramEditText));
  }
  
  public void a(anht paramanht)
  {
    if ((this.jdField_a_of_type_AndroidWidgetEditText instanceof ColorClearableEditText))
    {
      this.m = true;
      if ((paramanht instanceof anmf))
      {
        paramanht = (anmf)paramanht;
        if (paramanht.jdField_b_of_type_Int != -1) {}
      }
      while (!(paramanht instanceof anlr))
      {
        return;
        int n = this.jdField_a_of_type_AndroidWidgetEditText.getSelectionStart();
        int i1 = this.jdField_a_of_type_AndroidWidgetEditText.getSelectionEnd();
        this.jdField_a_of_type_AndroidWidgetEditText.getEditableText().replace(n, i1, axku.d(paramanht.jdField_b_of_type_Int));
        this.jdField_a_of_type_AndroidWidgetEditText.requestFocus();
        return;
      }
      bami.a((anlr)paramanht, this.app, this.jdField_a_of_type_AndroidWidgetEditText);
      return;
    }
    paramanht.a(this.app, this, this.jdField_a_of_type_AndroidWidgetEditText, null);
  }
  
  public void a(anht paramanht1, anht paramanht2, Drawable paramDrawable) {}
  
  public void a(bamb parambamb)
  {
    ColorClearableEditText localColorClearableEditText;
    String str;
    int i1;
    int n;
    if ((this.jdField_a_of_type_AndroidWidgetEditText instanceof ColorClearableEditText))
    {
      this.m = true;
      localColorClearableEditText = (ColorClearableEditText)this.jdField_a_of_type_AndroidWidgetEditText;
      str = bami.a(parambamb);
      banb[] arrayOfbanb = (banb[])this.jdField_a_of_type_AndroidWidgetEditText.getEditableText().getSpans(0, this.jdField_a_of_type_AndroidWidgetEditText.getEditableText().length(), banb.class);
      if ((arrayOfbanb == null) || (arrayOfbanb.length <= 0)) {
        break label274;
      }
      i1 = this.jdField_a_of_type_AndroidWidgetEditText.getEditableText().getSpanStart(arrayOfbanb[0]);
      n = this.jdField_a_of_type_AndroidWidgetEditText.getEditableText().getSpanEnd(arrayOfbanb[0]);
      this.jdField_a_of_type_AndroidWidgetEditText.getEditableText().removeSpan(arrayOfbanb[0]);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetEditText.getEditableText().replace(i1, n, str);
      switch (parambamb.jdField_a_of_type_Int)
      {
      }
      do
      {
        return;
        if (parambamb.jdField_b_of_type_Int != 0) {
          localColorClearableEditText.setTextColor(parambamb.jdField_b_of_type_Int);
        }
        for (;;)
        {
          localColorClearableEditText.setSpecialColor(0, null, null, 0, null);
          return;
          localColorClearableEditText.setTextColor(getResources().getColor(2131101351));
        }
        localColorClearableEditText.setTextColor(getResources().getColor(2131101351));
        parambamb = bami.a(this.app).a(parambamb.jdField_b_of_type_Int);
      } while (parambamb == null);
      localColorClearableEditText.setSpecialColor(parambamb.jdField_a_of_type_Int, parambamb.jdField_a_of_type_ArrayOfInt, parambamb.jdField_a_of_type_ArrayOfFloat, parambamb.jdField_b_of_type_Int, parambamb.jdField_a_of_type_AndroidGraphicsBitmap);
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
        if (!badq.d(this.app.getApplication().getApplicationContext()))
        {
          bbmy.a(this, 1, 2131628948, 0).b(getTitleBarHeight());
          return;
        }
        if (QLog.isColorLevel()) {
          QLog.d("EditInfoActivity", 2, String.format("edit self nick, uin: %s, result: %s", new Object[] { this.jdField_f_of_type_JavaLangString, paramString }));
        }
      } while ((TextUtils.isEmpty(paramString.trim())) || (!this.jdField_f_of_type_JavaLangString.equals(this.app.getCurrentAccountUin())));
      b(true);
      localObject = new Bundle();
      ((Bundle)localObject).putString("nick", paramString.trim());
      ((ajfi)this.app.a(2)).a((Bundle)localObject);
      this.jdField_j_of_type_Boolean = true;
      return;
    }
    if (!badq.d(this.app.getApplication().getApplicationContext()))
    {
      bbmy.a(this, 1, 2131628948, 0).b(getTitleBarHeight());
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
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130846792);
      this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(ajjy.a(2131637843));
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
        this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130845982);
        this.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130845976);
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
  
  public boolean a(anht paramanht)
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
          bbmy.a(this, getString(2131627808), 0).b(getTitleBarHeight());
          return false;
        }
        bbmy.a(this, getString(2131627809), 0).b(getTitleBarHeight());
        return false;
      }
    }
    else if ((this.jdField_g_of_type_Int == 2) && (TextUtils.isEmpty(paramString2)) && (!TextUtils.isEmpty(paramString1)))
    {
      bbmy.a(this, getString(2131627811), 0).b(getTitleBarHeight());
      return false;
    }
    return true;
  }
  
  public void b()
  {
    axku.a(this.jdField_a_of_type_AndroidWidgetEditText);
  }
  
  public void b(anht paramanht) {}
  
  public void b(boolean paramBoolean)
  {
    if (this.centerView == null) {
      this.centerView = ((TextView)findViewById(2131302847));
    }
    if (paramBoolean)
    {
      this.rightViewText.setEnabled(false);
      if ((this.jdField_a_of_type_JavaLangString != null) && (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null))
      {
        this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = getResources().getDrawable(2130839113);
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
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    l();
    f();
    setContentBackgroundResource(2130838503);
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(new EditInfoActivity.1(this), 500L);
    if (this.jdField_g_of_type_Boolean)
    {
      addObserver(this.jdField_a_of_type_Ajuc);
      addObserver(this.jdField_a_of_type_Baox);
    }
    if (this.jdField_g_of_type_Int == 1) {
      addObserver(this.jdField_a_of_type_Ajfo);
    }
    for (;;)
    {
      if (!this.jdField_k_of_type_Boolean) {
        getWindow().setSoftInputMode(3);
      }
      return true;
      if (this.jdField_g_of_type_Int == 2) {
        addObserver(this.jdField_a_of_type_Ajjh);
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
      setRightButton(2131626982, new aaqs(this));
      if (this.jdField_g_of_type_JavaLangString != null)
      {
        this.rightViewText.setText(this.jdField_g_of_type_JavaLangString);
        this.rightViewText.setContentDescription(getString(2131632288, new Object[] { this.jdField_g_of_type_JavaLangString }));
      }
      if (this.jdField_h_of_type_JavaLangString != null)
      {
        this.leftView.setText(this.jdField_h_of_type_JavaLangString);
        this.leftView.setContentDescription(getString(2131632288, new Object[] { this.jdField_h_of_type_JavaLangString }));
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
        TextView localTextView = (TextView)findViewById(2131311314);
        if (localTextView != null)
        {
          localTextView.setVisibility(0);
          localTextView.setText(this.jdField_i_of_type_JavaLangString);
          localTextView.setOnClickListener(new aaqt(this));
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
    super.setContentView(2131493452);
    j();
    Object localObject = findViewById(2131303534);
    View localView = findViewById(2131303535);
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
      this.jdField_a_of_type_ComTencentMobileqqProfileViewSoftInputDetectView = ((SoftInputDetectView)super.findViewById(2131302580));
      this.jdField_a_of_type_ComTencentMobileqqProfileViewSoftInputDetectView.setOnImStateChangedListener(this);
      this.jdField_a_of_type_AndroidWidgetEditText.setEditableFactory(axjt.a);
      this.jdField_a_of_type_AndroidWidgetEditText.setOnClickListener(this);
      this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)super.findViewById(2131298827));
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = ((RecyclerView)super.findViewById(2131298812));
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$LayoutManager = new GridLayoutManager(this, 3);
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setLayoutManager(this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$LayoutManager);
      this.jdField_a_of_type_Balz = new balz(this, this);
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setAdapter(this.jdField_a_of_type_Balz);
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.addOnScrollListener(this.jdField_a_of_type_Bamc);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)super.findViewById(2131298809));
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131298810));
      this.jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(this);
      this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131298813));
      this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
      this.jdField_c_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)super.findViewById(2131298814));
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131298826));
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131298824));
      this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(this);
      this.jdField_d_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)super.findViewById(2131298820));
      this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131298818));
      this.jdField_d_of_type_AndroidWidgetImageView.setOnClickListener(this);
      this.jdField_a_of_type_ComTencentMobileqqWidgetColorNickTextView = ((ColorNickTextView)super.findViewById(2131298821));
      this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131298819));
      this.jdField_d_of_type_AndroidWidgetTextView.setOnClickListener(this);
      this.jdField_e_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)super.findViewById(2131298817));
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
        this.jdField_a_of_type_AndroidWidgetEditText.setFilters(new InputFilter[] { new aara(this) });
      }
    }
    while ((!this.jdField_g_of_type_Boolean) || (!a(null))) {
      for (;;)
      {
        return;
        this.jdField_d_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
        localObject = new axjq((CharSequence)localObject, 16).a();
        this.jdField_a_of_type_ComTencentMobileqqWidgetColorNickTextView.setText((CharSequence)localObject);
        bami.a(this.app, this.jdField_a_of_type_ComTencentMobileqqWidgetColorNickTextView, (Spannable)localObject);
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
      aaqu localaaqu = new aaqu(this);
      this.jdField_a_of_type_AndroidWidgetEditText.setFilters(new InputFilter[] { localaaqu });
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
        this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.jdField_k_of_type_Boolean = false;
        this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.d(0);
        continue;
        p();
        continue;
        c(false);
        j();
        continue;
        bami.a(this.app).jdField_a_of_type_Bamp.a(this.jdField_b_of_type_JavaUtilArrayList);
        if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel != null) {
          this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.a(this.app, 100001, this, getTitleBarHeight(), null, null, false, bami.a(this.app).jdField_a_of_type_Bamp);
        }
      }
    }
  }
  
  protected void i()
  {
    super.setContentView(2131493451);
    this.jdField_a_of_type_ComTencentMobileqqWidgetInputMethodLinearLayout = ((InputMethodLinearLayout)super.findViewById(2131309736));
    this.jdField_a_of_type_ComTencentMobileqqWidgetInputMethodLinearLayout.setOnSizeChangedListenner(this);
    j();
    if (!this.jdField_i_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidWidgetEditText.getLayoutParams().height = ((int)bacc.a(this, 149.0F));
      LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqWidgetInputMethodLinearLayout.findViewById(2131299932).getLayoutParams();
      localLayoutParams.height = ((int)bacc.a(this, 151.0F));
      localLayoutParams.weight = 0.0F;
    }
    this.jdField_a_of_type_AndroidWidgetEditText.setEditableFactory(axkn.a);
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
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)super.findViewById(2131299947));
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)super.findViewById(2131309736));
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
          this.jdField_a_of_type_ComTencentMobileqqTroopWidgetEllipsizingTextView = ((EllipsizingTextView)super.findViewById(2131299948));
        }
        if (b())
        {
          this.jdField_a_of_type_AndroidWidgetEditText.setTextColor(getResources().getColor(2131101351));
          p();
        }
        if (!this.jdField_k_of_type_Boolean)
        {
          this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
          this.jdField_a_of_type_AndroidWidgetEditText.clearFocus();
          this.jdField_a_of_type_AndroidWidgetEditText.setFocusable(false);
          this.jdField_a_of_type_AndroidWidgetEditText.setFocusableInTouchMode(false);
          this.jdField_a_of_type_AndroidWidgetEditText.setOnLongClickListener(new aaqv(this));
          this.jdField_a_of_type_AndroidWidgetEditText.setLongClickable(false);
          this.jdField_a_of_type_AndroidWidgetEditText.setTextIsSelectable(false);
          this.jdField_a_of_type_AndroidWidgetEditText.setCustomSelectionActionModeCallback(new aaqw(this));
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
        this.jdField_a_of_type_AndroidWidgetEditText.setText(bami.b(this.jdField_b_of_type_JavaLangString));
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
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)super.findViewById(2131300013));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131310944));
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new aaqy(this));
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemAndEmojiEmoticonPanel = new SystemAndEmojiEmoticonPanel(this, this);
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemAndEmojiEmoticonPanel.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemAndEmojiEmoticonPanel);
    this.jdField_a_of_type_AndroidWidgetEditText.setOnClickListener(new aaqz(this));
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
        this.jdField_h_of_type_JavaLangString = ajjy.a(2131637847);
        this.jdField_g_of_type_JavaLangString = ajjy.a(2131637844);
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
          localObject1 = (ajtg)this.app.a(20);
          if (localObject1 != null) {
            ((ajtg)localObject1).x(this.jdField_f_of_type_JavaLangString);
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
    this.jdField_a_of_type_AndroidWidgetEditText.setTextColor(getResources().getColor(2131101351));
    if ((this.jdField_a_of_type_AndroidWidgetEditText instanceof ColorClearableEditText)) {
      ((ColorClearableEditText)this.jdField_a_of_type_AndroidWidgetEditText).setSpecialColor(0, null, null, 0, null);
    }
    this.jdField_a_of_type_Balz.a(-1);
    this.jdField_a_of_type_Balz.a.a(-1);
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
      return;
      if (this.jdField_e_of_type_AndroidWidgetRelativeLayout.getVisibility() == 0) {
        this.jdField_e_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      }
      paramView = "1";
      if (this.jdField_k_of_type_Int == 2) {
        paramView = "2";
      }
      if (this.l)
      {
        this.jdField_i_of_type_Int = 2;
        e();
      }
      for (;;)
      {
        VasWebviewUtil.reportCommercialDrainage(this.app.c(), "group_nickname", "group_nickname_6", "", 1, 0, 0, "", paramView, "");
        return;
        b(2);
      }
      if (this.jdField_e_of_type_AndroidWidgetRelativeLayout.getVisibility() == 0) {
        this.jdField_e_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      }
      paramView = "1";
      if (this.jdField_k_of_type_Int == 1) {
        paramView = "2";
      }
      if (this.l)
      {
        this.jdField_i_of_type_Int = 1;
        e();
      }
      for (;;)
      {
        VasWebviewUtil.reportCommercialDrainage(this.app.c(), "group_nickname", "group_nickname_5", "", 1, 0, 0, "", paramView, "");
        return;
        b(1);
      }
      baoz.a(this, "mvip.g.a.qnc_kt", "CJCLUBT", -1, false, true);
      VasWebviewUtil.reportCommercialDrainage(this.app.c(), "group_nickname", "group_nickname_3", "", 1, 0, 0, "", "", "");
      return;
      this.jdField_d_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      return;
      paramView = new axjq(this.jdField_a_of_type_ComTencentMobileqqWidgetColorNickTextView.getText().toString(), 32).a();
      this.jdField_a_of_type_AndroidWidgetEditText.setText(paramView);
      bami.a(this.app, this.jdField_a_of_type_AndroidWidgetEditText, paramView);
      this.jdField_d_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      return;
      if ((this.jdField_k_of_type_Boolean) || (!this.jdField_h_of_type_Boolean)) {
        continue;
      }
      if (!TextUtils.isEmpty(this.jdField_e_of_type_JavaLangString)) {
        n = 1;
      }
      if (n != 0) {}
      try
      {
        for (paramView = String.format(getString(2131654661), new Object[] { this.jdField_b_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString }); !TextUtils.isEmpty(paramView); paramView = String.format(getString(2131654662), new Object[] { this.jdField_b_of_type_JavaLangString }))
        {
          if (Build.VERSION.SDK_INT >= 11) {
            break label480;
          }
          ((android.text.ClipboardManager)getSystemService("clipboard")).setText(paramView);
          bbmy.a(this, 2131633802, 1).a();
          return;
        }
      }
      catch (Exception paramView)
      {
        for (;;)
        {
          paramView.printStackTrace();
          paramView = "";
          continue;
          label480:
          ((android.content.ClipboardManager)getSystemService("clipboard")).setText(paramView);
        }
      }
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.jdField_g_of_type_Boolean)
    {
      removeObserver(this.jdField_a_of_type_Ajuc);
      removeObserver(this.jdField_a_of_type_Baox);
    }
    if (this.jdField_a_of_type_AndroidOsHandler != null) {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemAndEmojiEmoticonPanel != null) {
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemAndEmojiEmoticonPanel.a();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel != null) {
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.i();
    }
    this.app.removeObserver(this.jdField_a_of_type_Ajrp);
    bami.a(this.app).jdField_a_of_type_AndroidOsHandler = null;
    try
    {
      this.jdField_a_of_type_AndroidWidgetEditText.setFocusable(false);
      this.jdField_a_of_type_AndroidWidgetEditText.setFocusableInTouchMode(false);
      this.jdField_a_of_type_AndroidWidgetEditText.setVisibility(8);
      this.jdField_a_of_type_AndroidViewViewGroup.removeView(this.jdField_a_of_type_AndroidWidgetEditText);
      removeObserver(this.jdField_a_of_type_Ajfo);
      removeObserver(this.jdField_a_of_type_Ajjh);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.EditInfoActivity
 * JD-Core Version:    0.7.0.1
 */