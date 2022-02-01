package com.tencent.mm.ui.widget.dialog;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.view.View;
import android.view.Window;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import com.tencent.luggage.wxa.rg.b;
import com.tencent.mm.ui.AlertActivity;
import com.tencent.mm.ui.f;
import com.tencent.mm.ui.g;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.Set;

public class MMConfirmDialog$Builder
{
  private final MMAlertDialog.Builder a;
  private Context b;
  private MMAlertDialog c;
  private String d = null;
  private String e = null;
  private boolean f = false;
  private boolean g = false;
  private RadioGroup h;
  private LinearLayout i;
  private MMConfirmDialog.IOnMultiChoiceClickListener j;
  private int[] k;
  
  public MMConfirmDialog$Builder(Context paramContext)
  {
    this.b = paramContext;
    this.a = new MMAlertDialog.Builder(this.b);
    this.a.setCancelable(false);
    this.a.setCanBack(false);
    this.a.setTextSmileySpan(new MMConfirmDialog.Builder.1(this));
    this.e = this.b.getResources().getString(2131887626);
    this.d = this.b.getResources().getString(2131887629);
  }
  
  public Builder cancel(DialogInterface.OnCancelListener paramOnCancelListener)
  {
    this.a.setOnCancelListener(paramOnCancelListener);
    return this;
  }
  
  public Builder cancelable(boolean paramBoolean)
  {
    this.a.setCancelable(paramBoolean);
    this.a.setCanBack(paramBoolean);
    return this;
  }
  
  public Builder centerImg(int paramInt)
  {
    Bitmap localBitmap = BitmapFactory.decodeResource(this.b.getResources(), paramInt);
    this.a.setCenterImg(localBitmap, false, 3);
    return this;
  }
  
  public Builder checkBoxText(String paramString)
  {
    this.a.setCheckBox(paramString);
    return this;
  }
  
  public Builder click(MMConfirmDialog.IIOnDialogClick paramIIOnDialogClick)
  {
    Object localObject = this.h;
    if (localObject != null) {
      ((RadioGroup)localObject).setTag(this.c);
    }
    localObject = this.d;
    if ((localObject == null) || ((localObject != null) && (((String)localObject).length() == 0))) {
      this.d = this.b.getResources().getString(2131887629);
    }
    this.a.setPositiveBtnText(this.d);
    this.a.setPositiveBtnListener(new MMConfirmDialog.Builder.7(this, paramIIOnDialogClick));
    localObject = this.e;
    if ((localObject == null) || ((localObject != null) && (((String)localObject).length() == 0))) {
      this.e = this.b.getResources().getString(2131887626);
    }
    this.a.setNegativeBtnText(this.e);
    if (!this.g) {
      this.a.setNegativeBtnListener(new MMConfirmDialog.Builder.8(this, paramIIOnDialogClick));
    }
    return this;
  }
  
  public Builder click(MMConfirmDialog.IOnCheckBoxDialogClick paramIOnCheckBoxDialogClick)
  {
    String str = this.d;
    if ((str == null) || ((str != null) && (str.length() == 0))) {
      this.d = this.b.getResources().getString(2131887629);
    }
    str = this.e;
    if ((str == null) || ((str != null) && (str.length() == 0))) {
      this.e = this.b.getResources().getString(2131887626);
    }
    this.a.setNegativeBtnText(this.e);
    this.a.setPositiveBtnText(this.d);
    this.a.setPositiveBtnListener(new MMConfirmDialog.Builder.5(this, paramIOnCheckBoxDialogClick));
    if (!this.g) {
      this.a.setNegativeBtnListener(new MMConfirmDialog.Builder.6(this, paramIOnCheckBoxDialogClick));
    }
    return this;
  }
  
  public Builder click(MMConfirmDialog.IOnDialogClick paramIOnDialogClick)
  {
    RadioGroup localRadioGroup = this.h;
    if (localRadioGroup != null) {
      localRadioGroup.setTag(this.c);
    }
    positiveClick(paramIOnDialogClick);
    negativeClick(paramIOnDialogClick);
    return this;
  }
  
