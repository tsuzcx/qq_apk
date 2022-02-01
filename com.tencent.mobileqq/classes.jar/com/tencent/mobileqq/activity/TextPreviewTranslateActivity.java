package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.activity.history.widget.DispatchTouchEventRelativeLayout;
import com.tencent.mobileqq.activity.selectable.TranslateSelectableMenu;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.ocr.OCRObserver;
import com.tencent.mobileqq.ocr.TranslateController;
import com.tencent.mobileqq.ocr.api.IOCRService;
import com.tencent.mobileqq.ocr.data.OcrConfig;
import com.tencent.mobileqq.ocr.data.TranslateResult;
import com.tencent.mobileqq.ocr.view.TranslateLanguageOptionsView;
import com.tencent.mobileqq.ocr.view.TranslateLanguageOptionsView.OptionItem;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.widget.ContainerView;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ScrollView;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.List;

public class TextPreviewTranslateActivity
  extends BaseActivity
  implements View.OnClickListener
{
  public static final int a = Color.parseColor("#03081A");
  public static final int b = Color.parseColor("#00CAFC");
  public static final int c = Color.parseColor("#FFFFFF");
  public static final int d = Color.parseColor("#A8A8A8");
  public static final int e = Color.parseColor("#004080");
  public static final int f = Color.parseColor("#1F1F1F");
  public static final int g = Color.parseColor("#000000");
  private String A;
  private String B;
  private TranslateController C;
  private OCRObserver D = new TextPreviewTranslateActivity.2(this);
  public RelativeLayout h;
  protected QQProgressDialog i;
  TranslateLanguageOptionsView j;
  TranslateLanguageOptionsView k;
  private String l;
  private EditText m;
  private ContainerView n;
  private TextView o;
  private TextView p;
  private ImageView q;
  private ImageView r;
  private ScrollView s;
  private TranslateSelectableMenu t;
  private boolean u = false;
  private OcrConfig v;
  private List<String> w;
  private List<String> x;
  private String y;
  private String z;
  
  private List<String> a(String paramString)
  {
    OcrConfig localOcrConfig = this.v;
    if (localOcrConfig != null) {
      return localOcrConfig.getTranslateSupportLanguages(paramString);
    }
    return OcrConfig.getDefaultSupportLanguages(paramString);
  }
  
  private void a()
  {
    if (e(this.y))
    {
      this.A = "zh";
      this.B = "en";
    }
    else
    {
      this.A = "en";
      this.B = "zh";
    }
    this.o.setText(b(this.A));
    this.p.setText(b(this.B));
    this.w = a(this.A);
    this.x = a(this.B);
  }
  
  private void a(int paramInt)
  {
    if (this.i == null)
    {
      this.i = new QQProgressDialog(this, getResources().getDimensionPixelSize(2131299920));
      this.i.c(paramInt);
    }
    if (!isFinishing()) {
      this.i.show();
    }
  }
  
  private void a(TranslateResult paramTranslateResult)
  {
    if (paramTranslateResult == null) {
      return;
    }
    ContainerView localContainerView = this.n;
    if (localContainerView != null)
    {
      TranslateSelectableMenu localTranslateSelectableMenu = this.t;
      if (localTranslateSelectableMenu != null)
      {
        String str = paramTranslateResult.c();
        localTranslateSelectableMenu.e = str;
        localContainerView.setText(str);
        d(paramTranslateResult.c);
        c(paramTranslateResult.b);
      }
    }
  }
  
  private void a(String paramString1, String paramString2, String paramString3)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)) && (!TextUtils.isEmpty(paramString3)))
    {
      a(2131897099);
      TranslateController localTranslateController = this.C;
      if (localTranslateController != null) {
        localTranslateController.a(paramString1, paramString2, paramString3);
      }
    }
  }
  
  private String b(String paramString)
  {
    OcrConfig localOcrConfig = this.v;
    if (localOcrConfig != null) {
      return localOcrConfig.getTranslateLanguageName(paramString);
    }
    return OcrConfig.getDefaultLanguageName(paramString);
  }
  
  private void b()
  {
    this.m.setBackgroundColor(c);
    this.n.setTextColor(b);
    this.o.setTextColor(a);
    this.p.setTextColor(a);
    Drawable localDrawable = getResources().getDrawable(2130847830);
    this.q.setImageDrawable(localDrawable);
    localDrawable = getResources().getDrawable(2130847825);
    this.r.setImageDrawable(localDrawable);
  }
  
  private void c()
  {
    Intent localIntent = getIntent();
    this.z = localIntent.getStringExtra("TranslateText");
    this.y = this.z;
    this.l = localIntent.getStringExtra("WhereAreYouFrom");
  }
  
  private void c(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    this.A = paramString.toLowerCase();
    this.o.setText(b(this.A));
    this.x = a(this.A);
    paramString = this.x;
    if ((paramString != null) && (paramString.size() > 1))
    {
      this.p.setClickable(true);
      paramString = getResources();
      int i1;
      if (this.u) {
        i1 = 2130847264;
      } else {
        i1 = 2130847827;
      }
      paramString = paramString.getDrawable(i1);
      this.p.setCompoundDrawablesWithIntrinsicBounds(null, null, null, paramString);
    }
    else
    {
      this.p.setClickable(false);
      this.p.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
    }
    if (AppSetting.e) {
      AccessibilityUtil.a(this.o, this.A, getString(2131897098));
    }
  }
  
  private void d()
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("PARAM_FROM", 1);
    setResult(1, localIntent);
  }
  
  private void d(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    this.B = paramString.toLowerCase();
    this.p.setText(b(this.B));
    this.w = a(paramString);
    paramString = this.w;
    if ((paramString != null) && (paramString.size() > 1))
    {
      this.o.setClickable(true);
      paramString = getResources();
      int i1;
      if (this.u) {
        i1 = 2130847264;
      } else {
        i1 = 2130847827;
      }
      paramString = paramString.getDrawable(i1);
      this.o.setCompoundDrawablesWithIntrinsicBounds(null, null, null, paramString);
    }
    else
    {
      this.o.setClickable(false);
      this.o.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
    }
    if (AppSetting.e) {
      AccessibilityUtil.a(this.p, this.B, getString(2131897098));
    }
  }
  
  private void e()
  {
    this.h = ((RelativeLayout)findViewById(2131447260));
    this.m = ((EditText)findViewById(2131447838));
    this.m.setText(new QQText(this.y, 5, 25));
    this.n = ((ContainerView)findViewById(2131447839));
    this.o = ((TextView)findViewById(2131447814));
    this.p = ((TextView)findViewById(2131447810));
    this.q = ((ImageView)findViewById(2131447815));
    this.r = ((ImageView)findViewById(2131447809));
    this.s = ((ScrollView)findViewById(2131445363));
    this.o.setOnClickListener(this);
    this.p.setOnClickListener(this);
    this.q.setOnClickListener(this);
    this.r.setOnClickListener(this);
    this.t = new TranslateSelectableMenu();
    this.t.a(this, this.n);
    b();
    this.v = ((IOCRService)this.app.getRuntimeService(IOCRService.class, "")).getOCRConfig(false);
    RelativeLayout localRelativeLayout = this.h;
    if ((localRelativeLayout instanceof DispatchTouchEventRelativeLayout)) {
      ((DispatchTouchEventRelativeLayout)localRelativeLayout).setOnDispatchListener(new TextPreviewTranslateActivity.DispatchListener(this.t));
    }
    this.m.setHorizontallyScrolling(false);
    int i1 = DisplayUtil.a(this, 360.0F);
    if (this.m.getLineHeight() != 0) {
      i1 /= this.m.getLineHeight();
    } else {
      i1 = 17;
    }
    this.m.setMaxLines(i1);
    this.m.setOnEditorActionListener(new TextPreviewTranslateActivity.1(this));
  }
  
  private static boolean e(String paramString)
  {
    int i1 = 0;
    while (i1 < paramString.length())
    {
      int i2 = paramString.charAt(i1);
      if ((19968 <= i2) && (i2 < 40869)) {
        return true;
      }
      i1 += 1;
    }
    return false;
  }
  
  private String f(String paramString)
  {
    if (StringUtil.isEmpty(paramString)) {
      return "";
    }
    return new QQText(paramString, 5, 25).toPlainText(false);
  }
  
  private void f()
  {
    QQProgressDialog localQQProgressDialog = this.i;
    if ((localQQProgressDialog != null) && (localQQProgressDialog.isShowing())) {
      this.i.dismiss();
    }
  }
  
  private void g()
  {
    Object localObject = this.j;
    if ((localObject != null) && (((TranslateLanguageOptionsView)localObject).isShowing())) {
      this.j.dismiss();
    }
    localObject = this.k;
    if ((localObject != null) && (((TranslateLanguageOptionsView)localObject).isShowing()))
    {
      this.k.dismiss();
      return;
    }
    localObject = this.w;
    if (localObject != null)
    {
      if (((List)localObject).size() == 0) {
        return;
      }
      localObject = new ArrayList();
      int i1 = 0;
      int i2 = 0;
      while (i1 < this.w.size())
      {
        String str = (String)this.w.get(i1);
        if (!str.equals(this.x))
        {
          TranslateLanguageOptionsView.OptionItem localOptionItem = new TranslateLanguageOptionsView.OptionItem();
          localOptionItem.b = str;
          localOptionItem.a = b(str);
          if (str.equalsIgnoreCase(this.A)) {
            i2 = i1;
          }
          ((List)localObject).add(localOptionItem);
        }
        i1 += 1;
      }
      this.k = TranslateLanguageOptionsView.a(this, (List)localObject, i2, new TextPreviewTranslateActivity.3(this));
      localObject = this.k;
      if (localObject != null)
      {
        ((TranslateLanguageOptionsView)localObject).setOnDismissListener(new TextPreviewTranslateActivity.4(this));
        i1 = this.o.getMeasuredWidth() / 2;
        i2 = AIOUtils.b(75.0F, getResources());
        this.o.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
        this.k.showAsDropDown(this.o, i1 - i2, 0);
      }
    }
  }
  
  private void h()
  {
    Object localObject = this.k;
    if ((localObject != null) && (((TranslateLanguageOptionsView)localObject).isShowing())) {
      this.k.dismiss();
    }
    localObject = this.j;
    if ((localObject != null) && (((TranslateLanguageOptionsView)localObject).isShowing()))
    {
      this.j.dismiss();
      return;
    }
    localObject = this.x;
    if (localObject != null)
    {
      if (((List)localObject).size() == 0) {
        return;
      }
      localObject = new ArrayList();
      int i1 = 0;
      int i2 = 0;
      while (i1 < this.x.size())
      {
        String str = (String)this.x.get(i1);
        if (!str.equals(this.A))
        {
          TranslateLanguageOptionsView.OptionItem localOptionItem = new TranslateLanguageOptionsView.OptionItem();
          localOptionItem.b = str;
          localOptionItem.a = b(str);
          if (str.equalsIgnoreCase(this.B)) {
            i2 = i1;
          }
          ((List)localObject).add(localOptionItem);
        }
        i1 += 1;
      }
      this.j = TranslateLanguageOptionsView.a(this, (List)localObject, i2, new TextPreviewTranslateActivity.5(this));
      localObject = this.j;
      if (localObject != null)
      {
        ((TranslateLanguageOptionsView)localObject).setOnDismissListener(new TextPreviewTranslateActivity.6(this));
        i1 = this.p.getMeasuredWidth() / 2;
        i2 = AIOUtils.b(75.0F, getResources());
        this.p.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
        this.j.showAsDropDown(this.p, i1 - i2, 0);
      }
    }
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramIntent != null) {
      ForwardUtils.a(this.app, paramIntent, this);
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    this.mActNeedImmersive = false;
    super.doOnCreate(paramBundle);
    super.setContentView(2131627881);
    c();
    e();
    d();
    this.C = new TranslateController(this.app);
    addObserver(this.D);
    a();
    c(this.A);
    d(this.B);
    a(f(this.y), this.A, this.B);
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    removeObserver(this.D);
    this.t.b(this.n);
  }
  
  protected void doOnPause()
  {
    super.doOnPause();
    this.t.c();
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    this.t.b();
    if ((ImmersiveUtils.isSupporImmersive() != 0) && (ImmersiveUtils.couldSetStatusTextColor())) {
      ImmersiveUtils.setStatusTextColor(true, getWindow());
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    case 2131447811: 
    case 2131447812: 
    case 2131447813: 
    default: 
      break;
    case 2131447815: 
      Object localObject = this.A;
      c(this.B);
      d((String)localObject);
      a(f(this.y), this.A, this.B);
      localObject = this.k;
      if ((localObject != null) && (((TranslateLanguageOptionsView)localObject).isShowing())) {
        this.k.dismiss();
      }
      localObject = this.j;
      if ((localObject != null) && (((TranslateLanguageOptionsView)localObject).isShowing())) {
        this.j.dismiss();
      }
      break;
    case 2131447814: 
      g();
      break;
    case 2131447810: 
      h();
      break;
    case 2131447809: 
      finish();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TextPreviewTranslateActivity
 * JD-Core Version:    0.7.0.1
 */