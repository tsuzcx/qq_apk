package com.tencent.biz.qqstory.storyHome.atvideo.model;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.ViewParent;
import android.widget.EditText;
import android.widget.RelativeLayout;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.storyHome.atvideo.view.StoryAtVideoFragment;
import com.tencent.biz.qqstory.storyHome.model.FeedManager;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.biz.qqstory.view.widget.bubble.BubbleTextView;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;

public class AtVideoTextWatcher
  implements TextWatcher
{
  public String a;
  public String b;
  public int c;
  public Context d;
  public boolean e;
  public FeedManager f;
  public BubbleTextView g;
  private int h;
  private int i;
  
  public AtVideoTextWatcher(Context paramContext, String paramString1, String paramString2, int paramInt, boolean paramBoolean)
  {
    if ((!"1_".equals(paramString2)) && (!"2_".equals(paramString2))) {
      throw new IllegalArgumentException("illegal textWatcher source");
    }
    this.a = paramString2;
    this.d = paramContext;
    this.b = paramString1;
    this.c = paramInt;
    this.e = paramBoolean;
    this.f = ((FeedManager)SuperManager.a(11));
  }
  
  public static void a(EditText paramEditText, Intent paramIntent)
  {
    if (paramIntent == null) {
      return;
    }
    paramIntent = paramIntent.getStringExtra("at_video_text");
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("on activity result, at video text=");
      localStringBuilder.append(paramIntent);
      QLog.d("Q.qqstory.atvideo.AtVideoTextWatcher", 2, localStringBuilder.toString());
    }
    if ((paramEditText != null) && (!TextUtils.isEmpty(paramIntent))) {
      paramEditText.getText().insert(paramEditText.getSelectionStart(), paramIntent);
    }
  }
  
  public void afterTextChanged(Editable paramEditable)
  {
    if (this.i > 0)
    {
      Object localObject1 = this.g;
      Object localObject2;
      if (localObject1 != null)
      {
        localObject2 = ((BubbleTextView)localObject1).getParent();
        localObject1 = localObject2;
        if (localObject2 != null)
        {
          localObject1 = localObject2;
          if (!(localObject2 instanceof RelativeLayout)) {
            localObject1 = ((ViewParent)localObject2).getParent();
          }
        }
        if ((localObject1 != null) && ((localObject1 instanceof RelativeLayout))) {
          ((RelativeLayout)localObject1).removeView(this.g);
        }
        this.g = null;
      }
      if (('@' == paramEditable.charAt(this.h + this.i - 1)) || (65312 == paramEditable.charAt(this.h + this.i - 1)))
      {
        StoryReportor.a("home_page", "send_at", 0, 0, new String[0]);
        if (QLog.isColorLevel()) {
          QLog.d("Q.qqstory.atvideo.AtVideoTextWatcher", 2, "trigger at video process");
        }
        paramEditable = this.d;
        if (((paramEditable instanceof Activity)) && (this.e))
        {
          paramEditable = (Activity)paramEditable;
          localObject1 = this.b;
          localObject2 = this.f.g;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(this.a);
          localStringBuilder.append(this.b);
          StoryAtVideoFragment.a(paramEditable, (String)localObject1, (String)((Map)localObject2).get(localStringBuilder.toString()), this.c);
        }
      }
    }
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    this.h = paramInt1;
    this.i = paramInt3;
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.atvideo.model.AtVideoTextWatcher
 * JD-Core Version:    0.7.0.1
 */