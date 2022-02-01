package com.tencent.mm.plugin.appbrand.phonenumber;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import com.tencent.luggage.wxa.qz.af;
import com.tencent.mm.plugin.appbrand.phonenumber.widget.MMFormVerifyCodeInputView;
import com.tencent.mm.ui.base.MMFormInputView;
import com.tencent.mm.ui.widget.MMSwitchBtn;
import com.tencent.mm.ui.widget.dialog.MMAlertDialog.Builder;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneNumberAddView;", "Lcom/tencent/mm/plugin/appbrand/phonenumber/IPhoneNumberAddView;", "mContext", "Landroid/content/Context;", "mPhoneNumberAddLogic", "Lcom/tencent/mm/plugin/appbrand/phonenumber/IPhoneNumberAddLogic;", "(Landroid/content/Context;Lcom/tencent/mm/plugin/appbrand/phonenumber/IPhoneNumberAddLogic;)V", "mContentView", "Landroid/view/View;", "mExistPhoneNum", "", "Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneItem;", "mFinishBtn", "Landroid/widget/Button;", "mFormInputView", "Lcom/tencent/mm/plugin/appbrand/phonenumber/widget/MMFormVerifyCodeInputView;", "mFormVerifyCodeInputView", "Lcom/tencent/mm/ui/base/MMFormInputView;", "mSwitchBtn", "Lcom/tencent/mm/ui/widget/MMSwitchBtn;", "containPhoneNum", "", "number", "", "count", "", "getView", "reset", "showReplicaNumDialog", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 1, 16})
public final class u
  implements m
{
  private View a;
  private MMFormVerifyCodeInputView b;
  private MMFormInputView c;
  private MMSwitchBtn d;
  private Button e;
  private List<r> f;
  private final Context g;
  private l h;
  
  public u(@NotNull Context paramContext, @Nullable l paraml)
  {
    this.g = paramContext;
    this.h = paraml;
    paramContext = this.g;
    paraml = null;
    this.a = View.inflate(paramContext, 2131624216, null);
    paramContext = this.a;
    if (paramContext != null) {
      paramContext = (MMFormVerifyCodeInputView)paramContext.findViewById(2131428555);
    } else {
      paramContext = null;
    }
    this.b = paramContext;
    paramContext = this.b;
    if (paramContext != null)
    {
      paramContext = paramContext.getContentEditText();
      if (paramContext != null) {
        paramContext.setTextColor(this.g.getResources().getColor(2131166594));
      }
    }
    paramContext = this.a;
    if (paramContext != null) {
      paramContext = (MMFormInputView)paramContext.findViewById(2131428557);
    } else {
      paramContext = null;
    }
    this.c = paramContext;
    paramContext = this.c;
    if (paramContext != null)
    {
      paramContext = paramContext.getContentEditText();
      if (paramContext != null) {
        paramContext.setTextColor(this.g.getResources().getColor(2131166594));
      }
    }
    paramContext = this.a;
    if (paramContext != null) {
      paramContext = (MMSwitchBtn)paramContext.findViewById(2131428556);
    } else {
      paramContext = null;
    }
    this.d = paramContext;
    View localView = this.a;
    paramContext = paraml;
    if (localView != null) {
      paramContext = (Button)localView.findViewById(2131428554);
    }
    this.e = paramContext;
    this.f = s.a.a();
    paramContext = this.b;
    if (paramContext != null) {
      paramContext.setInputType(3);
    }
    paramContext = this.b;
    if (paramContext != null) {
      paramContext.setSendSmsBtnClickListener((View.OnClickListener)new u.1(this));
    }
    paramContext = this.b;
    if (paramContext != null) {
      paramContext.a((TextWatcher)new u.2(this));
    }
    paramContext = this.c;
    if (paramContext != null) {
      paramContext.setInputType(3);
    }
    paramContext = this.c;
    if (paramContext != null) {
      paramContext.a((TextWatcher)new u.3(this));
    }
    paramContext = this.e;
    if (paramContext != null) {
      paramContext.setOnClickListener((View.OnClickListener)new u.4(this));
    }
  }
  
  private final boolean a(String paramString)
  {
    Object localObject = this.f;
    if (localObject != null)
    {
      if (localObject == null) {
        Intrinsics.throwNpe();
      }
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        r localr = (r)((Iterator)localObject).next();
        if (Intrinsics.areEqual(af.b(paramString), localr.b())) {
          return true;
        }
      }
    }
    return false;
  }
  
  private final void d()
  {
    MMAlertDialog.Builder localBuilder = new MMAlertDialog.Builder(this.g);
    localBuilder.setMsg(2131886961);
    localBuilder.setPositiveBtnText(2131891475);
    localBuilder.show();
  }
  
  @Nullable
  public View a()
  {
    return this.a;
  }
  
  public void b()
  {
    MMFormVerifyCodeInputView localMMFormVerifyCodeInputView = this.b;
    if (localMMFormVerifyCodeInputView != null) {
      localMMFormVerifyCodeInputView.a();
    }
  }
  
  public void c()
  {
    MMFormVerifyCodeInputView localMMFormVerifyCodeInputView = this.b;
    if (localMMFormVerifyCodeInputView != null) {
      localMMFormVerifyCodeInputView.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.phonenumber.u
 * JD-Core Version:    0.7.0.1
 */