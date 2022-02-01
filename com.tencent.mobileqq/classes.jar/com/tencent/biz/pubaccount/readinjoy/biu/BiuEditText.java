package com.tencent.biz.pubaccount.readinjoy.biu;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.widget.EditText;
import com.tencent.biz.pubaccount.readinjoy.view.text.DeleteAsAWholeSpan;
import com.tencent.biz.pubaccount.readinjoy.view.text.DeleteAsAWholeWatcher;
import com.tencent.biz.pubaccount.readinjoy.view.text.ISpan;
import com.tencent.biz.pubaccount.readinjoy.view.text.TopicSpan;
import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.jetbrains.annotations.NotNull;

public class BiuEditText
  extends EditText
{
  private TextWatcher jdField_a_of_type_AndroidTextTextWatcher;
  private boolean jdField_a_of_type_Boolean = true;
  private boolean b = true;
  
  public BiuEditText(Context paramContext)
  {
    super(paramContext);
    c();
    b();
  }
  
  public BiuEditText(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    c();
    b();
  }
  
  private int a(int paramInt)
  {
    Editable localEditable = getEditableText();
    int j;
    if (localEditable == null)
    {
      j = 0;
      return j;
    }
    ISpan[] arrayOfISpan = (ISpan[])localEditable.getSpans(0, getText().length(), ISpan.class);
    if (QLog.isColorLevel()) {
      QLog.d("BiuEditText", 2, "getValidSelPosForRichText spans num : " + arrayOfISpan.length);
    }
    if ((paramInt == 0) && (!this.jdField_a_of_type_Boolean) && (arrayOfISpan.length != 0) && ((arrayOfISpan[0] instanceof TopicSpan))) {}
    for (int i = 1; i != 0; i = 0) {
      return localEditable.getSpanEnd(arrayOfISpan[0]);
    }
    int k = arrayOfISpan.length;
    i = 0;
    for (;;)
    {
      j = paramInt;
      if (i >= k) {
        break;
      }
      localEditable = arrayOfISpan[i];
      j = getText().getSpanStart(localEditable);
      int m = getText().getSpanEnd(localEditable);
      if ((j + 1 <= paramInt) && (m >= paramInt)) {
        return m;
      }
      i += 1;
    }
  }
  
  private String a(int paramInt1, int paramInt2, ISpan[] paramArrayOfISpan)
  {
    int i = 0;
    if (QLog.isColorLevel()) {
      QLog.d("BiuEditText", 2, "getValidSelPosForRichText startCalPos :" + paramInt1 + " endCalPos :" + paramInt2);
    }
    ISpan[] arrayOfISpan = a(paramArrayOfISpan);
    Editable localEditable = getEditableText();
    paramArrayOfISpan = "" + localEditable.subSequence(paramInt1, localEditable.getSpanStart(arrayOfISpan[0]));
    while (i < arrayOfISpan.length)
    {
      localObject = paramArrayOfISpan + localEditable.subSequence(localEditable.getSpanStart(arrayOfISpan[i]), localEditable.getSpanEnd(arrayOfISpan[i]));
      paramInt1 = localEditable.getSpanEnd(arrayOfISpan[i]);
      paramArrayOfISpan = (ISpan[])localObject;
      if (i < arrayOfISpan.length - 1)
      {
        paramArrayOfISpan = (String)localObject + localEditable.subSequence(localEditable.getSpanEnd(arrayOfISpan[i]), localEditable.getSpanStart(arrayOfISpan[(i + 1)]));
        paramInt1 = localEditable.getSpanStart(arrayOfISpan[(i + 1)]);
      }
      i += 1;
    }
    Object localObject = paramArrayOfISpan;
    if (paramInt1 < paramInt2) {
      localObject = paramArrayOfISpan + localEditable.subSequence(paramInt1, paramInt2);
    }
    return localObject;
  }
  
  private boolean a()
  {
    boolean bool1 = false;
    boolean bool2 = false;
    Editable localEditable = getEditableText();
    if (localEditable == null) {
      return bool2;
    }
    TopicSpan[] arrayOfTopicSpan = (TopicSpan[])localEditable.getSpans(0, localEditable.length(), TopicSpan.class);
    int j = arrayOfTopicSpan.length;
    int i = 0;
    for (;;)
    {
      bool2 = bool1;
      if (i >= j) {
        break;
      }
      TopicSpan localTopicSpan = arrayOfTopicSpan[i];
      if (getSelectionStart() == localEditable.getSpanEnd(localTopicSpan)) {
        bool1 = true;
      }
      i += 1;
    }
  }
  
  private boolean a(KeyEvent paramKeyEvent, int paramInt)
  {
    if ((paramInt != 67) || (paramKeyEvent.getAction() != 0)) {}
    while ((getSelectionStart() != getSelectionEnd()) || (!a()) || (this.jdField_a_of_type_Boolean) || (this.b)) {
      return false;
    }
    return true;
  }
  
  private ISpan[] a(@NotNull ISpan[] paramArrayOfISpan)
  {
    ISpan[] arrayOfISpan = new ISpan[paramArrayOfISpan.length];
    Editable localEditable = getEditableText();
    paramArrayOfISpan = Arrays.asList(paramArrayOfISpan);
    Collections.sort(paramArrayOfISpan, new BiuEditText.2(this, localEditable));
    return (ISpan[])paramArrayOfISpan.toArray(arrayOfISpan);
  }
  
  private void b()
  {
    setOnKeyListener(new BiuEditText.1(this));
  }
  
  private boolean b()
  {
    if (getSelectionStart() == getSelectionEnd()) {
      return false;
    }
    Object localObject = getEditableText();
    if (localObject == null) {
      return false;
    }
    localObject = (ISpan[])((Editable)localObject).getSpans(getSelectionStart(), getSelectionEnd(), ISpan.class);
    if (localObject.length == 0) {
      return false;
    }
    ((ClipboardManager)getContext().getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText(null, a(getSelectionStart(), getSelectionEnd(), (ISpan[])localObject)));
    setSelection(getSelectionEnd());
    return true;
  }
  
  private void c()
  {
    this.jdField_a_of_type_AndroidTextTextWatcher = new DeleteAsAWholeWatcher();
    addTextChangedListener(this.jdField_a_of_type_AndroidTextTextWatcher);
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_AndroidTextTextWatcher != null) {
      removeTextChangedListener(this.jdField_a_of_type_AndroidTextTextWatcher);
    }
  }
  
  public boolean onPrivateIMECommand(String paramString, Bundle paramBundle)
  {
    if ("com.sogou.inputmethod.expression".equals(paramString)) {
      return true;
    }
    return super.onPrivateIMECommand(paramString, paramBundle);
  }
  
  protected void onSelectionChanged(int paramInt1, int paramInt2)
  {
    super.onSelectionChanged(paramInt1, paramInt2);
    setSelection(a(paramInt1), a(paramInt2));
    if (QLog.isColorLevel()) {
      QLog.d("BiuEditText", 2, "onSelectionChanged start : " + paramInt1 + " end : " + paramInt2);
    }
    if (paramInt2 != paramInt1) {}
    for (;;)
    {
      return;
      Editable localEditable = getEditableText();
      if (localEditable != null)
      {
        DeleteAsAWholeSpan[] arrayOfDeleteAsAWholeSpan = (DeleteAsAWholeSpan[])localEditable.getSpans(paramInt1, paramInt2, DeleteAsAWholeSpan.class);
        if ((arrayOfDeleteAsAWholeSpan != null) && (arrayOfDeleteAsAWholeSpan.length > 0))
        {
          int i = arrayOfDeleteAsAWholeSpan.length;
          paramInt2 = 0;
          while (paramInt2 < i)
          {
            DeleteAsAWholeSpan localDeleteAsAWholeSpan = arrayOfDeleteAsAWholeSpan[paramInt2];
            int j = localEditable.getSpanStart(localDeleteAsAWholeSpan);
            int k = localEditable.getSpanEnd(localDeleteAsAWholeSpan);
            if ((j >= 0) && (k >= j) && (paramInt1 > j) && (paramInt1 < k))
            {
              setSelection(k);
              return;
            }
            paramInt2 += 1;
          }
        }
      }
    }
  }
  
  public boolean onTextContextMenuItem(int paramInt)
  {
    if ((paramInt == 16908321) && (b())) {
      return true;
    }
    return super.onTextContextMenuItem(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.biu.BiuEditText
 * JD-Core Version:    0.7.0.1
 */