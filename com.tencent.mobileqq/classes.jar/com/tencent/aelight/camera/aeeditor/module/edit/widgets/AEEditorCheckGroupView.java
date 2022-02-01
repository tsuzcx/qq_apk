package com.tencent.aelight.camera.aeeditor.module.edit.widgets;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.widget.Checkable;
import android.widget.LinearLayout;
import android.widget.TextView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/aelight/camera/aeeditor/module/edit/widgets/AEEditorCheckGroupView;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "checked", "checkedChangeListener", "Lcom/tencent/aelight/camera/aeeditor/module/edit/widgets/AEEditorCheckGroupView$OnCheckedChangeListener;", "lastClickTime", "", "check", "", "id", "getCheckIndex", "innerCheck", "stickClicked", "", "index", "boldText", "isDoubleClick", "setOnCheckedChangeListener", "listener", "Companion", "OnCheckedChangeListener", "aelight_impl_release"}, k=1, mv={1, 1, 16})
public final class AEEditorCheckGroupView
  extends LinearLayout
{
  public static final AEEditorCheckGroupView.Companion a = new AEEditorCheckGroupView.Companion(null);
  private int b = -1;
  private AEEditorCheckGroupView.OnCheckedChangeListener c;
  private long d;
  
  public AEEditorCheckGroupView(@Nullable Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, -1);
  }
  
  public AEEditorCheckGroupView(@Nullable Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramContext = getViewTreeObserver();
    if (paramContext != null) {
      paramContext.addOnPreDrawListener((ViewTreeObserver.OnPreDrawListener)new AEEditorCheckGroupView.1(this));
    }
  }
  
  private final void a(boolean paramBoolean1, int paramInt, boolean paramBoolean2, boolean paramBoolean3)
  {
    if (paramInt != this.b)
    {
      Object localObject1 = getChildAt(paramInt);
      Object localObject2 = this.c;
      if (localObject2 != null)
      {
        Intrinsics.checkExpressionValueIsNotNull(localObject1, "vCurrChecked");
        if (((AEEditorCheckGroupView.OnCheckedChangeListener)localObject2).a(paramBoolean1, this, ((View)localObject1).getId()) == true)
        {
          ((View)localObject1).setSelected(true);
          if (!(localObject1 instanceof Checkable)) {
            localObject2 = null;
          } else {
            localObject2 = localObject1;
          }
          localObject2 = (Checkable)localObject2;
          if (localObject2 != null) {
            ((Checkable)localObject2).setChecked(true);
          }
          ViewGroup localViewGroup;
          if (paramBoolean2)
          {
            if (!(localObject1 instanceof ViewGroup)) {
              localObject2 = null;
            } else {
              localObject2 = localObject1;
            }
            if ((ViewGroup)localObject2 != null)
            {
              localViewGroup = (ViewGroup)localObject1;
              j = localViewGroup.getChildCount();
              if (j >= 0)
              {
                i = 0;
                for (;;)
                {
                  localObject2 = localViewGroup.getChildAt(i);
                  localObject1 = localObject2;
                  if (!(localObject2 instanceof TextView)) {
                    localObject1 = null;
                  }
                  localObject1 = (TextView)localObject1;
                  if (localObject1 != null) {
                    ((TextView)localObject1).setTypeface(null, 1);
                  }
                  if (i == j) {
                    break;
                  }
                  i += 1;
                }
              }
            }
          }
          int i = getChildCount();
          int j = this.b;
          if ((j >= 0) && (i > j))
          {
            localObject1 = getChildAt(j);
            if (localObject1 != null) {
              ((View)localObject1).setSelected(false);
            }
            if (!(localObject1 instanceof Checkable)) {
              localObject2 = null;
            } else {
              localObject2 = localObject1;
            }
            localObject2 = (Checkable)localObject2;
            if (localObject2 != null) {
              ((Checkable)localObject2).setChecked(false);
            }
            if (paramBoolean2)
            {
              if (!(localObject1 instanceof ViewGroup)) {
                localObject2 = null;
              } else {
                localObject2 = localObject1;
              }
              if ((ViewGroup)localObject2 != null)
              {
                localViewGroup = (ViewGroup)localObject1;
                j = localViewGroup.getChildCount();
                if (j >= 0)
                {
                  i = 0;
                  for (;;)
                  {
                    localObject2 = localViewGroup.getChildAt(i);
                    localObject1 = localObject2;
                    if (!(localObject2 instanceof TextView)) {
                      localObject1 = null;
                    }
                    localObject1 = (TextView)localObject1;
                    if (localObject1 != null) {
                      ((TextView)localObject1).setTypeface(null, 0);
                    }
                    if (i == j) {
                      break;
                    }
                    i += 1;
                  }
                }
              }
            }
          }
          this.b = paramInt;
        }
      }
    }
  }
  
  public final void a(int paramInt)
  {
    int j = getChildCount();
    if (j >= 0)
    {
      int i = 0;
      for (;;)
      {
        View localView = getChildAt(i);
        if ((localView != null) && (localView.getId() == paramInt)) {
          a(this, true, i, false, false, 12, null);
        }
        if (i == j) {
          break;
        }
        i += 1;
      }
    }
  }
  
  public final int getCheckIndex()
  {
    return this.b;
  }
  
  public final void setOnCheckedChangeListener(@NotNull AEEditorCheckGroupView.OnCheckedChangeListener paramOnCheckedChangeListener)
  {
    Intrinsics.checkParameterIsNotNull(paramOnCheckedChangeListener, "listener");
    this.c = paramOnCheckedChangeListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.module.edit.widgets.AEEditorCheckGroupView
 * JD-Core Version:    0.7.0.1
 */