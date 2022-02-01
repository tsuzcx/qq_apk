package com.tencent.common.danmaku.edit;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.common.danmaku.edit.listener.EditDanmakuListener;
import com.tencent.common.danmaku.edit.views.RichEditText;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/common/danmaku/edit/EditDanmakuDialog;", "Landroid/app/Dialog;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "clearIconView", "Landroid/widget/ImageView;", "contentView", "Lcom/tencent/common/danmaku/edit/views/RichEditText;", "value", "", "countLimit", "getCountLimit", "()I", "setCountLimit", "(I)V", "countLimitView", "Landroid/widget/TextView;", "editDanmakuListener", "Lcom/tencent/common/danmaku/edit/listener/EditDanmakuListener;", "getEditDanmakuListener", "()Lcom/tencent/common/danmaku/edit/listener/EditDanmakuListener;", "setEditDanmakuListener", "(Lcom/tencent/common/danmaku/edit/listener/EditDanmakuListener;)V", "", "hint", "getHint", "()Ljava/lang/String;", "setHint", "(Ljava/lang/String;)V", "lastContent", "getLastContent", "setLastContent", "primaryColor", "getPrimaryColor", "setPrimaryColor", "publishTextView", "rootView", "Landroid/view/View;", "onAttachedToWindow", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDetachedFromWindow", "updatePublishLayoutStyle", "isValid", "", "qqdanmaku_release"}, k=1, mv={1, 1, 16})
public final class EditDanmakuDialog
  extends ReportDialog
{
  private int a = 14;
  @NotNull
  private String b = "";
  @NotNull
  private String c = "";
  @Nullable
  private EditDanmakuListener d;
  @NotNull
  private String e = "#FFD522";
  private final View f;
  private final RichEditText g;
  private final ImageView h;
  private final TextView i;
  private final TextView j;
  
  public EditDanmakuDialog(@NotNull Context paramContext)
  {
    super(paramContext, 2131952353);
    paramContext = LayoutInflater.from(paramContext).inflate(2131624637, null);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "LayoutInflater.from(cont…dit_dialog_message, null)");
    this.f = paramContext;
    paramContext = this.f;
    View localView = paramContext.findViewById(2131432618);
    Intrinsics.checkExpressionValueIsNotNull(localView, "findViewById(R.id.et_content)");
    this.g = ((RichEditText)localView);
    localView = paramContext.findViewById(2131436316);
    Intrinsics.checkExpressionValueIsNotNull(localView, "findViewById(R.id.iv_clear)");
    this.h = ((ImageView)localView);
    localView = paramContext.findViewById(2131448358);
    Intrinsics.checkExpressionValueIsNotNull(localView, "findViewById(R.id.tv_count_limit)");
    this.i = ((TextView)localView);
    paramContext = paramContext.findViewById(2131448662);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "findViewById(R.id.tv_publish)");
    this.j = ((TextView)paramContext);
    this.g.setImeOptions(268435456);
    this.g.setCountChangeListener((Function1)new EditDanmakuDialog..special..inlined.with.lambda.1(this));
    this.g.setNeedTextTruncation(true);
    this.g.setOnEditorActionListener((TextView.OnEditorActionListener)new EditDanmakuDialog..special..inlined.with.lambda.2(this));
    this.h.setOnClickListener((View.OnClickListener)new EditDanmakuDialog..special..inlined.with.lambda.3(this));
    this.j.setEnabled(false);
    this.j.setOnClickListener((View.OnClickListener)new EditDanmakuDialog..special..inlined.with.lambda.4(this));
  }
  
  private final void a(boolean paramBoolean)
  {
    String str;
    if (paramBoolean) {
      str = "#FFFFFF";
    } else {
      str = "#B0B3BF";
    }
    int k = Color.parseColor(str);
    this.j.setTextColor(k);
    if (paramBoolean) {
      str = this.e;
    } else {
      str = "#EBEDF5";
    }
    k = Color.parseColor(str);
    this.j.setBackgroundColor(k);
    this.j.setEnabled(paramBoolean);
  }
  
  public final int a()
  {
    return this.a;
  }
  
  public final void a(int paramInt)
  {
    this.a = paramInt;
    this.g.setCountLimit(paramInt);
    this.i.setText((CharSequence)String.valueOf(paramInt - this.g.getText().length()));
  }
  
  public final void a(@Nullable EditDanmakuListener paramEditDanmakuListener)
  {
    this.d = paramEditDanmakuListener;
  }
  
  public final void a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "value");
    this.b = paramString;
    this.g.setHint((CharSequence)paramString);
  }
  
  @Nullable
  public final EditDanmakuListener b()
  {
    return this.d;
  }
  
  public final void b(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "<set-?>");
    this.c = paramString;
  }
  
  public final void c(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "<set-?>");
    this.e = paramString;
  }
  
  public void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    Object localObject = this.d;
    if (localObject != null) {
      ((EditDanmakuListener)localObject).a();
    }
    this.g.setText((CharSequence)this.c);
    localObject = this.g;
    ((RichEditText)localObject).setSelection(((RichEditText)localObject).getText().length());
    this.c = "";
    this.g.postDelayed((Runnable)new EditDanmakuDialog.onAttachedToWindow.1(this), 300L);
  }
  
  protected void onCreate(@Nullable Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = getWindow();
    if (paramBundle != null) {
      paramBundle.setContentView(this.f);
    }
    paramBundle = getWindow();
    if (paramBundle != null)
    {
      paramBundle = paramBundle.getAttributes();
      if (paramBundle != null)
      {
        paramBundle.width = -1;
        paramBundle.height = -2;
        paramBundle.gravity = 80;
        break label62;
      }
    }
    paramBundle = null;
    label62:
    Window localWindow = getWindow();
    if (localWindow != null) {
      localWindow.setAttributes(paramBundle);
    }
    setCanceledOnTouchOutside(true);
  }
  
  public void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    EditDanmakuListener localEditDanmakuListener = this.d;
    if (localEditDanmakuListener != null) {
      localEditDanmakuListener.a(this.g.getText().toString());
    }
    this.g.clearFocus();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.common.danmaku.edit.EditDanmakuDialog
 * JD-Core Version:    0.7.0.1
 */