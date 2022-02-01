package com.tencent.common.danmaku.edit.views;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.text.Editable;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Pair;
import android.view.KeyEvent;
import android.view.View.OnKeyListener;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.EditText;
import com.tencent.common.danmaku.R.styleable;
import com.tencent.common.danmaku.edit.CollectionUtil;
import com.tencent.common.danmaku.edit.FixSharpConnectionWrapper;
import com.tencent.common.danmaku.edit.bean.EditObject;
import com.tencent.common.danmaku.edit.bean.EditObject.CREATOR;
import com.tencent.common.danmaku.edit.bean.EmotionSpan;
import com.tencent.common.danmaku.edit.bean.RichSpan;
import com.tencent.common.danmaku.edit.listener.EditObjectListener;
import com.tencent.common.danmaku.edit.listener.EditObjectListener.DefaultImpls;
import com.tencent.common.danmaku.inject.VideoDanmakuConfig.ILogger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/common/danmaku/edit/views/RichEditText;", "Landroid/widget/EditText;", "context", "Landroid/content/Context;", "attr", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "allowDeletedTopic", "", "getAllowDeletedTopic", "()Z", "setAllowDeletedTopic", "(Z)V", "allowMultiTopic", "getAllowMultiTopic", "setAllowMultiTopic", "atInputListener", "Lkotlin/Function0;", "", "getAtInputListener", "()Lkotlin/jvm/functions/Function0;", "setAtInputListener", "(Lkotlin/jvm/functions/Function0;)V", "countChangeListener", "Lkotlin/Function1;", "", "getCountChangeListener", "()Lkotlin/jvm/functions/Function1;", "setCountChangeListener", "(Lkotlin/jvm/functions/Function1;)V", "value", "countLimit", "getCountLimit", "()I", "setCountLimit", "(I)V", "dataList", "Ljava/util/ArrayList;", "Lcom/tencent/common/danmaku/edit/bean/EditObject;", "Lkotlin/collections/ArrayList;", "getDataList", "()Ljava/util/ArrayList;", "editObjectListener", "Lcom/tencent/common/danmaku/edit/listener/EditObjectListener;", "getEditObjectListener", "()Lcom/tencent/common/danmaku/edit/listener/EditObjectListener;", "setEditObjectListener", "(Lcom/tencent/common/danmaku/edit/listener/EditObjectListener;)V", "localEditObjectMap", "Ljava/util/HashMap;", "Landroid/util/Pair;", "", "Lkotlin/collections/HashMap;", "needTextTruncation", "getNeedTextTruncation", "setNeedTextTruncation", "onSelectionChangeListener", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "selectionStart", "selectionEnd", "getOnSelectionChangeListener", "()Lkotlin/jvm/functions/Function2;", "setOnSelectionChangeListener", "(Lkotlin/jvm/functions/Function2;)V", "richTextColor", "getRichTextColor", "setRichTextColor", "addEditObject", "editObject", "needSpace", "extraInfo", "Lorg/json/JSONObject;", "inputPosition", "addPureContentToEditObjectList", "startPos", "endPos", "addTopicObject", "checkAndCallRichObjectChangeListener", "delKeyOnSameSelection", "getCurrentDataList", "startCalPos", "endCalPos", "getEditObjectFromMap", "wording", "curSpan", "Lcom/tencent/common/danmaku/edit/bean/RichSpan;", "getFirstTopicSpan", "getRichSpanOrNullIfBehind", "getValidSelPosForRichText", "selection", "initKeyListener", "initTextWatcherListener", "insertIcon", "drawable", "Landroid/graphics/drawable/Drawable;", "size", "index", "alignRule", "insertNormalText", "insertNormalTextWithEmoJi", "emoJiPositionList", "", "emoJiTabList", "insertRichText", "insertWordingOverSize", "isIndexInSpan", "onCreateInputConnection", "Landroid/view/inputmethod/InputConnection;", "outAttrs", "Landroid/view/inputmethod/EditorInfo;", "onKeyCallbackFunction", "event", "Landroid/view/KeyEvent;", "keyCode", "onSelectionChanged", "selStart", "selEnd", "removeElementOnTextByIndex", "textIndex", "transEmotionFlagToName", "startPosition", "endPosition", "Companion", "qqdanmaku_release"}, k=1, mv={1, 1, 16})
public final class RichEditText
  extends EditText
{
  public static final RichEditText.Companion a = new RichEditText.Companion(null);
  private int b;
  private boolean c;
  private int d;
  private boolean e = true;
  private boolean f = true;
  @Nullable
  private Function1<? super Integer, Unit> g;
  @Nullable
  private Function0<Unit> h;
  @Nullable
  private EditObjectListener i;
  @Nullable
  private Function2<? super Integer, ? super Integer, Unit> j;
  private final HashMap<Pair<Integer, String>, EditObject> k = new HashMap();
  
  public RichEditText(@NotNull Context paramContext, @NotNull AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.b = paramContext.getResources().getColor(2131168349);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.x);
    setCountLimit(paramContext.getInt(R.styleable.y, 12));
    this.b = paramContext.getColor(R.styleable.z, this.b);
    paramContext.recycle();
    a();
    b();
  }
  
  private final int a(int paramInt)
  {
    Object localObject1 = getText();
    int m = getText().length();
    int n = 0;
    localObject1 = (RichSpan[])((Editable)localObject1).getSpans(0, m, RichSpan.class);
    if ((paramInt == 0) && (!this.e))
    {
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "baseRichSpans");
      if (localObject1.length == 0) {
        m = 1;
      } else {
        m = 0;
      }
      if (((m ^ 0x1) != 0) && (localObject1[0].a() == EditObject.CREATOR.a()))
      {
        m = 1;
        break label95;
      }
    }
    m = 0;
    label95:
    if (m != 0) {
      return getText().getSpanEnd(localObject1[0]);
    }
    int i1 = localObject1.length;
    m = n;
    while (m < i1)
    {
      Object localObject2 = localObject1[m];
      n = getText().getSpanStart(localObject2);
      int i2 = getText().getSpanEnd(localObject2);
      if ((n + 1 <= paramInt) && (i2 >= paramInt)) {
        return i2;
      }
      m += 1;
    }
    return paramInt;
  }
  
  private final EditObject a(String paramString, RichSpan paramRichSpan)
  {
    EditObject localEditObject = (EditObject)this.k.get(new Pair(Integer.valueOf(paramRichSpan.a()), paramRichSpan.b()));
    if (localEditObject != null) {
      return localEditObject;
    }
    return new EditObject(paramString, paramRichSpan.a());
  }
  
  private final ArrayList<EditObject> a(int paramInt1, int paramInt2)
  {
    int m = paramInt1;
    Object localObject1 = RichEditText.Companion.a(a);
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("getCurrentDataList: startPos:");
    ((StringBuilder)localObject2).append(m);
    ((StringBuilder)localObject2).append(", endPos:");
    ((StringBuilder)localObject2).append(paramInt2);
    ((VideoDanmakuConfig.ILogger)localObject1).b("RichEditText", ((StringBuilder)localObject2).toString());
    localObject1 = new ArrayList();
    if (m == paramInt2) {
      return localObject1;
    }
    localObject2 = (RichSpan[])getText().getSpans(m, paramInt2, RichSpan.class);
    Object localObject3 = RichEditText.Companion.a(a);
    Object localObject4 = new StringBuilder();
    ((StringBuilder)localObject4).append("getCurrentDataList | spanList: ");
    ((StringBuilder)localObject4).append("startPos = ");
    ((StringBuilder)localObject4).append(m);
    ((StringBuilder)localObject4).append(", endPos = ");
    ((StringBuilder)localObject4).append(paramInt2);
    ((StringBuilder)localObject4).append(", size = ");
    ((StringBuilder)localObject4).append(localObject2.length);
    ((VideoDanmakuConfig.ILogger)localObject3).b("RichEditText", ((StringBuilder)localObject4).toString());
    localObject3 = CollectionUtil.a;
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "richSpans");
    localObject4 = getText();
    Intrinsics.checkExpressionValueIsNotNull(localObject4, "text");
    localObject2 = ((CollectionUtil)localObject3).a((RichSpan[])localObject2, (Editable)localObject4);
    localObject3 = (Collection)localObject2;
    if ((((((Collection)localObject3).isEmpty() ^ true)) && (m < getText().getSpanStart(((ArrayList)localObject2).get(0)))) || (((ArrayList)localObject2).isEmpty())) {
      n = 1;
    } else {
      n = 0;
    }
    paramInt1 = m;
    if (n != 0)
    {
      if ((((Collection)localObject3).isEmpty() ^ true)) {
        paramInt1 = getText().getSpanStart(((ArrayList)localObject2).get(0));
      } else {
        paramInt1 = paramInt2;
      }
      a(m, paramInt1, (ArrayList)localObject1);
    }
    int n = ((ArrayList)localObject2).size();
    m = 0;
    while (m < n)
    {
      localObject3 = ((ArrayList)localObject2).get(m);
      Intrinsics.checkExpressionValueIsNotNull(localObject3, "sortedSpans[spanPos]");
      localObject3 = (RichSpan)localObject3;
      int i1 = getText().getSpanEnd(localObject3);
      localObject4 = getText();
      Intrinsics.checkExpressionValueIsNotNull(localObject4, "text");
      localObject4 = a(((CharSequence)localObject4).subSequence(paramInt1, i1).toString(), (RichSpan)localObject3);
      VideoDanmakuConfig.ILogger localILogger = RichEditText.Companion.a(a);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getCurrentDataList | getObjectInLocalMap: ");
      localStringBuilder.append("key = [type: ");
      localStringBuilder.append(((RichSpan)localObject3).a());
      localStringBuilder.append(" , id: ");
      localStringBuilder.append(((RichSpan)localObject3).b());
      localStringBuilder.append(']');
      localStringBuilder.append("curObject = ");
      localStringBuilder.append(localObject4);
      localStringBuilder.append(", curPos:");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(", DataList added.");
      localILogger.b("RichEditText", localStringBuilder.toString());
      ((ArrayList)localObject1).add(localObject4);
      if (i1 >= paramInt2) {
        return localObject1;
      }
      if (m < ((ArrayList)localObject2).size() - 1) {
        paramInt1 = 1;
      } else {
        paramInt1 = 0;
      }
      if (paramInt1 != 0) {
        paramInt1 = getText().getSpanStart(((ArrayList)localObject2).get(m + 1));
      } else {
        paramInt1 = paramInt2;
      }
      a(i1, paramInt1, (ArrayList)localObject1);
      m += 1;
    }
    return localObject1;
  }
  
  private final void a()
  {
    addTextChangedListener((TextWatcher)new RichEditText.initTextWatcherListener.1(this));
  }
  
  private final void a(int paramInt1, int paramInt2, ArrayList<EditObject> paramArrayList)
  {
    Object localObject = getText().toString();
    if (localObject != null)
    {
      localObject = ((String)localObject).substring(paramInt1, paramInt2);
      Intrinsics.checkExpressionValueIsNotNull(localObject, "(this as java.lang.Strin…ing(startIndex, endIndex)");
      int m;
      if (((CharSequence)localObject).length() > 0) {
        m = 1;
      } else {
        m = 0;
      }
      if (m != 0)
      {
        localObject = new EditObject(b(paramInt1, paramInt2), 0, 2, null);
        paramArrayList.add(localObject);
        paramArrayList = RichEditText.Companion.a(a);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("getCurrentDataList | curObject = ");
        localStringBuilder.append(localObject);
        localStringBuilder.append(", curPos:");
        localStringBuilder.append(paramInt1);
        localStringBuilder.append(", DataList added.");
        paramArrayList.b("RichEditText", localStringBuilder.toString());
      }
      return;
    }
    throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
  }
  
  private final boolean a(KeyEvent paramKeyEvent, int paramInt)
  {
    if ((paramInt == 67) && (paramKeyEvent.getAction() == 0)) {
      paramInt = 1;
    } else {
      paramInt = 0;
    }
    if (paramInt != 0)
    {
      if (getSelectionStart() == getSelectionEnd()) {
        return d();
      }
      c();
    }
    return false;
  }
  
  private final String b(int paramInt1, int paramInt2)
  {
    Object localObject1 = getText().toString();
    if (localObject1 != null)
    {
      localObject1 = ((String)localObject1).substring(paramInt1, paramInt2);
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "(this as java.lang.Strin…ing(startIndex, endIndex)");
      StringBuilder localStringBuilder = new StringBuilder();
      Object localObject2 = (EmotionSpan[])getText().getSpans(paramInt1, ((String)localObject1).length() + paramInt1, EmotionSpan.class);
      List localList = (List)new ArrayList();
      int m = localObject2.length;
      paramInt2 = 0;
      Object localObject3;
      while (paramInt2 < m)
      {
        localObject3 = localObject2[paramInt2];
        localList.add(new Pair(Integer.valueOf(getText().getSpanStart(localObject3)), ((EmotionSpan)localObject3).a()));
        paramInt2 += 1;
      }
      int n = ((CharSequence)localObject1).length();
      paramInt2 = 0;
      while (paramInt2 < n)
      {
        char c1 = ((String)localObject1).charAt(paramInt2);
        localObject3 = (Iterable)localList;
        localObject2 = (Collection)new ArrayList();
        localObject3 = ((Iterable)localObject3).iterator();
        for (;;)
        {
          boolean bool = ((Iterator)localObject3).hasNext();
          m = 1;
          if (!bool) {
            break;
          }
          Object localObject4 = ((Iterator)localObject3).next();
          Integer localInteger = (Integer)((Pair)localObject4).first;
          if ((localInteger == null) || (localInteger.intValue() != paramInt2 + paramInt1)) {
            m = 0;
          }
          if (m != 0) {
            ((Collection)localObject2).add(localObject4);
          }
        }
        localObject2 = (List)localObject2;
        if ((Intrinsics.areEqual(String.valueOf(c1), "^")) && ((((Collection)localObject2).isEmpty() ^ true))) {
          localStringBuilder.append((String)((Pair)((List)localObject2).get(0)).second);
        } else {
          localStringBuilder.append(c1);
        }
        paramInt2 += 1;
      }
      localObject1 = localStringBuilder.toString();
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "stringBuilder.toString()");
      return localObject1;
    }
    localObject1 = new TypeCastException("null cannot be cast to non-null type java.lang.String");
    for (;;)
    {
      throw ((Throwable)localObject1);
    }
  }
  
  private final void b()
  {
    setOnKeyListener((View.OnKeyListener)new RichEditText.initKeyListener.1(this));
  }
  
  private final void c()
  {
    RichSpan[] arrayOfRichSpan = (RichSpan[])getText().getSpans(getSelectionStart(), getSelectionEnd() - getSelectionStart(), RichSpan.class);
    int n = arrayOfRichSpan.length;
    int m = 0;
    while (m < n)
    {
      RichSpan localRichSpan = arrayOfRichSpan[m];
      EditObjectListener localEditObjectListener = this.i;
      if (localEditObjectListener != null) {
        EditObjectListener.DefaultImpls.a(localEditObjectListener, false, localRichSpan.a(), localRichSpan.b(), null, 8, null);
      }
      m += 1;
    }
  }
  
  private final boolean d()
  {
    Log.d("RichEditText", "delKeyOnSameSelection.");
    RichSpan localRichSpan = getRichSpanOrNullIfBehind();
    if (localRichSpan != null)
    {
      int m = getText().getSpanStart(localRichSpan);
      int n = getText().getSpanEnd(localRichSpan);
      if ((localRichSpan.a() == EditObject.CREATOR.a()) && (!this.e))
      {
        if (!this.f) {
          return true;
        }
        getText().delete(m, n);
        EditObjectListener localEditObjectListener = this.i;
        if (localEditObjectListener != null)
        {
          EditObjectListener.DefaultImpls.a(localEditObjectListener, false, EditObject.CREATOR.a(), localRichSpan.b(), null, 8, null);
          return true;
        }
      }
      else
      {
        setSelection(m, n);
      }
      return true;
    }
    return false;
  }
  
  private final RichSpan getFirstTopicSpan()
  {
    Object localObject = getText();
    int n = getText().length();
    int m = 0;
    localObject = (RichSpan[])((Editable)localObject).getSpans(0, n, RichSpan.class);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "spans");
    n = localObject.length;
    while (m < n)
    {
      RichSpan localRichSpan = localObject[m];
      if (localRichSpan.a() == EditObject.CREATOR.a()) {
        return localRichSpan;
      }
      m += 1;
    }
    return null;
  }
  
  public final boolean getAllowDeletedTopic()
  {
    return this.f;
  }
  
  public final boolean getAllowMultiTopic()
  {
    return this.e;
  }
  
  @Nullable
  public final Function0<Unit> getAtInputListener()
  {
    return this.h;
  }
  
  @Nullable
  public final Function1<Integer, Unit> getCountChangeListener()
  {
    return this.g;
  }
  
  public final int getCountLimit()
  {
    return this.d;
  }
  
  @NotNull
  public final ArrayList<EditObject> getDataList()
  {
    return a(0, getText().length());
  }
  
  @Nullable
  public final EditObjectListener getEditObjectListener()
  {
    return this.i;
  }
  
  public final boolean getNeedTextTruncation()
  {
    return this.c;
  }
  
  @Nullable
  public final Function2<Integer, Integer, Unit> getOnSelectionChangeListener()
  {
    return this.j;
  }
  
  @Nullable
  public final RichSpan getRichSpanOrNullIfBehind()
  {
    RichSpan[] arrayOfRichSpan = (RichSpan[])getText().getSpans(getSelectionEnd(), getSelectionEnd(), RichSpan.class);
    Intrinsics.checkExpressionValueIsNotNull(arrayOfRichSpan, "baseRichSpans");
    int m;
    if (arrayOfRichSpan.length == 0) {
      m = 1;
    } else {
      m = 0;
    }
    if (((m ^ 0x1) != 0) && (getText().getSpanEnd(arrayOfRichSpan[0]) == getSelectionEnd())) {
      return arrayOfRichSpan[0];
    }
    return null;
  }
  
  public final int getRichTextColor()
  {
    return this.b;
  }
  
  @NotNull
  public InputConnection onCreateInputConnection(@Nullable EditorInfo paramEditorInfo)
  {
    paramEditorInfo = super.onCreateInputConnection(paramEditorInfo);
    Intrinsics.checkExpressionValueIsNotNull(paramEditorInfo, "target");
    return (InputConnection)new FixSharpConnectionWrapper(this, paramEditorInfo, false);
  }
  
  protected void onSelectionChanged(int paramInt1, int paramInt2)
  {
    super.onSelectionChanged(paramInt1, paramInt2);
    Object localObject = this.j;
    if (localObject != null) {
      localObject = (Unit)((Function2)localObject).invoke(Integer.valueOf(paramInt1), Integer.valueOf(paramInt2));
    }
    setSelection(a(paramInt1), a(paramInt2));
  }
  
  public final void setAllowDeletedTopic(boolean paramBoolean)
  {
    this.f = paramBoolean;
  }
  
  public final void setAllowMultiTopic(boolean paramBoolean)
  {
    this.e = paramBoolean;
  }
  
  public final void setAtInputListener(@Nullable Function0<Unit> paramFunction0)
  {
    this.h = paramFunction0;
  }
  
  public final void setCountChangeListener(@Nullable Function1<? super Integer, Unit> paramFunction1)
  {
    this.g = paramFunction1;
  }
  
  public final void setCountLimit(int paramInt)
  {
    if (paramInt > 0)
    {
      this.d = paramInt;
      if (this.c) {
        setFilters(new InputFilter[] { (InputFilter)new InputFilter.LengthFilter(this.d) });
      }
    }
  }
  
  public final void setEditObjectListener(@Nullable EditObjectListener paramEditObjectListener)
  {
    this.i = paramEditObjectListener;
  }
  
  public final void setNeedTextTruncation(boolean paramBoolean)
  {
    this.c = paramBoolean;
  }
  
  public final void setOnSelectionChangeListener(@Nullable Function2<? super Integer, ? super Integer, Unit> paramFunction2)
  {
    this.j = paramFunction2;
  }
  
  public final void setRichTextColor(int paramInt)
  {
    this.b = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.common.danmaku.edit.views.RichEditText
 * JD-Core Version:    0.7.0.1
 */