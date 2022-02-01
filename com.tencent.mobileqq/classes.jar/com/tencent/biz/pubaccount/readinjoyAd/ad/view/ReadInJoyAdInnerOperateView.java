package com.tencent.biz.pubaccount.readinjoyAd.ad.view;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.Window;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.ProteusInnerData;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.ProteusInnerData.InnerFormItem;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.ReadInJoyAdInnerUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.widget.QQToast;
import java.lang.ref.WeakReference;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONObject;

public class ReadInJoyAdInnerOperateView
  extends ViewBase
  implements View.OnClickListener, View.OnFocusChangeListener
{
  boolean a = false;
  private View b;
  private WeakReference<Context> c = null;
  private EditText d;
  private TextView e;
  private ProteusInnerData f;
  private String g;
  private String h;
  private String i;
  
  public ReadInJoyAdInnerOperateView(VafContext paramVafContext)
  {
    super(paramVafContext);
    this.c = new WeakReference(paramVafContext.getContext());
    a();
  }
  
  private void a()
  {
    WeakReference localWeakReference = this.c;
    if ((localWeakReference != null) && (localWeakReference.get() != null))
    {
      this.b = ((LayoutInflater)((Context)this.c.get()).getSystemService("layout_inflater")).inflate(2131626109, null);
      this.d = ((EditText)this.b.findViewById(2131432638));
      this.e = ((TextView)this.b.findViewById(2131448769));
      this.d.setOnFocusChangeListener(this);
      this.d.setOnClickListener(this);
      this.e.setOnClickListener(this);
    }
  }
  
  private void b()
  {
    if (this.f.c != null)
    {
      if (!TextUtils.isEmpty(this.f.c.d)) {
        this.d.setHint(ReadInJoyAdInnerUtils.a(this.f.c.d, 32));
      }
      if (!TextUtils.isEmpty(this.f.c.e)) {
        this.e.setText(ReadInJoyAdInnerUtils.a(this.f.c.e, 8));
      }
    }
    boolean bool = TextUtils.isEmpty(this.f.ai);
    Object localObject2 = null;
    if (!bool) {
      localObject1 = this.f.ai;
    } else {
      localObject1 = null;
    }
    this.g = ((String)localObject1);
    if (!TextUtils.isEmpty(this.f.ak)) {
      localObject1 = this.f.ak;
    } else {
      localObject1 = null;
    }
    this.i = ((String)localObject1);
    Object localObject1 = localObject2;
    if (!TextUtils.isEmpty(this.f.al)) {
      localObject1 = this.f.al;
    }
    this.h = ((String)localObject1);
  }
  
  public int getComMeasuredHeight()
  {
    return this.b.getMeasuredHeight();
  }
  
  public int getComMeasuredWidth()
  {
    return this.b.getMeasuredWidth();
  }
  
  public View getNativeView()
  {
    return this.b;
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() != 2131448769) {
      return;
    }
    String str = this.d.getText().toString().trim();
    ProteusInnerData localProteusInnerData = this.f;
    if (localProteusInnerData == null) {
      return;
    }
    boolean bool;
    if ((localProteusInnerData.c != null) && (this.f.c.b != null)) {
      bool = this.f.c.b.matcher(str).matches();
    } else {
      bool = true;
    }
    if (bool)
    {
      QQToast.makeText(paramView.getContext(), -1, HardCodeUtil.a(2131910421), 0).show(((BaseActivity)paramView.getContext()).getTitleBarHeight());
      if ((this.f.c == null) || (this.f.c.f == null)) {
        break label183;
      }
    }
    try
    {
      this.f.c.f.put("value", str);
      return;
    }
    catch (Exception paramView) {}
    str = HardCodeUtil.a(2131910445);
    QQToast.makeText(paramView.getContext(), 1, str, 0).show(((BaseActivity)paramView.getContext()).getTitleBarHeight());
    label183:
    return;
  }
  
  public void onComLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.b.layout(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void onComMeasure(int paramInt1, int paramInt2)
  {
    this.b.measure(paramInt1, paramInt2);
  }
  
  public void onFocusChange(View paramView, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      paramView = this.c;
      if ((paramView != null) && (paramView.get() != null) && ((this.c.get() instanceof Activity))) {
        ((Activity)this.c.get()).getWindow().getAttributes().softInputMode = 4;
      }
    }
    if ((!this.a) && (paramBoolean))
    {
      this.a = true;
      ReadInJoyAdInnerUtils.a(this.f, 39);
    }
  }
  
  protected boolean setAttribute(int paramInt, Object paramObject)
  {
    if ((paramInt == 1042) && (paramObject != null) && ((paramObject instanceof ProteusInnerData)))
    {
      this.f = ((ProteusInnerData)paramObject);
      b();
    }
    return super.setAttribute(paramInt, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.view.ReadInJoyAdInnerOperateView
 * JD-Core Version:    0.7.0.1
 */