  public Builder click(MMConfirmDialog.IOnDialogClick paramIOnDialogClick1, MMConfirmDialog.IOnDialogClick paramIOnDialogClick2)
  {
    RadioGroup localRadioGroup = this.h;
    if (localRadioGroup != null) {
      localRadioGroup.setTag(this.c);
    }
    negativeClick(paramIOnDialogClick1);
    positiveClick(paramIOnDialogClick2);
    if (this.f) {
      this.a.setNegativeBtnColor(this.b.getResources().getColor(2131165616));
    }
    return this;
  }
  
  public Builder contentClick(MMAlertDialog.Builder.IOnContentClick paramIOnContentClick)
  {
    this.a.setContentClick(paramIOnContentClick);
    return this;
  }
  
  public Builder contentDesc(String paramString)
  {
    this.a.setContentDescTv(paramString);
    return this;
  }
  
  public Builder customView(View paramView)
  {
    this.a.setView(paramView);
    return this;
  }
  
  public Builder dialogImage(Bitmap paramBitmap, int paramInt)
  {
    this.a.setCenterImg(paramBitmap, true, paramInt);
    this.a.hasMsgContentBg(false);
    MMConfirmDialog.a(this.a, paramBitmap);
    return this;
  }
  
  public Builder dismiss(DialogInterface.OnDismissListener paramOnDismissListener)
  {
    this.a.setOnDismissListener(paramOnDismissListener);
    return this;
  }
  
  public final MMAlertDialog getAlert()
  {
    return this.c;
  }
  
  public Builder hasEditText(Boolean paramBoolean)
  {
    this.a.hasEditText(paramBoolean.booleanValue());
    return this;
  }
  
  public Builder hideNegativeBtn(boolean paramBoolean)
  {
    this.g = paramBoolean;
    return this;
  }
  
  public Builder leftIconStyle(Bitmap paramBitmap, String paramString1, String paramString2)
  {
    this.a.setLeftIconStyle(paramBitmap, paramString1, paramString2);
    return this;
  }
  
  public Builder message(String paramString)
  {
    this.a.setMsg(paramString);
    return this;
  }
  
  public Builder msgSubContent(String paramString)
  {
    this.a.setMsgSubDesc(paramString);
    return this;
  }
  
  public Builder msgSubTitle(CharSequence paramCharSequence)
  {
    Object localObject = this.b;
    int m = g.a((Context)localObject, (int)(g.b((Context)localObject) * 14.0F));
    if ((paramCharSequence != null) && (paramCharSequence.length() > 0))
    {
      localObject = b.a(this.b, paramCharSequence.toString(), m);
      this.a.setMsgSubTitle((CharSequence)localObject);
    }
    this.a.setMsgSubTitle(paramCharSequence);
    return this;
  }
  
  public Builder msgTitleMaxLine(int paramInt)
  {
    this.a.setMsgMaxLine(paramInt);
    return this;
  }
  
  public Builder multiBtnText(String paramString1, String paramString2, String paramString3)
  {
    this.a.setMultiBtnText(paramString1, paramString2, paramString3);
    return this;
  }
  
  public Builder multiClick(DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2, DialogInterface.OnClickListener paramOnClickListener3)
  {
    this.a.setMultiBtnListener(paramOnClickListener1, paramOnClickListener2, paramOnClickListener3);
    return this;
  }
  
