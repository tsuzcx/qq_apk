package com.tencent.mobileqq.activity.aio.stickerrecommended.mvvm;

import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseAIOContext;
import com.tencent.mobileqq.activity.aio.stickerrecommended.adapter.StickerRecBarAdapter;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.emoticonview.EmotionKeywordHorizonListView;
import com.tencent.mobileqq.emoticonview.EmotionKeywordLayout;
import com.tencent.mobileqq.mvvm.BaseViewBinder;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.qphone.base.util.QLog;

public class StickerRecViewBinder
  extends BaseViewBinder
  implements IStickerRecViewBinder
{
  public EmotionKeywordLayout a;
  private RelativeLayout b;
  private EmotionKeywordHorizonListView c;
  private StickerRecBarAdapter d;
  private AppInterface e;
  private QBaseActivity f;
  private BaseAIOContext g;
  private StickerRecViewModel h;
  
  public StickerRecViewBinder(AppInterface paramAppInterface, QBaseActivity paramQBaseActivity, BaseAIOContext paramBaseAIOContext, IStickerRecViewModel paramIStickerRecViewModel)
  {
    this.e = paramAppInterface;
    this.f = paramQBaseActivity;
    this.g = paramBaseAIOContext;
    this.h = ((StickerRecViewModel)paramIStickerRecViewModel);
  }
  
  private EmotionKeywordHorizonListView a(ViewGroup paramViewGroup, EditText paramEditText)
  {
    Object localObject = this.a;
    if (localObject == null) {
      return null;
    }
    ((EmotionKeywordLayout)localObject).setEnableAnim(true);
    localObject = (LinearLayout)this.a.findViewById(2131432435);
    EmotionKeywordHorizonListView localEmotionKeywordHorizonListView = (EmotionKeywordHorizonListView)this.a.findViewById(2131432465);
    TextView localTextView = (TextView)this.a.findViewById(2131432434);
    if ((a()) && (ThemeUtil.isNowThemeIsNight(this.e, false, null)))
    {
      this.a.setBackgroundColor(Color.parseColor("#1F1F1F"));
      localEmotionKeywordHorizonListView.setBackgroundColor(Color.parseColor("#1F1F1F"));
      ((LinearLayout)localObject).setBackgroundColor(Color.parseColor("#1F1F1F"));
      localTextView.setTextColor(Color.parseColor("#8D8D93"));
    }
    this.d = new StickerRecBarAdapter(this.f, this.e, this.g, paramViewGroup, paramEditText, localEmotionKeywordHorizonListView);
    this.d.a(this.h);
    localEmotionKeywordHorizonListView.setAdapter(this.d);
    localEmotionKeywordHorizonListView.setPadding(0, 0, 0, 0);
    this.a.setOnVisibilityListener(new StickerRecViewBinder.4(this));
    this.h.a(true);
    return localEmotionKeywordHorizonListView;
  }
  
  private boolean a()
  {
    BaseAIOContext localBaseAIOContext = this.g;
    boolean bool = true;
    if (localBaseAIOContext != null)
    {
      if (localBaseAIOContext.O() == null) {
        return true;
      }
      if (this.g.O().a != 10014) {
        return true;
      }
      bool = false;
    }
    return bool;
  }
  
  public void a(ViewGroup paramViewGroup, RelativeLayout paramRelativeLayout, EditText paramEditText)
  {
    if (this.a == null) {
      try
      {
        this.a = ((EmotionKeywordLayout)View.inflate(this.f, 2131624091, null));
        this.c = a(paramViewGroup, paramEditText);
        if (this.c == null) {
          return;
        }
        this.c.setTouchListener(new StickerRecViewBinder.5(this, paramEditText));
        paramViewGroup = new RelativeLayout.LayoutParams(-1, -2);
        paramViewGroup.addRule(2, 2131435809);
        paramViewGroup.addRule(9);
        this.b = paramRelativeLayout;
        this.b.addView(this.a, paramViewGroup);
        this.h.c(true);
        return;
      }
      catch (Exception paramViewGroup)
      {
        paramRelativeLayout = new StringBuilder();
        paramRelativeLayout.append("EmotionPreviewLayout InflateException = ");
        paramRelativeLayout.append(paramViewGroup);
        QLog.e("StickerRecViewBinder", 2, paramRelativeLayout.toString());
      }
    }
  }
  
  public void a(LifecycleOwner paramLifecycleOwner)
  {
    a(paramLifecycleOwner, this.h);
    b(paramLifecycleOwner, this.h);
    c(paramLifecycleOwner, this.h);
  }
  
  protected void a(LifecycleOwner paramLifecycleOwner, StickerRecViewModel paramStickerRecViewModel)
  {
    paramStickerRecViewModel.b().observe(paramLifecycleOwner, new StickerRecViewBinder.1(this));
  }
  
  protected void b(LifecycleOwner paramLifecycleOwner, StickerRecViewModel paramStickerRecViewModel)
  {
    paramStickerRecViewModel.c().observe(paramLifecycleOwner, new StickerRecViewBinder.2(this));
  }
  
  protected void c(LifecycleOwner paramLifecycleOwner, StickerRecViewModel paramStickerRecViewModel)
  {
    paramStickerRecViewModel.d().observe(paramLifecycleOwner, new StickerRecViewBinder.3(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.stickerrecommended.mvvm.StickerRecViewBinder
 * JD-Core Version:    0.7.0.1
 */