package com.tencent.mobileqq.activity.aio.helper;

import android.text.Editable;
import android.text.Selection;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.widget.EditText;
import com.tencent.qphone.base.util.QLog;
import org.jetbrains.annotations.NotNull;

class FullScreenInputHelper$TextChangeInfo
{
  private Editable a;
  private Editable b;
  private Editable c;
  private Editable d;
  private int e;
  private int f;
  private int g;
  private int h = -1;
  
  FullScreenInputHelper$TextChangeInfo(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    this.a = new SpannableStringBuilder(paramCharSequence);
    this.e = paramInt1;
    this.f = paramInt2;
    this.g = paramInt3;
    try
    {
      this.h = a();
      return;
    }
    catch (Throwable paramCharSequence)
    {
      paramCharSequence.printStackTrace();
    }
  }
  
  int a()
  {
    if (this.a.length() <= 0) {
      return -1;
    }
    Object localObject;
    Editable localEditable;
    if ((this.f > 0) && (this.g > 0))
    {
      this.c = ((Editable)this.a.subSequence(0, this.e));
      localObject = this.a;
      this.d = ((Editable)((Editable)localObject).subSequence(this.e + this.f, ((Editable)localObject).length()));
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder("[mix]handle replace prefix: ");
        if (!TextUtils.isEmpty(this.c))
        {
          ((StringBuilder)localObject).append(" prefix tail: ");
          localEditable = this.c;
          ((StringBuilder)localObject).append(localEditable.charAt(localEditable.length() - 1));
        }
        else
        {
          ((StringBuilder)localObject).append("null");
        }
        ((StringBuilder)localObject).append(" suffix: ");
        if (!TextUtils.isEmpty(this.d))
        {
          ((StringBuilder)localObject).append(" suffix head: ");
          ((StringBuilder)localObject).append(this.d.charAt(0));
        }
        else
        {
          ((StringBuilder)localObject).append("null");
        }
        QLog.d("FullScreenInputHelper", 2, new Object[] { localObject });
      }
      if ((TextUtils.isEmpty(this.c)) && (FullScreenInputHelper.a(this.d, "￼"))) {
        return 12;
      }
      if ((TextUtils.isEmpty(this.d)) && (FullScreenInputHelper.b(this.c, "￼"))) {
        return 13;
      }
      if ((FullScreenInputHelper.b(this.c, "￼")) && (FullScreenInputHelper.a(this.d, "\n")))
      {
        if ((this.d.length() >= 2) && (this.d.charAt(1) == "￼".charAt(0))) {
          return 14;
        }
        return 15;
      }
      if ((FullScreenInputHelper.b(this.c, "\n")) && (FullScreenInputHelper.a(this.d, "￼")))
      {
        if (this.c.length() >= 2)
        {
          localObject = this.c;
          if (((Editable)localObject).charAt(((Editable)localObject).length() - 2) == "￼".charAt(0)) {
            return 16;
          }
        }
        return 17;
      }
      return -1;
    }
    if (this.f > 0)
    {
      this.c = ((Editable)this.a.subSequence(0, this.e));
      localObject = this.a;
      this.d = ((Editable)((Editable)localObject).subSequence(this.e + this.f, ((Editable)localObject).length()));
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder("[mix]handle delete prefix: ");
        if (!TextUtils.isEmpty(this.c))
        {
          ((StringBuilder)localObject).append(" prefix tail: ");
          localEditable = this.c;
          ((StringBuilder)localObject).append(localEditable.charAt(localEditable.length() - 1));
        }
        else
        {
          ((StringBuilder)localObject).append("null");
        }
        ((StringBuilder)localObject).append(" suffix: ");
        if (!TextUtils.isEmpty(this.d))
        {
          ((StringBuilder)localObject).append(" suffix head: ");
          ((StringBuilder)localObject).append(this.d.charAt(0));
        }
        else
        {
          ((StringBuilder)localObject).append("null");
        }
        QLog.d("FullScreenInputHelper", 2, new Object[] { localObject });
      }
      localObject = this.a;
      int i = this.e;
      localObject = ((Editable)localObject).subSequence(i, this.f + i).toString();
      if ((((String)localObject).length() == 1) && (((String)localObject).equals("\n")))
      {
        if ((FullScreenInputHelper.b(this.c, "￼")) && (FullScreenInputHelper.a(this.d, "￼"))) {
          return 6;
        }
        if ((!FullScreenInputHelper.b(this.c, "￼")) && (!FullScreenInputHelper.b(this.c, "\n")) && (FullScreenInputHelper.a(this.d, "￼"))) {
          return 8;
        }
        if ((FullScreenInputHelper.b(this.c, "￼")) && (!FullScreenInputHelper.a(this.d, "￼")) && (!FullScreenInputHelper.a(this.d, "\n"))) {
          return 7;
        }
        return -1;
      }
      if ((FullScreenInputHelper.b(this.c, "￼")) && (FullScreenInputHelper.a(this.d, "￼"))) {
        return 9;
      }
      if ((!FullScreenInputHelper.b(this.c, "￼")) && (!FullScreenInputHelper.b(this.c, "\n")) && (FullScreenInputHelper.a(this.d, "￼"))) {
        return 10;
      }
      if ((FullScreenInputHelper.b(this.c, "￼")) && (!FullScreenInputHelper.a(this.d, "￼")) && (!FullScreenInputHelper.a(this.d, "\n"))) {
        return 11;
      }
      return -1;
    }
    if (this.g > 0)
    {
      this.c = ((Editable)this.a.subSequence(0, this.e));
      localObject = this.a;
      this.d = ((Editable)((Editable)localObject).subSequence(this.e, ((Editable)localObject).length()));
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder("[mix]handle add prefix: ");
        if (!TextUtils.isEmpty(this.c))
        {
          ((StringBuilder)localObject).append(" prefix tail: ");
          localEditable = this.c;
          ((StringBuilder)localObject).append(localEditable.charAt(localEditable.length() - 1));
        }
        else
        {
          ((StringBuilder)localObject).append("null");
        }
        ((StringBuilder)localObject).append(" suffix: ");
        if (!TextUtils.isEmpty(this.d))
        {
          ((StringBuilder)localObject).append(" suffix head: ");
          ((StringBuilder)localObject).append(this.d.charAt(0));
        }
        else
        {
          ((StringBuilder)localObject).append("null");
        }
        QLog.d("FullScreenInputHelper", 2, new Object[] { localObject });
      }
      if ((TextUtils.isEmpty(this.c)) && (FullScreenInputHelper.a(this.d, "￼"))) {
        return 0;
      }
      if ((TextUtils.isEmpty(this.d)) && (FullScreenInputHelper.b(this.c, "￼"))) {
        return 1;
      }
      if ((FullScreenInputHelper.b(this.c, "￼")) && (FullScreenInputHelper.a(this.d, "\n")))
      {
        if ((this.d.length() >= 2) && (this.d.charAt(1) == "￼".charAt(0))) {
          return 2;
        }
        return 3;
      }
      if ((FullScreenInputHelper.b(this.c, "\n")) && (FullScreenInputHelper.a(this.d, "￼")))
      {
        if (this.c.length() >= 2)
        {
          localObject = this.c;
          if (((Editable)localObject).charAt(((Editable)localObject).length() - 2) == "￼".charAt(0)) {
            return 4;
          }
        }
        return 5;
      }
    }
    return -1;
  }
  
  void a(Editable paramEditable)
  {
    this.b = paramEditable;
  }
  
  void a(EditText paramEditText)
  {
    if (this.b.length() <= 0) {
      return;
    }
    Editable localEditable = b();
    paramEditText = paramEditText.getText();
    int i = Selection.getSelectionStart(paramEditText);
    int j = i;
    if (this.e == this.a.length())
    {
      j = i;
      if (FullScreenInputHelper.b(localEditable, "￼"))
      {
        localEditable.append("\n");
        j = i + 1;
      }
    }
    i = this.h;
    int k = 2;
    Object localObject;
    switch (i)
    {
    default: 
      i = j;
      if (!QLog.isColorLevel()) {
        break label2127;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[mix] handle other at position: ");
      ((StringBuilder)localObject).append(this.e);
      QLog.d("FullScreenInputHelper", 2, ((StringBuilder)localObject).toString());
      i = j;
      break;
    case 17: 
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("[mix] handle replace '[text]\\n_[img]' at position: ");
        ((StringBuilder)localObject).append(this.e);
        ((StringBuilder)localObject).append(" prefix: ");
        ((StringBuilder)localObject).append(this.c);
        ((StringBuilder)localObject).append(" suffix: ");
        ((StringBuilder)localObject).append(this.d);
        QLog.d("FullScreenInputHelper", 2, ((StringBuilder)localObject).toString());
      }
      i = j;
      if (FullScreenInputHelper.b(localEditable, "\n")) {
        break label2127;
      }
      localEditable.append("\n");
      break;
    case 16: 
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("[mix] handle replace '[img]\\n_[img]' at position: ");
        ((StringBuilder)localObject).append(this.e);
        ((StringBuilder)localObject).append(" prefix: ");
        ((StringBuilder)localObject).append(this.c);
        ((StringBuilder)localObject).append(" suffix: ");
        ((StringBuilder)localObject).append(this.d);
        QLog.d("FullScreenInputHelper", 2, ((StringBuilder)localObject).toString());
      }
      i = j;
      if (FullScreenInputHelper.b(localEditable, "\n")) {
        break label2127;
      }
      localEditable.append("\n");
      break;
    case 15: 
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("[mix] handle replace '[img]_\\n[text]' at position: ");
        ((StringBuilder)localObject).append(this.e);
        ((StringBuilder)localObject).append(" prefix: ");
        ((StringBuilder)localObject).append(this.c);
        ((StringBuilder)localObject).append(" suffix: ");
        ((StringBuilder)localObject).append(this.d);
        QLog.d("FullScreenInputHelper", 2, ((StringBuilder)localObject).toString());
      }
      i = j;
      if (FullScreenInputHelper.a(localEditable, "\n")) {
        break label2127;
      }
      localEditable.insert(0, "\n");
      if (FullScreenInputHelper.b(localEditable, "￼")) {
        i = k;
      }
      break;
    case 14: 
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("[mix] handle replace '[img]_\\n[img]' at position: ");
        ((StringBuilder)localObject).append(this.e);
        ((StringBuilder)localObject).append(" prefix: ");
        ((StringBuilder)localObject).append(this.c);
        ((StringBuilder)localObject).append(" suffix: ");
        ((StringBuilder)localObject).append(this.d);
        QLog.d("FullScreenInputHelper", 2, ((StringBuilder)localObject).toString());
      }
      i = j;
      if (FullScreenInputHelper.a(localEditable, "\n")) {
        break label2127;
      }
      localEditable.insert(0, "\n");
      break;
    case 13: 
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("[mix] handle replace '[img]_' at position: ");
        ((StringBuilder)localObject).append(this.e);
        ((StringBuilder)localObject).append(" prefix: ");
        ((StringBuilder)localObject).append(this.c);
        ((StringBuilder)localObject).append(" suffix: ");
        ((StringBuilder)localObject).append(this.d);
        QLog.d("FullScreenInputHelper", 2, ((StringBuilder)localObject).toString());
      }
      localEditable.insert(0, "\n");
      break;
    case 12: 
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("[mix] handle replace '_[img]' at position: ");
        ((StringBuilder)localObject).append(this.e);
        ((StringBuilder)localObject).append(" prefix: ");
        ((StringBuilder)localObject).append(this.c);
        ((StringBuilder)localObject).append(" suffix: ");
        ((StringBuilder)localObject).append(this.d);
        QLog.d("FullScreenInputHelper", 2, ((StringBuilder)localObject).toString());
      }
      localEditable.append("\n");
      break;
    case 11: 
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("[mix] handle del '[img]_[text]' at position: ");
        ((StringBuilder)localObject).append(this.e);
        ((StringBuilder)localObject).append(" prefix: ");
        ((StringBuilder)localObject).append(this.c);
        ((StringBuilder)localObject).append(" suffix: ");
        ((StringBuilder)localObject).append(this.d);
        QLog.d("FullScreenInputHelper", 2, ((StringBuilder)localObject).toString());
      }
      this.c.append("\n");
      break;
    case 10: 
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("[mix] handle del '[text]_[img]' at position: ");
        ((StringBuilder)localObject).append(this.e);
        ((StringBuilder)localObject).append(" prefix: ");
        ((StringBuilder)localObject).append(this.c);
        ((StringBuilder)localObject).append(" suffix: ");
        ((StringBuilder)localObject).append(this.d);
        QLog.d("FullScreenInputHelper", 2, ((StringBuilder)localObject).toString());
      }
      this.c.append("\n");
      i = j;
      break;
    case 9: 
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("[mix] handle del '[img]_[img]' at position: ");
        ((StringBuilder)localObject).append(this.e);
        ((StringBuilder)localObject).append(" prefix: ");
        ((StringBuilder)localObject).append(this.c);
        ((StringBuilder)localObject).append(" suffix: ");
        ((StringBuilder)localObject).append(this.d);
        QLog.d("FullScreenInputHelper", 2, ((StringBuilder)localObject).toString());
      }
      this.c.append("\n");
      break;
    case 8: 
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("[mix] handle del line '[text]_\\n_[img]' at position: ");
        ((StringBuilder)localObject).append(this.e);
        ((StringBuilder)localObject).append(" prefix: ");
        ((StringBuilder)localObject).append(this.c);
        ((StringBuilder)localObject).append(" suffix: ");
        ((StringBuilder)localObject).append(this.d);
        QLog.d("FullScreenInputHelper", 2, ((StringBuilder)localObject).toString());
      }
      localObject = this.c;
      ((Editable)localObject).delete(((Editable)localObject).length() - 1, this.c.length());
      this.c.append("\n");
      break;
    case 7: 
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("[mix] handle del line '[img]_\\n_[text]' at position: ");
        ((StringBuilder)localObject).append(this.e);
        ((StringBuilder)localObject).append(" prefix: ");
        ((StringBuilder)localObject).append(this.c);
        ((StringBuilder)localObject).append(" suffix: ");
        ((StringBuilder)localObject).append(this.d);
        QLog.d("FullScreenInputHelper", 2, ((StringBuilder)localObject).toString());
      }
      localObject = this.c;
      ((Editable)localObject).delete(((Editable)localObject).length() - 1, this.c.length());
      break;
    case 6: 
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("[mix] handle del line '[img]_\\n_[img]' at position: ");
        ((StringBuilder)localObject).append(this.e);
        ((StringBuilder)localObject).append(" prefix: ");
        ((StringBuilder)localObject).append(this.c);
        ((StringBuilder)localObject).append(" suffix: ");
        ((StringBuilder)localObject).append(this.d);
        QLog.d("FullScreenInputHelper", 2, ((StringBuilder)localObject).toString());
      }
      localObject = this.c;
      ((Editable)localObject).delete(((Editable)localObject).length() - 1, this.c.length());
      i = j - 1;
      break;
    case 5: 
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("[mix] handle add '[text]\\n_[img]' at position: ");
        ((StringBuilder)localObject).append(this.e);
        ((StringBuilder)localObject).append(" prefix: ");
        ((StringBuilder)localObject).append(this.c);
        ((StringBuilder)localObject).append(" suffix: ");
        ((StringBuilder)localObject).append(this.d);
        QLog.d("FullScreenInputHelper", 2, ((StringBuilder)localObject).toString());
      }
      i = j;
      if (FullScreenInputHelper.b(localEditable, "\n")) {
        break label2127;
      }
      localEditable.append("\n");
      i = j;
      break;
    case 4: 
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("[mix] handle add '[img]\\n_[img]' at position: ");
        ((StringBuilder)localObject).append(this.e);
        ((StringBuilder)localObject).append(" prefix: ");
        ((StringBuilder)localObject).append(this.c);
        ((StringBuilder)localObject).append(" suffix: ");
        ((StringBuilder)localObject).append(this.d);
        QLog.d("FullScreenInputHelper", 2, ((StringBuilder)localObject).toString());
      }
      i = j;
      if (FullScreenInputHelper.b(localEditable, "\n")) {
        break label2127;
      }
      localEditable.append("\n");
      i = j;
      break;
    case 3: 
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("[mix] handle add '[img]_\\n[text]' at position: ");
        ((StringBuilder)localObject).append(this.e);
        ((StringBuilder)localObject).append(" prefix: ");
        ((StringBuilder)localObject).append(this.c);
        ((StringBuilder)localObject).append(" suffix: ");
        ((StringBuilder)localObject).append(this.d);
        QLog.d("FullScreenInputHelper", 2, ((StringBuilder)localObject).toString());
      }
      i = j;
      if (FullScreenInputHelper.a(localEditable, "\n")) {
        break label2127;
      }
      localEditable.insert(0, "\n");
      if (FullScreenInputHelper.b(localEditable, "￼")) {
        i = k;
      } else {
        i = 1;
      }
      i = j + i;
      break;
    case 2: 
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("[mix] handle add '[img]_\\n[img]' at position: ");
        ((StringBuilder)localObject).append(this.e);
        ((StringBuilder)localObject).append(" prefix: ");
        ((StringBuilder)localObject).append(this.c);
        ((StringBuilder)localObject).append(" suffix: ");
        ((StringBuilder)localObject).append(this.d);
        QLog.d("FullScreenInputHelper", 2, ((StringBuilder)localObject).toString());
      }
      i = j;
      if (FullScreenInputHelper.a(localEditable, "\n")) {
        break label2127;
      }
      localEditable.insert(0, "\n");
      break;
    case 1: 
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("[mix] handle add '[img]_' at position: ");
        ((StringBuilder)localObject).append(this.e);
        ((StringBuilder)localObject).append(" prefix: ");
        ((StringBuilder)localObject).append(this.c);
        ((StringBuilder)localObject).append(" suffix: ");
        ((StringBuilder)localObject).append(this.d);
        QLog.d("FullScreenInputHelper", 2, ((StringBuilder)localObject).toString());
      }
      localEditable.insert(0, "\n");
      i = j + 1;
      break;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[mix] handle add '_[img]' at position: ");
      ((StringBuilder)localObject).append(this.e);
      ((StringBuilder)localObject).append(" prefix: ");
      ((StringBuilder)localObject).append(this.c);
      ((StringBuilder)localObject).append(" suffix: ");
      ((StringBuilder)localObject).append(this.d);
      QLog.d("FullScreenInputHelper", 2, ((StringBuilder)localObject).toString());
    }
    localEditable.append("\n");
    i = j;
    label2127:
    if (this.h != -1)
    {
      localObject = new SpannableStringBuilder();
      if (!TextUtils.isEmpty(this.c)) {
        ((Editable)localObject).append(this.c);
      }
      if (!TextUtils.isEmpty(localEditable)) {
        ((Editable)localObject).append(localEditable);
      }
      if (!TextUtils.isEmpty(this.d)) {
        ((Editable)localObject).append(this.d);
      }
      FullScreenInputHelper.g(false);
      paramEditText.replace(0, paramEditText.length(), (CharSequence)localObject);
      Selection.setSelection(paramEditText, Math.min(i, ((Editable)localObject).length()));
      FullScreenInputHelper.g(true);
    }
  }
  
  Editable b()
  {
    int i = this.g;
    if (i <= 0) {
      return new SpannableStringBuilder();
    }
    Editable localEditable = this.b;
    if (localEditable != null)
    {
      int j = this.e;
      return (Editable)localEditable.subSequence(j, i + j);
    }
    return new SpannableStringBuilder();
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("<TextChangeInfo> {textBefore: ");
    localStringBuilder.append(this.a);
    localStringBuilder.append(" textAfter: ");
    localStringBuilder.append(this.b);
    localStringBuilder.append(" indexChange: ");
    localStringBuilder.append(this.e);
    localStringBuilder.append(" countAdded: ");
    localStringBuilder.append(this.g);
    localStringBuilder.append(" countDeleted: ");
    localStringBuilder.append(this.f);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.FullScreenInputHelper.TextChangeInfo
 * JD-Core Version:    0.7.0.1
 */