  public Builder multiSelect(LinkedHashMap<String, Integer> paramLinkedHashMap)
  {
    View localView = View.inflate(this.b, 2131624710, null);
    this.i = ((LinearLayout)localView.findViewById(2131430689));
    if (paramLinkedHashMap != null)
    {
      this.k = new int[paramLinkedHashMap.size()];
      paramLinkedHashMap = paramLinkedHashMap.entrySet().iterator();
      int m = 0;
      while (paramLinkedHashMap.hasNext())
      {
        Object localObject = (Map.Entry)paramLinkedHashMap.next();
        int n = ((Integer)((Map.Entry)localObject).getValue()).intValue();
        localObject = (String)((Map.Entry)localObject).getKey();
        this.k[m] = n;
        LinearLayout localLinearLayout = (LinearLayout)View.inflate(this.b, 2131624709, null);
        CheckBox localCheckBox = (CheckBox)localLinearLayout.findViewById(2131430690);
        localCheckBox.setText((CharSequence)localObject);
        localCheckBox.setTag(Integer.valueOf(m));
        localCheckBox.setOnClickListener(new MMConfirmDialog.Builder.2(this, localCheckBox, m));
        m += 1;
        if (n == 2)
        {
          localCheckBox.setChecked(true);
          localCheckBox.setEnabled(false);
        }
        else if (n == 1)
        {
          localCheckBox.setChecked(true);
        }
        else
        {
          localCheckBox.setChecked(false);
        }
        this.i.addView(localLinearLayout);
      }
    }
    this.a.setView(localView);
    return this;
  }
  
  public Builder multiSelectListener(MMConfirmDialog.IOnMultiChoiceClickListener paramIOnMultiChoiceClickListener)
  {
    this.j = paramIOnMultiChoiceClickListener;
    return this;
  }
  
  public Builder negativeBtnColor(int paramInt)
  {
    this.a.setNegativeBtnColor(paramInt);
    return this;
  }
  
  public Builder negativeClick(MMConfirmDialog.IOnDialogClick paramIOnDialogClick)
  {
    String str = this.e;
    if ((str == null) || ((str != null) && (str.length() == 0))) {
      this.e = this.b.getResources().getString(2131887626);
    }
    this.a.setNegativeBtnText(this.e);
    if (!this.g) {
      this.a.setNegativeBtnListener(new MMConfirmDialog.Builder.3(this, paramIOnDialogClick));
    }
    return this;
  }
  
  public Builder negativeText(String paramString)
  {
    this.e = paramString;
    this.a.setNegativeBtnText(this.e);
    return this;
  }
  
  public Builder positiveBtnColor(int paramInt)
  {
    this.a.setPositiveBtnColor(paramInt);
    return this;
  }
  
  public Builder positiveClick(MMConfirmDialog.IOnDialogClick paramIOnDialogClick)
  {
    String str = this.d;
    if ((str == null) || ((str != null) && (str.length() == 0))) {
      this.d = this.b.getResources().getString(2131887629);
    }
    this.a.setPositiveBtnText(this.d);
    this.a.setPositiveBtnListener(new MMConfirmDialog.Builder.4(this, paramIOnDialogClick));
    return this;
  }
  
  public Builder positiveText(int paramInt)
  {
    this.d = this.b.getResources().getString(paramInt);
    this.a.setPositiveBtnText(this.d);
    return this;
  }
  
  public Builder positiveText(String paramString)
  {
    this.d = paramString;
    this.a.setPositiveBtnText(this.d);
    return this;
  }
  
  public Builder rightIconStyle(Bitmap paramBitmap, String paramString1, String paramString2)
  {
    this.a.setRightIconStyle(paramBitmap, paramString1, paramString2);
    return this;
  }
  
  public Builder setEditTextHint(String paramString)
  {
    this.a.setEditTextHint(paramString);
    return this;
  }
  
  public void show()
  {
    if ((this.b instanceof Activity))
    {
      if (this.c == null) {
        this.c = this.a.create();
      }
      this.c.show();
      return;
    }
    AlertActivity.a(this.a);
    Intent localIntent = new Intent(this.b, AlertActivity.class);
    localIntent.setFlags(335544320);
    this.b.startActivity(localIntent);
  }
  
