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
  private int jdField_a_of_type_Int;
  private Editable jdField_a_of_type_AndroidTextEditable;
  private int jdField_b_of_type_Int;
  private Editable jdField_b_of_type_AndroidTextEditable;
  private int jdField_c_of_type_Int;
  private Editable jdField_c_of_type_AndroidTextEditable;
  private int jdField_d_of_type_Int = -1;
  private Editable jdField_d_of_type_AndroidTextEditable;
  
  FullScreenInputHelper$TextChangeInfo(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    this.jdField_a_of_type_AndroidTextEditable = new SpannableStringBuilder(paramCharSequence);
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
    this.jdField_c_of_type_Int = paramInt3;
    try
    {
      this.jdField_d_of_type_Int = a();
      return;
    }
    catch (Throwable paramCharSequence)
    {
      paramCharSequence.printStackTrace();
    }
  }
  
  int a()
  {
    if (this.jdField_a_of_type_AndroidTextEditable.length() <= 0) {
      return -1;
    }
    Object localObject;
    Editable localEditable;
    if ((this.jdField_b_of_type_Int > 0) && (this.jdField_c_of_type_Int > 0))
    {
      this.jdField_c_of_type_AndroidTextEditable = ((Editable)this.jdField_a_of_type_AndroidTextEditable.subSequence(0, this.jdField_a_of_type_Int));
      localObject = this.jdField_a_of_type_AndroidTextEditable;
      this.jdField_d_of_type_AndroidTextEditable = ((Editable)((Editable)localObject).subSequence(this.jdField_a_of_type_Int + this.jdField_b_of_type_Int, ((Editable)localObject).length()));
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder("[mix]handle replace prefix: ");
        if (!TextUtils.isEmpty(this.jdField_c_of_type_AndroidTextEditable))
        {
          ((StringBuilder)localObject).append(" prefix tail: ");
          localEditable = this.jdField_c_of_type_AndroidTextEditable;
          ((StringBuilder)localObject).append(localEditable.charAt(localEditable.length() - 1));
        }
        else
        {
          ((StringBuilder)localObject).append("null");
        }
        ((StringBuilder)localObject).append(" suffix: ");
        if (!TextUtils.isEmpty(this.jdField_d_of_type_AndroidTextEditable))
        {
          ((StringBuilder)localObject).append(" suffix head: ");
          ((StringBuilder)localObject).append(this.jdField_d_of_type_AndroidTextEditable.charAt(0));
        }
        else
        {
          ((StringBuilder)localObject).append("null");
        }
        QLog.d("FullScreenInputHelper", 2, new Object[] { localObject });
      }
      if ((TextUtils.isEmpty(this.jdField_c_of_type_AndroidTextEditable)) && (FullScreenInputHelper.a(this.jdField_d_of_type_AndroidTextEditable, "￼"))) {
        return 12;
      }
      if ((TextUtils.isEmpty(this.jdField_d_of_type_AndroidTextEditable)) && (FullScreenInputHelper.b(this.jdField_c_of_type_AndroidTextEditable, "￼"))) {
        return 13;
      }
      if ((FullScreenInputHelper.b(this.jdField_c_of_type_AndroidTextEditable, "￼")) && (FullScreenInputHelper.a(this.jdField_d_of_type_AndroidTextEditable, "\n")))
      {
        if ((this.jdField_d_of_type_AndroidTextEditable.length() >= 2) && (this.jdField_d_of_type_AndroidTextEditable.charAt(1) == "￼".charAt(0))) {
          return 14;
        }
        return 15;
      }
      if ((FullScreenInputHelper.b(this.jdField_c_of_type_AndroidTextEditable, "\n")) && (FullScreenInputHelper.a(this.jdField_d_of_type_AndroidTextEditable, "￼")))
      {
        if (this.jdField_c_of_type_AndroidTextEditable.length() >= 2)
        {
          localObject = this.jdField_c_of_type_AndroidTextEditable;
          if (((Editable)localObject).charAt(((Editable)localObject).length() - 2) == "￼".charAt(0)) {
            return 16;
          }
        }
        return 17;
      }
      return -1;
    }
    if (this.jdField_b_of_type_Int > 0)
    {
      this.jdField_c_of_type_AndroidTextEditable = ((Editable)this.jdField_a_of_type_AndroidTextEditable.subSequence(0, this.jdField_a_of_type_Int));
      localObject = this.jdField_a_of_type_AndroidTextEditable;
      this.jdField_d_of_type_AndroidTextEditable = ((Editable)((Editable)localObject).subSequence(this.jdField_a_of_type_Int + this.jdField_b_of_type_Int, ((Editable)localObject).length()));
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder("[mix]handle delete prefix: ");
        if (!TextUtils.isEmpty(this.jdField_c_of_type_AndroidTextEditable))
        {
          ((StringBuilder)localObject).append(" prefix tail: ");
          localEditable = this.jdField_c_of_type_AndroidTextEditable;
          ((StringBuilder)localObject).append(localEditable.charAt(localEditable.length() - 1));
        }
        else
        {
          ((StringBuilder)localObject).append("null");
        }
        ((StringBuilder)localObject).append(" suffix: ");
        if (!TextUtils.isEmpty(this.jdField_d_of_type_AndroidTextEditable))
        {
          ((StringBuilder)localObject).append(" suffix head: ");
          ((StringBuilder)localObject).append(this.jdField_d_of_type_AndroidTextEditable.charAt(0));
        }
        else
        {
          ((StringBuilder)localObject).append("null");
        }
        QLog.d("FullScreenInputHelper", 2, new Object[] { localObject });
      }
      localObject = this.jdField_a_of_type_AndroidTextEditable;
      int i = this.jdField_a_of_type_Int;
      localObject = ((Editable)localObject).subSequence(i, this.jdField_b_of_type_Int + i).toString();
      if ((((String)localObject).length() == 1) && (((String)localObject).equals("\n")))
      {
        if ((FullScreenInputHelper.b(this.jdField_c_of_type_AndroidTextEditable, "￼")) && (FullScreenInputHelper.a(this.jdField_d_of_type_AndroidTextEditable, "￼"))) {
          return 6;
        }
        if ((!FullScreenInputHelper.b(this.jdField_c_of_type_AndroidTextEditable, "￼")) && (!FullScreenInputHelper.b(this.jdField_c_of_type_AndroidTextEditable, "\n")) && (FullScreenInputHelper.a(this.jdField_d_of_type_AndroidTextEditable, "￼"))) {
          return 8;
        }
        if ((FullScreenInputHelper.b(this.jdField_c_of_type_AndroidTextEditable, "￼")) && (!FullScreenInputHelper.a(this.jdField_d_of_type_AndroidTextEditable, "￼")) && (!FullScreenInputHelper.a(this.jdField_d_of_type_AndroidTextEditable, "\n"))) {
          return 7;
        }
        return -1;
      }
      if ((FullScreenInputHelper.b(this.jdField_c_of_type_AndroidTextEditable, "￼")) && (FullScreenInputHelper.a(this.jdField_d_of_type_AndroidTextEditable, "￼"))) {
        return 9;
      }
      if ((!FullScreenInputHelper.b(this.jdField_c_of_type_AndroidTextEditable, "￼")) && (!FullScreenInputHelper.b(this.jdField_c_of_type_AndroidTextEditable, "\n")) && (FullScreenInputHelper.a(this.jdField_d_of_type_AndroidTextEditable, "￼"))) {
        return 10;
      }
      if ((FullScreenInputHelper.b(this.jdField_c_of_type_AndroidTextEditable, "￼")) && (!FullScreenInputHelper.a(this.jdField_d_of_type_AndroidTextEditable, "￼")) && (!FullScreenInputHelper.a(this.jdField_d_of_type_AndroidTextEditable, "\n"))) {
        return 11;
      }
      return -1;
    }
    if (this.jdField_c_of_type_Int > 0)
    {
      this.jdField_c_of_type_AndroidTextEditable = ((Editable)this.jdField_a_of_type_AndroidTextEditable.subSequence(0, this.jdField_a_of_type_Int));
      localObject = this.jdField_a_of_type_AndroidTextEditable;
      this.jdField_d_of_type_AndroidTextEditable = ((Editable)((Editable)localObject).subSequence(this.jdField_a_of_type_Int, ((Editable)localObject).length()));
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder("[mix]handle add prefix: ");
        if (!TextUtils.isEmpty(this.jdField_c_of_type_AndroidTextEditable))
        {
          ((StringBuilder)localObject).append(" prefix tail: ");
          localEditable = this.jdField_c_of_type_AndroidTextEditable;
          ((StringBuilder)localObject).append(localEditable.charAt(localEditable.length() - 1));
        }
        else
        {
          ((StringBuilder)localObject).append("null");
        }
        ((StringBuilder)localObject).append(" suffix: ");
        if (!TextUtils.isEmpty(this.jdField_d_of_type_AndroidTextEditable))
        {
          ((StringBuilder)localObject).append(" suffix head: ");
          ((StringBuilder)localObject).append(this.jdField_d_of_type_AndroidTextEditable.charAt(0));
        }
        else
        {
          ((StringBuilder)localObject).append("null");
        }
        QLog.d("FullScreenInputHelper", 2, new Object[] { localObject });
      }
      if ((TextUtils.isEmpty(this.jdField_c_of_type_AndroidTextEditable)) && (FullScreenInputHelper.a(this.jdField_d_of_type_AndroidTextEditable, "￼"))) {
        return 0;
      }
      if ((TextUtils.isEmpty(this.jdField_d_of_type_AndroidTextEditable)) && (FullScreenInputHelper.b(this.jdField_c_of_type_AndroidTextEditable, "￼"))) {
        return 1;
      }
      if ((FullScreenInputHelper.b(this.jdField_c_of_type_AndroidTextEditable, "￼")) && (FullScreenInputHelper.a(this.jdField_d_of_type_AndroidTextEditable, "\n")))
      {
        if ((this.jdField_d_of_type_AndroidTextEditable.length() >= 2) && (this.jdField_d_of_type_AndroidTextEditable.charAt(1) == "￼".charAt(0))) {
          return 2;
        }
        return 3;
      }
      if ((FullScreenInputHelper.b(this.jdField_c_of_type_AndroidTextEditable, "\n")) && (FullScreenInputHelper.a(this.jdField_d_of_type_AndroidTextEditable, "￼")))
      {
        if (this.jdField_c_of_type_AndroidTextEditable.length() >= 2)
        {
          localObject = this.jdField_c_of_type_AndroidTextEditable;
          if (((Editable)localObject).charAt(((Editable)localObject).length() - 2) == "￼".charAt(0)) {
            return 4;
          }
        }
        return 5;
      }
    }
    return -1;
  }
  
  Editable a()
  {
    int i = this.jdField_c_of_type_Int;
    if (i <= 0) {
      return new SpannableStringBuilder();
    }
    Editable localEditable = this.jdField_b_of_type_AndroidTextEditable;
    if (localEditable != null)
    {
      int j = this.jdField_a_of_type_Int;
      return (Editable)localEditable.subSequence(j, i + j);
    }
    return new SpannableStringBuilder();
  }
  
  void a(Editable paramEditable)
  {
    this.jdField_b_of_type_AndroidTextEditable = paramEditable;
  }
  
  void a(EditText paramEditText)
  {
    if (this.jdField_b_of_type_AndroidTextEditable.length() <= 0) {
      return;
    }
    Editable localEditable = a();
    paramEditText = paramEditText.getText();
    int i = Selection.getSelectionStart(paramEditText);
    int j = i;
    if (this.jdField_a_of_type_Int == this.jdField_a_of_type_AndroidTextEditable.length())
    {
      j = i;
      if (FullScreenInputHelper.b(localEditable, "￼"))
      {
        localEditable.append("\n");
        j = i + 1;
      }
    }
    i = this.jdField_d_of_type_Int;
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
      ((StringBuilder)localObject).append(this.jdField_a_of_type_Int);
      QLog.d("FullScreenInputHelper", 2, ((StringBuilder)localObject).toString());
      i = j;
      break;
    case 17: 
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("[mix] handle replace '[text]\\n_[img]' at position: ");
        ((StringBuilder)localObject).append(this.jdField_a_of_type_Int);
        ((StringBuilder)localObject).append(" prefix: ");
        ((StringBuilder)localObject).append(this.jdField_c_of_type_AndroidTextEditable);
        ((StringBuilder)localObject).append(" suffix: ");
        ((StringBuilder)localObject).append(this.jdField_d_of_type_AndroidTextEditable);
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
        ((StringBuilder)localObject).append(this.jdField_a_of_type_Int);
        ((StringBuilder)localObject).append(" prefix: ");
        ((StringBuilder)localObject).append(this.jdField_c_of_type_AndroidTextEditable);
        ((StringBuilder)localObject).append(" suffix: ");
        ((StringBuilder)localObject).append(this.jdField_d_of_type_AndroidTextEditable);
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
        ((StringBuilder)localObject).append(this.jdField_a_of_type_Int);
        ((StringBuilder)localObject).append(" prefix: ");
        ((StringBuilder)localObject).append(this.jdField_c_of_type_AndroidTextEditable);
        ((StringBuilder)localObject).append(" suffix: ");
        ((StringBuilder)localObject).append(this.jdField_d_of_type_AndroidTextEditable);
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
        ((StringBuilder)localObject).append(this.jdField_a_of_type_Int);
        ((StringBuilder)localObject).append(" prefix: ");
        ((StringBuilder)localObject).append(this.jdField_c_of_type_AndroidTextEditable);
        ((StringBuilder)localObject).append(" suffix: ");
        ((StringBuilder)localObject).append(this.jdField_d_of_type_AndroidTextEditable);
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
        ((StringBuilder)localObject).append(this.jdField_a_of_type_Int);
        ((StringBuilder)localObject).append(" prefix: ");
        ((StringBuilder)localObject).append(this.jdField_c_of_type_AndroidTextEditable);
        ((StringBuilder)localObject).append(" suffix: ");
        ((StringBuilder)localObject).append(this.jdField_d_of_type_AndroidTextEditable);
        QLog.d("FullScreenInputHelper", 2, ((StringBuilder)localObject).toString());
      }
      localEditable.insert(0, "\n");
      break;
    case 12: 
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("[mix] handle replace '_[img]' at position: ");
        ((StringBuilder)localObject).append(this.jdField_a_of_type_Int);
        ((StringBuilder)localObject).append(" prefix: ");
        ((StringBuilder)localObject).append(this.jdField_c_of_type_AndroidTextEditable);
        ((StringBuilder)localObject).append(" suffix: ");
        ((StringBuilder)localObject).append(this.jdField_d_of_type_AndroidTextEditable);
        QLog.d("FullScreenInputHelper", 2, ((StringBuilder)localObject).toString());
      }
      localEditable.append("\n");
      break;
    case 11: 
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("[mix] handle del '[img]_[text]' at position: ");
        ((StringBuilder)localObject).append(this.jdField_a_of_type_Int);
        ((StringBuilder)localObject).append(" prefix: ");
        ((StringBuilder)localObject).append(this.jdField_c_of_type_AndroidTextEditable);
        ((StringBuilder)localObject).append(" suffix: ");
        ((StringBuilder)localObject).append(this.jdField_d_of_type_AndroidTextEditable);
        QLog.d("FullScreenInputHelper", 2, ((StringBuilder)localObject).toString());
      }
      this.jdField_c_of_type_AndroidTextEditable.append("\n");
      break;
    case 10: 
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("[mix] handle del '[text]_[img]' at position: ");
        ((StringBuilder)localObject).append(this.jdField_a_of_type_Int);
        ((StringBuilder)localObject).append(" prefix: ");
        ((StringBuilder)localObject).append(this.jdField_c_of_type_AndroidTextEditable);
        ((StringBuilder)localObject).append(" suffix: ");
        ((StringBuilder)localObject).append(this.jdField_d_of_type_AndroidTextEditable);
        QLog.d("FullScreenInputHelper", 2, ((StringBuilder)localObject).toString());
      }
      this.jdField_c_of_type_AndroidTextEditable.append("\n");
      i = j;
      break;
    case 9: 
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("[mix] handle del '[img]_[img]' at position: ");
        ((StringBuilder)localObject).append(this.jdField_a_of_type_Int);
        ((StringBuilder)localObject).append(" prefix: ");
        ((StringBuilder)localObject).append(this.jdField_c_of_type_AndroidTextEditable);
        ((StringBuilder)localObject).append(" suffix: ");
        ((StringBuilder)localObject).append(this.jdField_d_of_type_AndroidTextEditable);
        QLog.d("FullScreenInputHelper", 2, ((StringBuilder)localObject).toString());
      }
      this.jdField_c_of_type_AndroidTextEditable.append("\n");
      break;
    case 8: 
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("[mix] handle del line '[text]_\\n_[img]' at position: ");
        ((StringBuilder)localObject).append(this.jdField_a_of_type_Int);
        ((StringBuilder)localObject).append(" prefix: ");
        ((StringBuilder)localObject).append(this.jdField_c_of_type_AndroidTextEditable);
        ((StringBuilder)localObject).append(" suffix: ");
        ((StringBuilder)localObject).append(this.jdField_d_of_type_AndroidTextEditable);
        QLog.d("FullScreenInputHelper", 2, ((StringBuilder)localObject).toString());
      }
      localObject = this.jdField_c_of_type_AndroidTextEditable;
      ((Editable)localObject).delete(((Editable)localObject).length() - 1, this.jdField_c_of_type_AndroidTextEditable.length());
      this.jdField_c_of_type_AndroidTextEditable.append("\n");
      break;
    case 7: 
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("[mix] handle del line '[img]_\\n_[text]' at position: ");
        ((StringBuilder)localObject).append(this.jdField_a_of_type_Int);
        ((StringBuilder)localObject).append(" prefix: ");
        ((StringBuilder)localObject).append(this.jdField_c_of_type_AndroidTextEditable);
        ((StringBuilder)localObject).append(" suffix: ");
        ((StringBuilder)localObject).append(this.jdField_d_of_type_AndroidTextEditable);
        QLog.d("FullScreenInputHelper", 2, ((StringBuilder)localObject).toString());
      }
      localObject = this.jdField_c_of_type_AndroidTextEditable;
      ((Editable)localObject).delete(((Editable)localObject).length() - 1, this.jdField_c_of_type_AndroidTextEditable.length());
      break;
    case 6: 
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("[mix] handle del line '[img]_\\n_[img]' at position: ");
        ((StringBuilder)localObject).append(this.jdField_a_of_type_Int);
        ((StringBuilder)localObject).append(" prefix: ");
        ((StringBuilder)localObject).append(this.jdField_c_of_type_AndroidTextEditable);
        ((StringBuilder)localObject).append(" suffix: ");
        ((StringBuilder)localObject).append(this.jdField_d_of_type_AndroidTextEditable);
        QLog.d("FullScreenInputHelper", 2, ((StringBuilder)localObject).toString());
      }
      localObject = this.jdField_c_of_type_AndroidTextEditable;
      ((Editable)localObject).delete(((Editable)localObject).length() - 1, this.jdField_c_of_type_AndroidTextEditable.length());
      i = j - 1;
      break;
    case 5: 
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("[mix] handle add '[text]\\n_[img]' at position: ");
        ((StringBuilder)localObject).append(this.jdField_a_of_type_Int);
        ((StringBuilder)localObject).append(" prefix: ");
        ((StringBuilder)localObject).append(this.jdField_c_of_type_AndroidTextEditable);
        ((StringBuilder)localObject).append(" suffix: ");
        ((StringBuilder)localObject).append(this.jdField_d_of_type_AndroidTextEditable);
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
        ((StringBuilder)localObject).append(this.jdField_a_of_type_Int);
        ((StringBuilder)localObject).append(" prefix: ");
        ((StringBuilder)localObject).append(this.jdField_c_of_type_AndroidTextEditable);
        ((StringBuilder)localObject).append(" suffix: ");
        ((StringBuilder)localObject).append(this.jdField_d_of_type_AndroidTextEditable);
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
        ((StringBuilder)localObject).append(this.jdField_a_of_type_Int);
        ((StringBuilder)localObject).append(" prefix: ");
        ((StringBuilder)localObject).append(this.jdField_c_of_type_AndroidTextEditable);
        ((StringBuilder)localObject).append(" suffix: ");
        ((StringBuilder)localObject).append(this.jdField_d_of_type_AndroidTextEditable);
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
        ((StringBuilder)localObject).append(this.jdField_a_of_type_Int);
        ((StringBuilder)localObject).append(" prefix: ");
        ((StringBuilder)localObject).append(this.jdField_c_of_type_AndroidTextEditable);
        ((StringBuilder)localObject).append(" suffix: ");
        ((StringBuilder)localObject).append(this.jdField_d_of_type_AndroidTextEditable);
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
        ((StringBuilder)localObject).append(this.jdField_a_of_type_Int);
        ((StringBuilder)localObject).append(" prefix: ");
        ((StringBuilder)localObject).append(this.jdField_c_of_type_AndroidTextEditable);
        ((StringBuilder)localObject).append(" suffix: ");
        ((StringBuilder)localObject).append(this.jdField_d_of_type_AndroidTextEditable);
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
      ((StringBuilder)localObject).append(this.jdField_a_of_type_Int);
      ((StringBuilder)localObject).append(" prefix: ");
      ((StringBuilder)localObject).append(this.jdField_c_of_type_AndroidTextEditable);
      ((StringBuilder)localObject).append(" suffix: ");
      ((StringBuilder)localObject).append(this.jdField_d_of_type_AndroidTextEditable);
      QLog.d("FullScreenInputHelper", 2, ((StringBuilder)localObject).toString());
    }
    localEditable.append("\n");
    i = j;
    label2127:
    if (this.jdField_d_of_type_Int != -1)
    {
      localObject = new SpannableStringBuilder();
      if (!TextUtils.isEmpty(this.jdField_c_of_type_AndroidTextEditable)) {
        ((Editable)localObject).append(this.jdField_c_of_type_AndroidTextEditable);
      }
      if (!TextUtils.isEmpty(localEditable)) {
        ((Editable)localObject).append(localEditable);
      }
      if (!TextUtils.isEmpty(this.jdField_d_of_type_AndroidTextEditable)) {
        ((Editable)localObject).append(this.jdField_d_of_type_AndroidTextEditable);
      }
      FullScreenInputHelper.c(false);
      paramEditText.replace(0, paramEditText.length(), (CharSequence)localObject);
      Selection.setSelection(paramEditText, Math.min(i, ((Editable)localObject).length()));
      FullScreenInputHelper.c(true);
    }
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("<TextChangeInfo> {textBefore: ");
    localStringBuilder.append(this.jdField_a_of_type_AndroidTextEditable);
    localStringBuilder.append(" textAfter: ");
    localStringBuilder.append(this.jdField_b_of_type_AndroidTextEditable);
    localStringBuilder.append(" indexChange: ");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append(" countAdded: ");
    localStringBuilder.append(this.jdField_c_of_type_Int);
    localStringBuilder.append(" countDeleted: ");
    localStringBuilder.append(this.jdField_b_of_type_Int);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.FullScreenInputHelper.TextChangeInfo
 * JD-Core Version:    0.7.0.1
 */