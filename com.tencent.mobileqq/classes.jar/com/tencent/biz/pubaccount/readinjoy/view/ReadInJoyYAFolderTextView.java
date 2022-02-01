package com.tencent.biz.pubaccount.readinjoy.view;

import amtj;
import android.content.Context;
import android.os.Build.VERSION;
import android.text.DynamicLayout;
import android.text.Layout;
import android.text.Selection;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.text.style.ClickableSpan;
import android.util.AttributeSet;
import android.util.Pair;
import android.view.MotionEvent;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.text.QQText.EmoticonSpan;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.dynamic.Reflect;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;
import org.jetbrains.annotations.NotNull;
import pcl;
import pvc;
import sol;
import som;
import tfp;

public class ReadInJoyYAFolderTextView
  extends TextView
{
  private static final char[] jdField_a_of_type_ArrayOfChar = { '…' };
  private static final String jdField_c_of_type_JavaLangString = new String(jdField_a_of_type_ArrayOfChar);
  private int jdField_a_of_type_Int = 5;
  private SpannableStringBuilder jdField_a_of_type_AndroidTextSpannableStringBuilder = new SpannableStringBuilder();
  @android.support.annotation.Nullable
  private Pair<Integer, Reflect> jdField_a_of_type_AndroidUtilPair;
  private TextView.BufferType jdField_a_of_type_AndroidWidgetTextView$BufferType;
  private CharSequence jdField_a_of_type_JavaLangCharSequence;
  private Object jdField_a_of_type_JavaLangObject;
  private String jdField_a_of_type_JavaLangString = "...";
  private Vector<ClickableSpan> jdField_a_of_type_JavaUtilVector = new Vector();
  protected tfp a;
  private boolean jdField_a_of_type_Boolean;
  protected int b;
  private String jdField_b_of_type_JavaLangString = amtj.a(2131712166);
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int = -1;
  public boolean c;
  private int d = -1;
  private int e = -1;
  
  public ReadInJoyYAFolderTextView(Context paramContext)
  {
    super(paramContext);
    this.jdField_b_of_type_Int = -15504151;
    b();
  }
  
  public ReadInJoyYAFolderTextView(Context paramContext, @android.support.annotation.Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_b_of_type_Int = -15504151;
    b();
  }
  
  public ReadInJoyYAFolderTextView(Context paramContext, @android.support.annotation.Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_b_of_type_Int = -15504151;
    b();
  }
  
  private float a(TextPaint paramTextPaint, SpannableStringBuilder paramSpannableStringBuilder)
  {
    paramSpannableStringBuilder.append(this.jdField_a_of_type_JavaLangString).append(this.jdField_b_of_type_JavaLangString);
    if (this.jdField_a_of_type_JavaLangObject != null) {
      paramSpannableStringBuilder.setSpan(this.jdField_a_of_type_JavaLangObject, paramSpannableStringBuilder.length() - this.jdField_b_of_type_JavaLangString.length(), paramSpannableStringBuilder.length(), 33);
    }
    return paramTextPaint.measureText(paramSpannableStringBuilder, 0, paramSpannableStringBuilder.length());
  }
  
  private int a(int paramInt, CharSequence paramCharSequence, ClickableSpan[] paramArrayOfClickableSpan)
  {
    int i = this.jdField_a_of_type_AndroidTextSpannableStringBuilder.length();
    if (a(paramCharSequence)) {
      this.jdField_a_of_type_AndroidTextSpannableStringBuilder.append(paramCharSequence.subSequence(0, paramCharSequence.length() - 1)).append('\n');
    }
    for (paramInt = paramCharSequence.length() - 1 + paramInt;; paramInt = paramCharSequence.length() - 3 + paramInt)
    {
      a((Spanned)paramCharSequence, paramArrayOfClickableSpan, i);
      return paramInt;
      this.jdField_a_of_type_AndroidTextSpannableStringBuilder.append(paramCharSequence.subSequence(0, paramCharSequence.length() - 3)).append('\n');
    }
  }
  
  private SpannableStringBuilder a(SpannableStringBuilder paramSpannableStringBuilder)
  {
    Object localObject = (QQText.EmoticonSpan[])paramSpannableStringBuilder.getSpans(0, paramSpannableStringBuilder.length(), QQText.EmoticonSpan.class);
    int i = paramSpannableStringBuilder.length();
    if ((localObject != null) && (localObject.length > 0))
    {
      localObject = localObject[(localObject.length - 1)];
      if (paramSpannableStringBuilder.getSpanEnd(localObject) == i) {
        return new SpannableStringBuilder(paramSpannableStringBuilder, 0, paramSpannableStringBuilder.getSpanStart(localObject));
      }
    }
    return new SpannableStringBuilder(paramSpannableStringBuilder, 0, i - 1);
  }
  
  @NotNull
  private CharSequence a(int paramInt1, int paramInt2, TextPaint paramTextPaint, CharSequence paramCharSequence)
  {
    Object localObject = paramCharSequence;
    CharSequence localCharSequence;
    if (paramCharSequence.length() > 4)
    {
      localObject = paramCharSequence;
      if ((paramCharSequence instanceof SpannableStringBuilder))
      {
        localObject = paramCharSequence.subSequence(0, paramCharSequence.length() - 3);
        localCharSequence = paramCharSequence.subSequence(0, paramCharSequence.length() - 1);
        if ((paramCharSequence.charAt(paramCharSequence.length() - 1) == '…') || (paramTextPaint.measureText(((CharSequence)localObject).toString()) <= paramInt2 - paramInt1)) {
          break label126;
        }
        localObject = a((SpannableStringBuilder)localObject).append(jdField_c_of_type_JavaLangString);
      }
    }
    label126:
    do
    {
      return localObject;
      localObject = paramCharSequence;
    } while (paramTextPaint.measureText(localCharSequence.toString()) <= paramInt2 - paramInt1);
    return a((SpannableStringBuilder)localCharSequence).append(jdField_c_of_type_JavaLangString);
  }
  
  private CharSequence a(ArrayList<CharSequence> paramArrayList, int paramInt1, int paramInt2)
  {
    paramArrayList = (CharSequence)paramArrayList.get(paramInt1);
    return paramArrayList.subSequence(paramInt2, paramArrayList.length());
  }
  
  @NotNull
  private ArrayList<CharSequence> a()
  {
    int i = 0;
    ArrayList localArrayList = new ArrayList();
    int k;
    for (int j = 0; i < this.jdField_a_of_type_JavaLangCharSequence.length(); j = k)
    {
      k = j;
      if (this.jdField_a_of_type_JavaLangCharSequence.charAt(i) == '\n')
      {
        localArrayList.add(this.jdField_a_of_type_JavaLangCharSequence.subSequence(j, i));
        k = i + 1;
      }
      i += 1;
    }
    if (j != this.jdField_a_of_type_JavaLangCharSequence.length()) {
      localArrayList.add(this.jdField_a_of_type_JavaLangCharSequence.subSequence(j, this.jdField_a_of_type_JavaLangCharSequence.length()));
    }
    return localArrayList;
  }
  
  private void a(int paramInt1, int paramInt2, TextPaint paramTextPaint, float paramFloat, ArrayList<CharSequence> paramArrayList, int paramInt3, int paramInt4, int paramInt5)
  {
    ClickableSpan[] arrayOfClickableSpan;
    if (paramInt3 < paramArrayList.size())
    {
      CharSequence localCharSequence = a(paramArrayList, paramInt3, paramInt4);
      paramTextPaint = TextUtils.ellipsize(localCharSequence, paramTextPaint, paramInt2 - paramInt1 - paramFloat, TextUtils.TruncateAt.END);
      arrayOfClickableSpan = a(paramInt5, paramTextPaint);
      if ((paramTextPaint.equals(localCharSequence)) || (paramTextPaint.length() <= 0)) {
        break label140;
      }
      paramInt1 = this.jdField_a_of_type_AndroidTextSpannableStringBuilder.length();
      if (!a(paramTextPaint)) {
        break label114;
      }
      this.jdField_a_of_type_AndroidTextSpannableStringBuilder.append(paramTextPaint.subSequence(0, paramTextPaint.length() - 1));
      a(paramTextPaint, arrayOfClickableSpan, paramInt1);
    }
    label114:
    do
    {
      return;
      this.jdField_a_of_type_AndroidTextSpannableStringBuilder.append(paramTextPaint.subSequence(0, paramTextPaint.length() - 3));
      break;
      if (paramInt3 != paramArrayList.size() - 1)
      {
        paramInt1 = this.jdField_a_of_type_AndroidTextSpannableStringBuilder.length();
        this.jdField_a_of_type_AndroidTextSpannableStringBuilder.append(paramTextPaint);
        a(paramTextPaint, arrayOfClickableSpan, paramInt1);
        return;
      }
    } while (this.jdField_c_of_type_Int <= this.jdField_a_of_type_Int);
    label140:
    paramInt1 = this.jdField_a_of_type_AndroidTextSpannableStringBuilder.length();
    this.jdField_a_of_type_AndroidTextSpannableStringBuilder.append(paramTextPaint);
    a(paramTextPaint, arrayOfClickableSpan, paramInt1, false);
  }
  
  private void a(DynamicLayout paramDynamicLayout)
  {
    if (Build.VERSION.SDK_INT == 26) {
      try
      {
        int i = paramDynamicLayout.hashCode();
        if ((this.jdField_a_of_type_AndroidUtilPair != null) && (this.jdField_a_of_type_AndroidUtilPair.first != null) && (this.jdField_a_of_type_AndroidUtilPair.second != null) && (((Integer)this.jdField_a_of_type_AndroidUtilPair.first).intValue() == i)) {
          paramDynamicLayout = (Reflect)this.jdField_a_of_type_AndroidUtilPair.second;
        }
        for (;;)
        {
          paramDynamicLayout.set("sStaticLayout", null);
          return;
          paramDynamicLayout = Reflect.on(paramDynamicLayout);
          this.jdField_a_of_type_AndroidUtilPair = new Pair(Integer.valueOf(i), paramDynamicLayout);
        }
        return;
      }
      catch (Exception paramDynamicLayout)
      {
        QLog.e("ReadInJoyYAFolderTextView", 2, paramDynamicLayout.getMessage());
      }
    }
  }
  
  private void a(DynamicLayout paramDynamicLayout, int paramInt)
  {
    int i = paramDynamicLayout.getLineStart(paramInt - 1);
    paramInt = paramDynamicLayout.getLineEnd(paramInt - 1);
    paramDynamicLayout = paramDynamicLayout.getText();
    String str1 = paramDynamicLayout.subSequence(i, paramInt).toString();
    String str2 = amtj.a(2131711852);
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    if ((str1.equals(str2.substring(1))) || (str1.equals(str2.substring(2))) || (str1.equals(str2.substring(3))))
    {
      localSpannableStringBuilder.append(paramDynamicLayout.subSequence(0, paramDynamicLayout.length() - str2.length())).append('\n').append(paramDynamicLayout.subSequence(paramDynamicLayout.length() - str2.length(), paramDynamicLayout.length()));
      super.setText(localSpannableStringBuilder);
    }
    while (!str1.equals(" ")) {
      return;
    }
    localSpannableStringBuilder.append(paramDynamicLayout.subSequence(0, paramDynamicLayout.length() - 1));
    super.setText(localSpannableStringBuilder);
  }
  
  private void a(SpannableStringBuilder paramSpannableStringBuilder)
  {
    paramSpannableStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    paramSpannableStringBuilder.append(this.jdField_b_of_type_JavaLangString);
    if (this.jdField_a_of_type_JavaLangObject != null) {
      paramSpannableStringBuilder.setSpan(this.jdField_a_of_type_JavaLangObject, paramSpannableStringBuilder.length() - this.jdField_b_of_type_JavaLangString.length(), paramSpannableStringBuilder.length(), 33);
    }
  }
  
  private void a(Spanned paramSpanned, ClickableSpan[] paramArrayOfClickableSpan, int paramInt)
  {
    if ((paramArrayOfClickableSpan != null) && (paramArrayOfClickableSpan.length > 0))
    {
      int i = this.jdField_a_of_type_AndroidTextSpannableStringBuilder.getSpanStart(paramArrayOfClickableSpan[0]);
      int j = this.jdField_a_of_type_AndroidTextSpannableStringBuilder.getSpanEnd(paramArrayOfClickableSpan[0]);
      if ((i >= 0) && (j >= i) && (j < paramInt))
      {
        paramInt = paramSpanned.getSpanStart(paramArrayOfClickableSpan[0]);
        int k = paramSpanned.getSpanEnd(paramArrayOfClickableSpan[0]);
        if ((paramInt == 0) && (k >= paramInt))
        {
          paramInt = Math.min(j + k + 1, this.jdField_a_of_type_AndroidTextSpannableStringBuilder.length());
          this.jdField_a_of_type_AndroidTextSpannableStringBuilder.setSpan(paramArrayOfClickableSpan[0], i, paramInt, 33);
        }
      }
    }
  }
  
  private void a(CharSequence paramCharSequence, ClickableSpan[] paramArrayOfClickableSpan)
  {
    int i = this.jdField_a_of_type_AndroidTextSpannableStringBuilder.length();
    this.jdField_a_of_type_AndroidTextSpannableStringBuilder.append(paramCharSequence).append('\n');
    a((Spanned)paramCharSequence, paramArrayOfClickableSpan, i);
  }
  
  private void a(CharSequence paramCharSequence, ClickableSpan[] paramArrayOfClickableSpan, int paramInt)
  {
    a(paramCharSequence, paramArrayOfClickableSpan, paramInt, true);
  }
  
  private void a(CharSequence paramCharSequence, ClickableSpan[] paramArrayOfClickableSpan, int paramInt, boolean paramBoolean)
  {
    if ((paramCharSequence instanceof Spanned)) {
      a((Spanned)paramCharSequence, paramArrayOfClickableSpan, paramInt);
    }
    if (paramBoolean) {
      a(this.jdField_a_of_type_AndroidTextSpannableStringBuilder);
    }
    super.setText(this.jdField_a_of_type_AndroidTextSpannableStringBuilder, this.jdField_a_of_type_AndroidWidgetTextView$BufferType);
  }
  
  private boolean a()
  {
    return (this.jdField_a_of_type_Int > 0) && (this.jdField_a_of_type_Boolean) && ((this.jdField_c_of_type_Int < 0) || (this.jdField_c_of_type_Int > this.jdField_a_of_type_Int));
  }
  
  private boolean a(CharSequence paramCharSequence)
  {
    return paramCharSequence.charAt(paramCharSequence.length() - 1) == '…';
  }
  
  @org.jetbrains.annotations.Nullable
  private ClickableSpan[] a(int paramInt, CharSequence paramCharSequence)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if ((paramCharSequence instanceof Spanned))
    {
      localObject1 = localObject2;
      if (paramInt > 1) {
        localObject1 = (ClickableSpan[])((Spanned)paramCharSequence).getSpans(0, paramCharSequence.length(), ClickableSpan.class);
      }
    }
    return localObject1;
  }
  
  private void b()
  {
    setMovementMethod(sol.a());
  }
  
  public int a(ArticleInfo paramArticleInfo)
  {
    if (paramArticleInfo == null) {}
    long l;
    do
    {
      return 7;
      l = paramArticleInfo.mChannelID;
      if (paramArticleInfo.isPGCShortContent())
      {
        if ((l == 0L) || (pcl.c((int)l)))
        {
          AladdinConfig localAladdinConfig = Aladdin.getConfig(168);
          int i = localAladdinConfig.getIntegerFromString("main_channel_textlines", 3);
          switch (paramArticleInfo.mResolvedFeedType)
          {
          default: 
            return i;
          case 109: 
            return localAladdinConfig.getIntegerFromString("main_channel_pure_textlines", i);
          case 110: 
            return localAladdinConfig.getIntegerFromString("main_channel_single_image_textlines", i);
          case 111: 
          case 132: 
          case 133: 
            return localAladdinConfig.getIntegerFromString("main_channel_multiple_image_textlines", i);
          }
          return 2147483647;
        }
        return Aladdin.getConfig(168).getIntegerFromString("channel_textlines", 7);
      }
    } while (l != 0L);
    return 3;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_JavaUtilVector.size() > 0)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilVector.iterator();
      if (localIterator.hasNext())
      {
        ClickableSpan localClickableSpan = (ClickableSpan)localIterator.next();
        if ((localClickableSpan instanceof som)) {
          ((som)localClickableSpan).a(false);
        }
        localIterator.remove();
      }
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (!a()) {
      return;
    }
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidTextSpannableStringBuilder.clear();
    TextPaint localTextPaint = getPaint();
    this.jdField_a_of_type_AndroidTextSpannableStringBuilder = new SpannableStringBuilder();
    float f1 = a(localTextPaint, this.jdField_a_of_type_AndroidTextSpannableStringBuilder);
    this.jdField_a_of_type_AndroidTextSpannableStringBuilder.clear();
    ArrayList localArrayList = a();
    float f2 = paramInt3 - paramInt1;
    paramInt4 = 0;
    paramInt2 = 0;
    int i = 0;
    for (;;)
    {
      if ((i >= this.jdField_a_of_type_Int - 1) || (paramInt4 >= localArrayList.size()))
      {
        a(paramInt1, paramInt3, localTextPaint, f1, localArrayList, paramInt4, paramInt2, i);
        return;
      }
      int j = i + 1;
      CharSequence localCharSequence1 = a(localArrayList, paramInt4, paramInt2);
      CharSequence localCharSequence2 = a(paramInt1, paramInt3, localTextPaint, TextUtils.ellipsize(localCharSequence1, localTextPaint, f2, TextUtils.TruncateAt.END));
      ClickableSpan[] arrayOfClickableSpan = a(j, localCharSequence2);
      if (localCharSequence2.equals(localCharSequence1))
      {
        a(localCharSequence2, arrayOfClickableSpan);
        paramInt2 = 0;
        paramInt4 += 1;
        i = j;
      }
      else
      {
        i = j;
        if (localCharSequence2.length() > 0)
        {
          paramInt2 = a(paramInt2, localCharSequence2, arrayOfClickableSpan);
          i = j;
        }
      }
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    if (this.jdField_a_of_type_Int > 0)
    {
      Object localObject = getLayout();
      if ((localObject instanceof DynamicLayout))
      {
        localObject = (DynamicLayout)localObject;
        a((DynamicLayout)localObject);
        this.jdField_c_of_type_Int = ((DynamicLayout)localObject).getLineCount();
        paramInt2 = getCompoundPaddingTop() + getCompoundPaddingBottom() + this.jdField_a_of_type_Int * getLineHeight();
        paramInt1 = paramInt2;
        if (Build.VERSION.SDK_INT >= 16) {
          paramInt1 = (int)(paramInt2 - getLineSpacingExtra());
        }
        if ((this.jdField_c_of_type_Int >= this.jdField_a_of_type_Int) && (paramInt1 > 0)) {
          setMeasuredDimension(getMeasuredWidth(), paramInt1);
        }
        if (this.jdField_c_of_type_Boolean) {
          a((DynamicLayout)localObject, this.jdField_c_of_type_Int);
        }
      }
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool3 = true;
    boolean bool2 = super.onTouchEvent(paramMotionEvent);
    int i;
    ClickableSpan[] arrayOfClickableSpan;
    boolean bool1;
    try
    {
      i = paramMotionEvent.getActionMasked();
      int j = (int)paramMotionEvent.getX();
      int k = (int)paramMotionEvent.getY();
      int m = getTotalPaddingLeft();
      int n = getTotalPaddingTop();
      int i1 = getScrollX();
      int i2 = getScrollY();
      paramMotionEvent = getLayout();
      j = paramMotionEvent.getOffsetForHorizontal(paramMotionEvent.getLineForVertical(k - n + i2), j - m + i1);
      paramMotionEvent = getText();
      if ((TextUtils.isEmpty(paramMotionEvent)) || (!(paramMotionEvent instanceof Spannable))) {
        break label448;
      }
      paramMotionEvent = (Spannable)getText();
      arrayOfClickableSpan = (ClickableSpan[])paramMotionEvent.getSpans(j, j, ClickableSpan.class);
      if ((arrayOfClickableSpan == null) || (arrayOfClickableSpan.length == 0)) {
        break label349;
      }
      if (i == 0)
      {
        a();
        this.jdField_a_of_type_JavaLangObject = arrayOfClickableSpan[0];
        this.d = paramMotionEvent.getSpanStart(arrayOfClickableSpan[0]);
        this.e = paramMotionEvent.getSpanEnd(arrayOfClickableSpan[0]);
        bool1 = bool3;
        if (this.d < 0) {
          break label452;
        }
        bool1 = bool3;
        if (this.e < this.d) {
          break label452;
        }
        bool1 = bool3;
        if (!(arrayOfClickableSpan[0] instanceof som)) {
          break label452;
        }
        ((som)arrayOfClickableSpan[0]).a(true);
        this.jdField_a_of_type_JavaUtilVector.add(arrayOfClickableSpan[0]);
        return true;
      }
    }
    catch (Exception paramMotionEvent)
    {
      if (QLog.isDevelopLevel()) {
        paramMotionEvent.printStackTrace();
      }
      return bool2;
    }
    if ((i != 1) && (i != 3))
    {
      bool1 = bool3;
      if (i != 4) {}
    }
    else
    {
      this.jdField_a_of_type_JavaLangObject = null;
      if ((this.d >= 0) && (this.e >= this.d))
      {
        if ((arrayOfClickableSpan[0] instanceof som)) {
          ((som)arrayOfClickableSpan[0]).a(false);
        }
        Selection.removeSelection(paramMotionEvent);
        this.d = -1;
        this.e = -1;
      }
      a();
      return true;
      label349:
      if ((this.d >= 0) && (this.e >= this.d))
      {
        if ((this.jdField_a_of_type_JavaLangObject != null) && ((this.jdField_a_of_type_JavaLangObject instanceof som)))
        {
          ((som)this.jdField_a_of_type_JavaLangObject).a(false);
          this.jdField_a_of_type_JavaLangObject = null;
        }
        Selection.removeSelection(paramMotionEvent);
        this.d = -1;
        this.e = -1;
      }
      a();
      bool1 = this.jdField_b_of_type_Boolean;
      if ((bool1) && (bool2)) {}
      for (bool1 = true;; bool1 = false) {
        return bool1;
      }
      label448:
      bool1 = bool2;
    }
    label452:
    return bool1;
  }
  
  public void setCustomViewLinkTextColor(int paramInt)
  {
    if (this.jdField_a_of_type_Tfp != null)
    {
      this.jdField_a_of_type_Tfp.a(paramInt);
      QLog.d("ReadInJoyYAFolderTextView", 1, "setCustomViewLinkTextColor | link color " + paramInt);
    }
  }
  
  public void setEllipsis(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void setLinkedTextColor(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
  }
  
  public void setMaxLines(int paramInt)
  {
    super.setMaxLines(paramInt);
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void setModel(pvc parampvc)
  {
    if ((parampvc != null) && (parampvc.a() != null)) {
      this.jdField_a_of_type_Tfp = parampvc.a().articleViewModel;
    }
  }
  
  public void setMoreSpan(Object paramObject)
  {
    this.jdField_a_of_type_JavaLangObject = paramObject;
  }
  
  public void setShouldCallClick(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  public void setSpanText(String paramString)
  {
    this.jdField_b_of_type_JavaLangString = paramString;
  }
  
  public void setText(CharSequence paramCharSequence, TextView.BufferType paramBufferType)
  {
    Object localObject = paramCharSequence;
    if ((paramCharSequence instanceof QQText)) {
      localObject = new SpannableStringBuilder(paramCharSequence);
    }
    super.setText((CharSequence)localObject, paramBufferType);
    this.jdField_c_of_type_Int = -1;
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_JavaLangCharSequence = ((CharSequence)localObject);
    this.jdField_a_of_type_AndroidWidgetTextView$BufferType = paramBufferType;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyYAFolderTextView
 * JD-Core Version:    0.7.0.1
 */