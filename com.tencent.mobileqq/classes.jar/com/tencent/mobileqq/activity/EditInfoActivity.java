package com.tencent.mobileqq.activity;

import QQService.EVIPSPEC;
import aazx;
import aazz;
import abaa;
import abab;
import abac;
import abaf;
import abag;
import abah;
import abai;
import abaj;
import abak;
import abal;
import abam;
import aban;
import abao;
import abaq;
import ajti;
import ajto;
import ajxj;
import ajxl;
import ajya;
import akfv;
import akfy;
import akhp;
import akil;
import amzf;
import amzg;
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
import anyg;
import anyh;
import aocg;
import aocu;
import avao;
import ayjw;
import ayka;
import ayku;
import aylc;
import baxn;
import bbdv;
import bbfj;
import bboj;
import bbol;
import bbom;
import bboo;
import bbop;
import bbos;
import bboy;
import bboz;
import bbpl;
import bbri;
import bbrk;
import bckk;
import bckp;
import bcnh;
import bcql;
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
  implements Handler.Callback, View.OnClickListener, anyg, avao, bboo, bckk, bcnh
{
  protected int a;
  private ajto jdField_a_of_type_Ajto = new aazz(this);
  private ajxj jdField_a_of_type_Ajxj = new abaa(this);
  private akfy jdField_a_of_type_Akfy = new abab(this);
  akil jdField_a_of_type_Akil = new aazx(this);
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
  bboj jdField_a_of_type_Bboj;
  private bbom jdField_a_of_type_Bbom = new abaf(this);
  private bbri jdField_a_of_type_Bbri = new abac(this);
  EmoticonMainPanel jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel;
  SystemAndEmojiEmoticonPanel jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemAndEmojiEmoticonPanel = null;
  SoftInputDetectView jdField_a_of_type_ComTencentMobileqqProfileViewSoftInputDetectView;
  public EllipsizingTextView a;
  ColorNickTextView jdField_a_of_type_ComTencentMobileqqWidgetColorNickTextView;
  InputMethodLinearLayout jdField_a_of_type_ComTencentMobileqqWidgetInputMethodLinearLayout;
  protected String a;
  private ArrayList<bbol> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  public boolean a;
  private bbol[] jdField_a_of_type_ArrayOfBbol = { new bbol(2, null, 0, null) };
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
    if (a(new abaq(null)))
    {
      localObject1 = ((ColorClearableEditText)this.jdField_a_of_type_AndroidWidgetEditText).a();
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = ((ArrayList)localObject1).iterator();
      if (localIterator.hasNext())
      {
        localObject1 = (bckp)localIterator.next();
        Oidb_0x8fc.RichCardNameElem localRichCardNameElem = new Oidb_0x8fc.RichCardNameElem();
        switch (((bckp)localObject1).jdField_c_of_type_Int)
        {
        }
        for (;;)
        {
          localArrayList.add(localRichCardNameElem);
          break;
          localRichCardNameElem.bytes_text.set(ByteStringMicro.copyFrom(((bckp)localObject1).jdField_a_of_type_JavaLangString.getBytes()));
          continue;
          Object localObject2 = ((bckp)localObject1).jdField_a_of_type_JavaLangString;
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
    this.app.addObserver(this.jdField_a_of_type_Akfy);
    ((akfv)this.app.a(13)).e(paramInt);
  }
  
  private boolean a()
  {
    return (this.jdField_g_of_type_Boolean) && (this.jdField_f_of_type_JavaLangString.equals(this.app.getCurrentAccountUin()));
  }
  
  private boolean a(abaq paramabaq)
  {
    boolean bool2 = false;
    if (paramabaq != null)
    {
      paramabaq.jdField_b_of_type_Boolean = false;
      paramabaq.jdField_a_of_type_Boolean = false;
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
      bckp localbckp;
      int n;
      boolean bool3;
      boolean bool4;
      label173:
      if (paramabaq == null) {
        break label244;
      }
    }
    finally
    {
      try
      {
        if (((Iterator)localObject1).hasNext())
        {
          localbckp = (bckp)((Iterator)localObject1).next();
          n = localbckp.jdField_c_of_type_Int;
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
              if (paramabaq != null)
              {
                paramabaq.jdField_b_of_type_Boolean = bool4;
                paramabaq.jdField_a_of_type_Boolean = bool3;
              }
              return true;
              if (localbckp.jdField_c_of_type_Int != 3) {
                break label173;
              }
              bool4 = true;
              bool3 = bool2;
            }
            n = localbckp.jdField_c_of_type_Int;
            bool3 = bool2;
            bool4 = bool1;
          } while (n != 2);
          if (paramabaq != null)
          {
            paramabaq.jdField_b_of_type_Boolean = bool1;
            paramabaq.jdField_a_of_type_Boolean = bool2;
          }
          return true;
        }
        if (paramabaq != null)
        {
          paramabaq.jdField_b_of_type_Boolean = bool1;
          paramabaq.jdField_a_of_type_Boolean = bool2;
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
    paramabaq.jdField_b_of_type_Boolean = bool1;
    paramabaq.jdField_a_of_type_Boolean = bool2;
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
        bbos.a(this.app).jdField_a_of_type_AndroidOsHandler = this.jdField_a_of_type_AndroidOsHandler;
        this.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130846163);
        this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130846168);
        this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
        this.jdField_c_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
        this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setVisibility(8);
        ((RelativeLayout.LayoutParams)this.jdField_b_of_type_AndroidWidgetRelativeLayout.getLayoutParams()).height = baxn.a(this, 387.0F);
        ((RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetRelativeLayout.getLayoutParams()).bottomMargin = baxn.a(this, 387.0F);
        if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel == null)
        {
          this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel = ((EmoticonMainPanel)View.inflate(getBaseContext(), 2131559018, null));
          this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.setCallBack(this);
          this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.jdField_c_of_type_Boolean = true;
          this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.jdField_f_of_type_Boolean = true;
          this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.jdField_a_of_type_Boolean = false;
          this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.jdField_b_of_type_Boolean = true;
          this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.jdField_e_of_type_Boolean = true;
          this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.a(this.app, 100001, this, getTitleBarHeight(), null, null, false, bbos.a(this.app).jdField_a_of_type_Bboz);
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
            bbos.a(this.app).jdField_a_of_type_AndroidOsHandler = this.jdField_a_of_type_AndroidOsHandler;
            this.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130846162);
            this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130846169);
            this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
            this.jdField_c_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
            this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setVisibility(0);
            ((RelativeLayout.LayoutParams)this.jdField_b_of_type_AndroidWidgetRelativeLayout.getLayoutParams()).height = baxn.a(this, 388.0F);
            ((RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetRelativeLayout.getLayoutParams()).bottomMargin = baxn.a(this, 388.0F);
          }
        }
      }
    }
  }
  
  private boolean b()
  {
    amzf localamzf = amzg.c();
    if (localamzf == null) {
      return a();
    }
    return (localamzf.jdField_a_of_type_Boolean) && (a());
  }
  
  private void d(boolean paramBoolean)
  {
    Object localObject = new ArrayList();
    Collections.addAll((Collection)localObject, this.jdField_a_of_type_ArrayOfBbol);
    ((ArrayList)localObject).addAll(this.jdField_a_of_type_JavaUtilArrayList);
    this.jdField_a_of_type_Bboj.a((List)localObject, paramBoolean);
    localObject = ((ajxl)this.app.getManager(51)).e(this.jdField_f_of_type_JavaLangString);
    if (localObject != null)
    {
      if (((Friends)localObject).isServiceEnabled(EVIPSPEC.E_SP_SUPERVIP))
      {
        this.jdField_b_of_type_AndroidWidgetTextView.setText(getString(2131690848));
        this.jdField_c_of_type_AndroidWidgetTextView.setText(getString(2131690849));
      }
    }
    else {
      return;
    }
    this.jdField_b_of_type_AndroidWidgetTextView.setText(getString(2131690846));
    this.jdField_c_of_type_AndroidWidgetTextView.setText(getString(2131690847));
  }
  
  private void p()
  {
    SpannableString localSpannableString = new ayjw(this.jdField_a_of_type_AndroidWidgetEditText.getText().toString(), 32).a();
    bbos.a(this.app, this.jdField_a_of_type_AndroidWidgetEditText, localSpannableString);
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
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131365528));
    this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_c_of_type_JavaLangString);
    paramEditText.addTextChangedListener(new abal(this, paramEditText));
  }
  
  public void a(anyh paramanyh)
  {
    if ((this.jdField_a_of_type_AndroidWidgetEditText instanceof ColorClearableEditText))
    {
      this.m = true;
      if ((paramanyh instanceof aocu))
      {
        paramanyh = (aocu)paramanyh;
        if (paramanyh.jdField_b_of_type_Int != -1) {}
      }
      while (!(paramanyh instanceof aocg))
      {
        return;
        int n = this.jdField_a_of_type_AndroidWidgetEditText.getSelectionStart();
        int i1 = this.jdField_a_of_type_AndroidWidgetEditText.getSelectionEnd();
        this.jdField_a_of_type_AndroidWidgetEditText.getEditableText().replace(n, i1, aylc.d(paramanyh.jdField_b_of_type_Int));
        this.jdField_a_of_type_AndroidWidgetEditText.requestFocus();
        return;
      }
      bbos.a((aocg)paramanyh, this.app, this.jdField_a_of_type_AndroidWidgetEditText);
      return;
    }
    paramanyh.a(this.app, this, this.jdField_a_of_type_AndroidWidgetEditText, null);
  }
  
  public void a(anyh paramanyh1, anyh paramanyh2, Drawable paramDrawable) {}
  
  public void a(bbol parambbol)
  {
    ColorClearableEditText localColorClearableEditText;
    String str;
    int i1;
    int n;
    if ((this.jdField_a_of_type_AndroidWidgetEditText instanceof ColorClearableEditText))
    {
      this.m = true;
      localColorClearableEditText = (ColorClearableEditText)this.jdField_a_of_type_AndroidWidgetEditText;
      str = bbos.a(parambbol);
      bbpl[] arrayOfbbpl = (bbpl[])this.jdField_a_of_type_AndroidWidgetEditText.getEditableText().getSpans(0, this.jdField_a_of_type_AndroidWidgetEditText.getEditableText().length(), bbpl.class);
      if ((arrayOfbbpl == null) || (arrayOfbbpl.length <= 0)) {
        break label274;
      }
      i1 = this.jdField_a_of_type_AndroidWidgetEditText.getEditableText().getSpanStart(arrayOfbbpl[0]);
      n = this.jdField_a_of_type_AndroidWidgetEditText.getEditableText().getSpanEnd(arrayOfbbpl[0]);
      this.jdField_a_of_type_AndroidWidgetEditText.getEditableText().removeSpan(arrayOfbbpl[0]);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetEditText.getEditableText().replace(i1, n, str);
      switch (parambbol.jdField_a_of_type_Int)
      {
      }
      do
      {
        return;
        if (parambbol.jdField_b_of_type_Int != 0) {
          localColorClearableEditText.setTextColor(parambbol.jdField_b_of_type_Int);
        }
        for (;;)
        {
          localColorClearableEditText.setSpecialColor(0, null, null, 0, null);
          return;
          localColorClearableEditText.setTextColor(getResources().getColor(2131166946));
        }
        localColorClearableEditText.setTextColor(getResources().getColor(2131166946));
        parambbol = bbos.a(this.app).a(parambbol.jdField_b_of_type_Int);
      } while (parambbol == null);
      localColorClearableEditText.setSpecialColor(parambbol.jdField_a_of_type_Int, parambbol.jdField_a_of_type_ArrayOfInt, parambbol.jdField_a_of_type_ArrayOfFloat, parambbol.jdField_b_of_type_Int, parambbol.jdField_a_of_type_AndroidGraphicsBitmap);
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
        if (!bbfj.d(this.app.getApplication().getApplicationContext()))
        {
          bcql.a(this, 1, 2131694610, 0).b(getTitleBarHeight());
          return;
        }
        if (QLog.isColorLevel()) {
          QLog.d("EditInfoActivity", 2, String.format("edit self nick, uin: %s, result: %s", new Object[] { this.jdField_f_of_type_JavaLangString, paramString }));
        }
      } while ((TextUtils.isEmpty(paramString.trim())) || (!this.jdField_f_of_type_JavaLangString.equals(this.app.getCurrentAccountUin())));
      b(true);
      localObject = new Bundle();
      ((Bundle)localObject).putString("nick", paramString.trim());
      ((ajti)this.app.a(2)).a((Bundle)localObject);
      this.jdField_j_of_type_Boolean = true;
      return;
    }
    if (!bbfj.d(this.app.getApplication().getApplicationContext()))
    {
      bcql.a(this, 1, 2131694610, 0).b(getTitleBarHeight());
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
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130846988);
      this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(ajya.a(2131703639));
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
        this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130846169);
        this.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130846163);
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
  
  public boolean a(anyh paramanyh)
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
          bcql.a(this, getString(2131693450), 0).b(getTitleBarHeight());
          return false;
        }
        bcql.a(this, getString(2131693451), 0).b(getTitleBarHeight());
        return false;
      }
    }
    else if ((this.jdField_g_of_type_Int == 2) && (TextUtils.isEmpty(paramString2)) && (!TextUtils.isEmpty(paramString1)))
    {
      bcql.a(this, getString(2131693453), 0).b(getTitleBarHeight());
      return false;
    }
    return true;
  }
  
  public void b()
  {
    aylc.a(this.jdField_a_of_type_AndroidWidgetEditText);
  }
  
  public void b(anyh paramanyh) {}
  
  public void b(boolean paramBoolean)
  {
    if (this.centerView == null) {
      this.centerView = ((TextView)findViewById(2131368472));
    }
    if (paramBoolean)
    {
      this.rightViewText.setEnabled(false);
      if ((this.jdField_a_of_type_JavaLangString != null) && (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null))
      {
        this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = getResources().getDrawable(2130839140);
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
    setContentBackgroundResource(2130838514);
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(new EditInfoActivity.1(this), 500L);
    if (this.jdField_g_of_type_Boolean)
    {
      addObserver(this.jdField_a_of_type_Akil);
      addObserver(this.jdField_a_of_type_Bbri);
    }
    if (this.jdField_g_of_type_Int == 1) {
      addObserver(this.jdField_a_of_type_Ajto);
    }
    for (;;)
    {
      if (!this.jdField_k_of_type_Boolean) {
        getWindow().setSoftInputMode(3);
      }
      return true;
      if (this.jdField_g_of_type_Int == 2) {
        addObserver(this.jdField_a_of_type_Ajxj);
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
      setRightButton(2131692601, new abag(this));
      if (this.jdField_g_of_type_JavaLangString != null)
      {
        this.rightViewText.setText(this.jdField_g_of_type_JavaLangString);
        this.rightViewText.setContentDescription(getString(2131698023, new Object[] { this.jdField_g_of_type_JavaLangString }));
      }
      if (this.jdField_h_of_type_JavaLangString != null)
      {
        this.leftView.setText(this.jdField_h_of_type_JavaLangString);
        this.leftView.setContentDescription(getString(2131698023, new Object[] { this.jdField_h_of_type_JavaLangString }));
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
        TextView localTextView = (TextView)findViewById(2131377128);
        if (localTextView != null)
        {
          localTextView.setVisibility(0);
          localTextView.setText(this.jdField_i_of_type_JavaLangString);
          localTextView.setOnClickListener(new abah(this));
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
    super.setContentView(2131559015);
    j();
    Object localObject = findViewById(2131369203);
    View localView = findViewById(2131369204);
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
      this.jdField_a_of_type_ComTencentMobileqqProfileViewSoftInputDetectView = ((SoftInputDetectView)super.findViewById(2131368201));
      this.jdField_a_of_type_ComTencentMobileqqProfileViewSoftInputDetectView.setOnImStateChangedListener(this);
      this.jdField_a_of_type_AndroidWidgetEditText.setEditableFactory(ayka.a);
      this.jdField_a_of_type_AndroidWidgetEditText.setOnClickListener(this);
      this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)super.findViewById(2131364383));
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = ((RecyclerView)super.findViewById(2131364368));
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$LayoutManager = new GridLayoutManager(this, 3);
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setLayoutManager(this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$LayoutManager);
      this.jdField_a_of_type_Bboj = new bboj(this, this);
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setAdapter(this.jdField_a_of_type_Bboj);
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.addOnScrollListener(this.jdField_a_of_type_Bbom);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)super.findViewById(2131364365));
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131364366));
      this.jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(this);
      this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131364369));
      this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
      this.jdField_c_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)super.findViewById(2131364370));
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131364382));
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131364380));
      this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(this);
      this.jdField_d_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)super.findViewById(2131364376));
      this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131364374));
      this.jdField_d_of_type_AndroidWidgetImageView.setOnClickListener(this);
      this.jdField_a_of_type_ComTencentMobileqqWidgetColorNickTextView = ((ColorNickTextView)super.findViewById(2131364377));
      this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131364375));
      this.jdField_d_of_type_AndroidWidgetTextView.setOnClickListener(this);
      this.jdField_e_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)super.findViewById(2131364373));
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
        this.jdField_a_of_type_AndroidWidgetEditText.setFilters(new InputFilter[] { new abao(this) });
      }
    }
    while ((!this.jdField_g_of_type_Boolean) || (!a(null))) {
      for (;;)
      {
        return;
        this.jdField_d_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
        localObject = new ayjw((CharSequence)localObject, 16).a();
        this.jdField_a_of_type_ComTencentMobileqqWidgetColorNickTextView.setText((CharSequence)localObject);
        bbos.a(this.app, this.jdField_a_of_type_ComTencentMobileqqWidgetColorNickTextView, (Spannable)localObject);
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
      abai localabai = new abai(this);
      this.jdField_a_of_type_AndroidWidgetEditText.setFilters(new InputFilter[] { localabai });
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
        bbos.a(this.app).jdField_a_of_type_Bboz.a(this.jdField_b_of_type_JavaUtilArrayList);
        if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel != null) {
          this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.a(this.app, 100001, this, getTitleBarHeight(), null, null, false, bbos.a(this.app).jdField_a_of_type_Bboz);
        }
      }
    }
  }
  
  protected void i()
  {
    super.setContentView(2131559014);
    this.jdField_a_of_type_ComTencentMobileqqWidgetInputMethodLinearLayout = ((InputMethodLinearLayout)super.findViewById(2131375493));
    this.jdField_a_of_type_ComTencentMobileqqWidgetInputMethodLinearLayout.setOnSizeChangedListenner(this);
    j();
    if (!this.jdField_i_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidWidgetEditText.getLayoutParams().height = ((int)bbdv.a(this, 149.0F));
      LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqWidgetInputMethodLinearLayout.findViewById(2131365511).getLayoutParams();
      localLayoutParams.height = ((int)bbdv.a(this, 151.0F));
      localLayoutParams.weight = 0.0F;
    }
    this.jdField_a_of_type_AndroidWidgetEditText.setEditableFactory(ayku.a);
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
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)super.findViewById(2131365526));
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)super.findViewById(2131375493));
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
          this.jdField_a_of_type_ComTencentMobileqqTroopWidgetEllipsizingTextView = ((EllipsizingTextView)super.findViewById(2131365527));
        }
        if (b())
        {
          this.jdField_a_of_type_AndroidWidgetEditText.setTextColor(getResources().getColor(2131166946));
          p();
        }
        if (!this.jdField_k_of_type_Boolean)
        {
          this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
          this.jdField_a_of_type_AndroidWidgetEditText.clearFocus();
          this.jdField_a_of_type_AndroidWidgetEditText.setFocusable(false);
          this.jdField_a_of_type_AndroidWidgetEditText.setFocusableInTouchMode(false);
          this.jdField_a_of_type_AndroidWidgetEditText.setOnLongClickListener(new abaj(this));
          this.jdField_a_of_type_AndroidWidgetEditText.setLongClickable(false);
          this.jdField_a_of_type_AndroidWidgetEditText.setTextIsSelectable(false);
          this.jdField_a_of_type_AndroidWidgetEditText.setCustomSelectionActionModeCallback(new abak(this));
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
        this.jdField_a_of_type_AndroidWidgetEditText.setText(bbos.b(this.jdField_b_of_type_JavaLangString));
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
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)super.findViewById(2131365593));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131376755));
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new abam(this));
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemAndEmojiEmoticonPanel = new SystemAndEmojiEmoticonPanel(this, this);
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemAndEmojiEmoticonPanel.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemAndEmojiEmoticonPanel);
    this.jdField_a_of_type_AndroidWidgetEditText.setOnClickListener(new aban(this));
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
        this.jdField_h_of_type_JavaLangString = ajya.a(2131703643);
        this.jdField_g_of_type_JavaLangString = ajya.a(2131703640);
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
          localObject1 = (akhp)this.app.a(20);
          if (localObject1 != null) {
            ((akhp)localObject1).x(this.jdField_f_of_type_JavaLangString);
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
    this.jdField_a_of_type_AndroidWidgetEditText.setTextColor(getResources().getColor(2131166946));
    if ((this.jdField_a_of_type_AndroidWidgetEditText instanceof ColorClearableEditText)) {
      ((ColorClearableEditText)this.jdField_a_of_type_AndroidWidgetEditText).setSpecialColor(0, null, null, 0, null);
    }
    this.jdField_a_of_type_Bboj.a(-1);
    this.jdField_a_of_type_Bboj.a.a(-1);
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
      bbrk.a(this, "mvip.g.a.qnc_kt", "CJCLUBT", -1, false, true);
      VasWebviewUtil.reportCommercialDrainage(this.app.c(), "group_nickname", "group_nickname_3", "", 1, 0, 0, "", "", "");
      return;
      this.jdField_d_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      return;
      paramView = new ayjw(this.jdField_a_of_type_ComTencentMobileqqWidgetColorNickTextView.getText().toString(), 32).a();
      this.jdField_a_of_type_AndroidWidgetEditText.setText(paramView);
      bbos.a(this.app, this.jdField_a_of_type_AndroidWidgetEditText, paramView);
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
        for (paramView = String.format(getString(2131720569), new Object[] { this.jdField_b_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString }); !TextUtils.isEmpty(paramView); paramView = String.format(getString(2131720570), new Object[] { this.jdField_b_of_type_JavaLangString }))
        {
          if (Build.VERSION.SDK_INT >= 11) {
            break label480;
          }
          ((android.text.ClipboardManager)getSystemService("clipboard")).setText(paramView);
          bcql.a(this, 2131699599, 1).a();
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
      removeObserver(this.jdField_a_of_type_Akil);
      removeObserver(this.jdField_a_of_type_Bbri);
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
    this.app.removeObserver(this.jdField_a_of_type_Akfy);
    bbos.a(this.app).jdField_a_of_type_AndroidOsHandler = null;
    try
    {
      this.jdField_a_of_type_AndroidWidgetEditText.setFocusable(false);
      this.jdField_a_of_type_AndroidWidgetEditText.setFocusableInTouchMode(false);
      this.jdField_a_of_type_AndroidWidgetEditText.setVisibility(8);
      this.jdField_a_of_type_AndroidViewViewGroup.removeView(this.jdField_a_of_type_AndroidWidgetEditText);
      removeObserver(this.jdField_a_of_type_Ajto);
      removeObserver(this.jdField_a_of_type_Ajxj);
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