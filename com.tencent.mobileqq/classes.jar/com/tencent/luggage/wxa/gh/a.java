package com.tencent.luggage.wxa.gh;

import android.os.ResultReceiver;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import com.tencent.luggage.wxa.jx.e;
import com.tencent.luggage.wxa.pp.n;
import com.tencent.luggage.wxa.pp.u.c;
import com.tencent.luggage.wxa.pp.x;
import com.tencent.luggage.wxa.pw.b;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.mm.plugin.appbrand.page.ag;
import org.json.JSONObject;
import org.xwalk.core.XWalkExtendTextAreaClient;
import org.xwalk.core.XWalkView;

public class a
  extends XWalkExtendTextAreaClient
{
  private final String a = "WebViewExtendTextAreaClient";
  private ag b;
  private com.tencent.luggage.wxa.pp.u c;
  private int d = 0;
  private final u.c e = new a.1(this);
  
  public a(XWalkView paramXWalkView)
  {
    super(paramXWalkView);
  }
  
  private x a()
  {
    Object localObject1 = this.b;
    Object localObject2 = null;
    if ((localObject1 != null) && (((ag)localObject1).a() != null))
    {
      View localView = this.b.a().getContentView();
      localObject1 = localObject2;
      if (this.b.a() != null)
      {
        localObject1 = localObject2;
        if ((this.b.a() instanceof com.tencent.mm.plugin.appbrand.page.u)) {
          localObject1 = ((com.tencent.mm.plugin.appbrand.page.u)this.b.a()).aq();
        }
      }
      return x.a(localView, (com.tencent.luggage.wxa.nj.a)localObject1);
    }
    return null;
  }
  
  private void b()
  {
    getXWalkView().evaluateJavascript("(function(){var focusElement = document.activeElement;if(focusElement){if(focusElement.onkeyboardconfirm){focusElement.onkeyboardconfirm();}focusElement.blur();}})();", new a.3(this));
  }
  
  public void a(ag paramag)
  {
    this.b = paramag;
  }
  
  public int getToolBarHeight(int paramInt)
  {
    x localx = a();
    int i = paramInt;
    if (localx != null) {
      i = paramInt + localx.getMinimumHeight();
    }
    return i;
  }
  
  public boolean onHideKeyboard(String paramString, InputConnection paramInputConnection)
  {
    if (this.b != null)
    {
      paramString = a();
      if (paramString != null) {
        paramString.a(false);
      }
    }
    paramString = this.c;
    if (paramString != null) {
      paramString.b(this.e);
    }
    return false;
  }
  
  public boolean onShowKeyboard(String paramString, InputConnection paramInputConnection, ResultReceiver paramResultReceiver)
  {
    if (this.c == null) {
      this.c = n.c(this.b.a().getContentView());
    }
    paramInputConnection = this.c;
    if (paramInputConnection != null) {
      paramInputConnection.a(this.e);
    }
    paramString = new a.a(this, paramString);
    if (this.b != null)
    {
      paramInputConnection = a();
      if (paramInputConnection != null)
      {
        if (paramString.e)
        {
          paramInputConnection.setComponentView(paramString.g);
          paramInputConnection.h();
          boolean bool;
          if ((!paramString.f) && ("emoji".equals(paramString.c))) {
            bool = true;
          } else {
            bool = false;
          }
          paramInputConnection.setCanSmileyInput(bool);
          paramInputConnection.setShowDoneButton(paramString.e);
          paramInputConnection.setOnDoneListener(new a.2(this));
        }
        paramInputConnection.a(paramString.e);
      }
    }
    return false;
  }
  
  public boolean onShowKeyboardConfig(int paramInt1, int paramInt2, String paramString, int paramInt3, int paramInt4, EditorInfo paramEditorInfo)
  {
    o.e("WebViewExtendTextAreaClient", "onShowKeyboardConfig");
    StringBuilder localStringBuilder = null;
    try
    {
      paramString = b.a(new JSONObject(paramString).optString("confirm-type", null));
    }
    catch (Exception paramString)
    {
      label31:
      break label31;
    }
    o.c("WebViewExtendTextAreaClient", "onShowKeyboardConfig, get confirm-type error");
    paramString = localStringBuilder;
    if (paramString != null)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("onShowKeyboardConfig, confirmType: ");
      localStringBuilder.append(paramString);
      o.d("WebViewExtendTextAreaClient", localStringBuilder.toString());
      if (b.f != paramString) {
        paramEditorInfo.imeOptions &= 0xBFFFFFFF;
      }
      paramEditorInfo.imeOptions |= paramString.g;
      this.d = paramString.g;
    }
    return false;
  }
  
  public boolean performEditorAction(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("performEditorAction, actionCode: ");
    localStringBuilder.append(paramInt);
    o.e("WebViewExtendTextAreaClient", localStringBuilder.toString());
    if ((paramInt != 5) && (paramInt != 7) && (paramInt != 0) && (paramInt == this.d))
    {
      o.d("WebViewExtendTextAreaClient", "performEditorAction, doOnKeyboardConfirmLogic");
      b();
      return false;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.gh.a
 * JD-Core Version:    0.7.0.1
 */