  public void showTop()
  {
    if ((this.b instanceof Activity))
    {
      if (this.c == null) {
        this.c = this.a.create();
      }
      localObject = this.c.getWindow();
      if (localObject != null)
      {
        if (Build.VERSION.SDK_INT >= 26) {
          ((Window)localObject).setType(2038);
        } else {
          ((Window)localObject).setType(2002);
        }
        f.b("dialog", "show top window not null!!", new Object[0]);
      }
      this.c.show();
      return;
    }
    AlertActivity.a(this.a);
    Object localObject = new Intent(this.b, AlertActivity.class);
    ((Intent)localObject).setFlags(335544320);
    ((Intent)localObject).putExtra("dialog_show_top", true);
    this.b.startActivity((Intent)localObject);
  }
  
  public Builder singleSelect(ArrayList<String> paramArrayList, RadioGroup.OnCheckedChangeListener paramOnCheckedChangeListener, int paramInt)
  {
    View localView = View.inflate(this.b, 2131624716, null);
    this.h = ((RadioGroup)localView.findViewById(2131444154));
    int n = 0;
    int m;
    if (paramArrayList != null) {
      m = paramArrayList.size();
    } else {
      m = 0;
    }
    while (n < m)
    {
      RadioButton localRadioButton = (RadioButton)View.inflate(this.b, 2131624715, null);
      localRadioButton.setId(n);
      if (n == paramInt) {
        localRadioButton.setChecked(true);
      }
      localRadioButton.setText((CharSequence)paramArrayList.get(n));
      this.h.addView(localRadioButton);
      n += 1;
    }
    this.h.setOnCheckedChangeListener(paramOnCheckedChangeListener);
    this.a.setView(localView);
    return this;
  }
  
  public Builder source(String paramString)
  {
    this.a.setContentDescTv(paramString);
    return this;
  }
  
  public Builder thumb(int paramInt)
  {
    this.a.setMsgIcon(paramInt);
    return this;
  }
  
  public Builder thumb(Bitmap paramBitmap)
  {
    this.a.setMsgIcon(paramBitmap);
    return this;
  }
  
  public Builder thumb(Drawable paramDrawable)
  {
    this.a.setMsgIcon(paramDrawable);
    return this;
  }
  
  public Builder thumb(String paramString)
  {
    this.a.setMsgIcon(paramString);
    return this;
  }
  
  public Builder thumb(byte[] paramArrayOfByte)
  {
    MMConfirmDialog.a(this.a, paramArrayOfByte);
    return this;
  }
  
  public Builder thumbVisivility(int paramInt)
  {
    this.a.setMsgIconVisivility(paramInt);
    return this;
  }
  
  public Builder title(CharSequence paramCharSequence)
  {
    Object localObject = this.b;
    int m = g.a((Context)localObject, (int)(g.b((Context)localObject) * 20.0F));
    if ((paramCharSequence != null) && (paramCharSequence.length() > 0))
    {
      localObject = b.a(this.b, paramCharSequence.toString(), m);
      this.a.setTitle((CharSequence)localObject);
    }
    this.a.setTitle(paramCharSequence);
    return this;
  }
  
  public Builder titleDesc(CharSequence paramCharSequence)
  {
    Object localObject = this.b;
    int m = g.a((Context)localObject, (int)(g.b((Context)localObject) * 14.0F));
    if ((paramCharSequence != null) && (paramCharSequence.length() > 0))
    {
      localObject = b.a(this.b, paramCharSequence.toString(), m);
      this.a.setTitleDesc((CharSequence)localObject);
    }
    this.a.setTitleDesc(paramCharSequence);
    return this;
  }
  
  public Builder titleGravity(int paramInt)
  {
    this.a.setTitleGravity(paramInt);
    return this;
  }
  
  public Builder upDownBtn(boolean paramBoolean)
  {
    this.a.setBtnUpDown(paramBoolean);
    this.f = paramBoolean;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.widget.dialog.MMConfirmDialog.Builder
 * JD-Core Version:    0.7.0.1
 */