package com.tencent.biz.pubaccount.weishi_new.comment;

import android.content.Context;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextWatcher;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import com.tencent.biz.subscribe.comment.CommentEditText;
import com.tencent.biz.subscribe.comment.EmoWindow;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.widget.QQToast;
import java.util.List;

public abstract class WSCommentTextChangedListener
  implements TextWatcher
{
  private final CommentEditText a;
  private final Context b;
  private int c = 0;
  private int d = 0;
  private int e = -1;
  private int f = -1;
  private String g = "";
  
  public WSCommentTextChangedListener(CommentEditText paramCommentEditText)
  {
    this.a = paramCommentEditText;
    this.b = paramCommentEditText.getContext();
  }
  
  private int a(CharSequence paramCharSequence, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[WSCommentTextChangedListener.java][findAtSymbol] str:");
    localStringBuilder.append(paramCharSequence);
    WSLog.a("WSCommentTextChangedListener", localStringBuilder.toString());
    return WSCommentUtil.a(paramCharSequence, paramInt, c(), b(), this.e, this.f, this.g);
  }
  
  private boolean a(String paramString, boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[WSCommentTextChangedListener.java][isMatchAt] atCode:");
    localStringBuilder.append(paramString);
    WSLog.a("WSCommentTextChangedListener", localStringBuilder.toString());
    return WSCommentUtil.a(paramString, paramBoolean, b(), this.e, this.f, this.g);
  }
  
  private void d()
  {
    this.g = "";
    this.e = -1;
    this.f = -1;
  }
  
  abstract void a();
  
  public void afterTextChanged(Editable paramEditable)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[WSCommentTextChangedListener.java][afterTextChanged] s:");
    ((StringBuilder)localObject).append(paramEditable);
    WSLog.b("WSCommentTextChangedListener", ((StringBuilder)localObject).toString());
    if (paramEditable == null) {
      return;
    }
    this.a.removeTextChangedListener(this);
    StringBuilder localStringBuilder;
    if (paramEditable.length() > 140)
    {
      localObject = this.b;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(HardCodeUtil.a(2131900373));
      localStringBuilder.append(140);
      localStringBuilder.append(HardCodeUtil.a(2131900374));
      QQToast.makeText((Context)localObject, localStringBuilder.toString(), 0).show();
      i = this.c;
      paramEditable.delete(i, this.d + i);
    }
    else
    {
      localStringBuilder = null;
      localObject = paramEditable.toString();
      i = this.c;
      String str = ((String)localObject).substring(i, this.d + i);
      i = str.indexOf('/');
      localObject = localStringBuilder;
      if (i >= 0)
      {
        localObject = localStringBuilder;
        if (i < str.length() - 1)
        {
          localObject = new SpannableStringBuilder(paramEditable.toString());
          EmoWindow.a(this.a.getContext(), (SpannableStringBuilder)localObject);
        }
      }
      if (localObject != null) {
        i = this.a.getSelectionEnd();
      }
    }
    try
    {
      this.a.setText((CharSequence)localObject);
    }
    catch (ArrayIndexOutOfBoundsException localArrayIndexOutOfBoundsException)
    {
      label237:
      break label237;
    }
    this.a.setText(paramEditable.toString());
    int i = paramEditable.toString().length();
    this.a.setSelection(i);
    this.d = 0;
    this.c = 0;
    this.a.addTextChangedListener(this);
  }
  
  abstract List<Friends> b();
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[WSCommentTextChangedListener.java][beforeTextChanged] s:");
    localStringBuilder.append(paramCharSequence);
    localStringBuilder.append(", start:");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(", count:");
    localStringBuilder.append(paramInt2);
    localStringBuilder.append(", after:");
    localStringBuilder.append(paramInt3);
    WSLog.b("WSCommentTextChangedListener", localStringBuilder.toString());
    if (((paramInt2 == 1) || (paramInt2 == 2)) && (paramInt3 == 0)) {}
    try
    {
      this.e = a(paramCharSequence, paramInt1 + paramInt2);
      if (this.e == -1)
      {
        d();
        return;
      }
      this.f = paramInt1;
      this.g = paramCharSequence.toString().substring(this.e, this.f + paramInt2);
      return;
    }
    catch (Exception paramCharSequence)
    {
      label149:
      break label149;
    }
    d();
  }
  
  abstract int c();
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[WSCommentTextChangedListener.java][onTextChanged] s:");
    localStringBuilder.append(paramCharSequence);
    localStringBuilder.append(", start:");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(", count:");
    localStringBuilder.append(paramInt3);
    localStringBuilder.append(", before:");
    localStringBuilder.append(paramInt2);
    WSLog.b("WSCommentTextChangedListener", localStringBuilder.toString());
    if (paramCharSequence == null)
    {
      d();
      return;
    }
    this.a.removeTextChangedListener(this);
    if ((paramInt3 == 1) && (paramInt2 == 0) && (paramCharSequence.toString().substring(paramInt1, paramInt1 + 1).equals("@")))
    {
      WSLog.b("WSCommentTextChangedListener", "输入@呼起好友选择器");
      a();
    }
    if (a(this.g, true))
    {
      this.a.getEditableText().delete(this.e, this.f);
      this.c = this.e;
      this.d = 0;
    }
    else
    {
      this.c = paramInt1;
      this.d = paramInt3;
    }
    d();
    this.a.addTextChangedListener(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.comment.WSCommentTextChangedListener
 * JD-Core Version:    0.7.0.1
 */