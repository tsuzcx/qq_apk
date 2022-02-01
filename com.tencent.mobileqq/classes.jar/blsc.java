import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.ui.RefreshView;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserUIStyleHandler;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserUIStyleHandler.SwiftBrowserUIStyle;
import com.tencent.mobileqq.webview.ui.WebViewTopTabView;
import com.tencent.mobileqq.widget.WebViewProgressBar;
import org.json.JSONObject;

public class blsc
  extends bieo
{
  private boolean a = true;
  private boolean b = true;
  private boolean c = true;
  
  public blsc(SwiftBrowserUIStyleHandler paramSwiftBrowserUIStyleHandler)
  {
    super(paramSwiftBrowserUIStyleHandler);
    paramSwiftBrowserUIStyleHandler = paramSwiftBrowserUIStyleHandler.mHostActivity.getIntent();
    int i = paramSwiftBrowserUIStyleHandler.getIntExtra("key_subtab", 0);
    paramSwiftBrowserUIStyleHandler.removeExtra("key_subtab");
    if (this.mUIStyle.mSubIndex != i) {
      setTopTabSelection(i);
    }
  }
  
  public void initTitleContainer()
  {
    super.initTitleContainer();
    if ((this.mUIStyleHandler.webviewWrapper instanceof RefreshView)) {
      ((RefreshView)this.mUIStyleHandler.webviewWrapper).a(false);
    }
    if (this.mUIStyleHandler.mBrowserTips != null) {
      this.mUIStyleHandler.mBrowserTips.setVisibility(8);
    }
    this.mUIStyle.needHideBottomBar = true;
    boolean bool;
    if (this.mUIStyle.transparentTitlebarConfig != null)
    {
      if (!this.mUIStyle.transparentTitlebarConfig.has("txtclr"))
      {
        bool = true;
        this.a = bool;
        if (this.mUIStyle.transparentTitlebarConfig.has("titleclr")) {
          break label579;
        }
        bool = true;
        label113:
        this.b = bool;
        if (this.mUIStyle.transparentTitlebarConfig.has("bgclr")) {
          break label585;
        }
        bool = true;
        label137:
        this.c = bool;
      }
    }
    else
    {
      if (this.c)
      {
        int i = this.titleContainer.getPaddingTop();
        int j = this.titleContainer.getPaddingBottom();
        int k = this.titleContainer.getPaddingLeft();
        int m = this.titleContainer.getPaddingRight();
        this.titleContainer.setBackgroundColor(-1);
        this.titleContainer.setPadding(k, i, m, j);
        if (this.mUIStyleHandler.mHostFragment != null)
        {
          this.mUIStyleHandler.mHostFragment.mNeedStatusTrans = true;
          this.mUIStyleHandler.mHostFragment.mActNeedImmersive = true;
          if (this.mUIStyleHandler.mHostFragment.mSystemBarComp == null) {
            this.mUIStyleHandler.mHostFragment.setImmersiveStatus();
          }
          if (this.mUIStyleHandler.mHostFragment.mSystemBarComp != null)
          {
            this.mUIStyleHandler.mHostFragment.mSystemBarComp.setBackgroundColor(-4210753);
            this.mUIStyle.mUsingCustomTitleBarColor = true;
          }
        }
      }
      if ((!this.c) || (!this.b) || (!this.a)) {
        this.mUIStyleHandler.doTransparent(this.mUIStyle.transparentTitlebarConfig, true);
      }
      if ((this.mUIStyle.mCRulesFromUrl & 0x20) != 0L)
      {
        this.leftView.setVisibility(4);
        setRightButton("", this.rightViewText.getResources().getString(2131690845), "", false, 0, 0, null, null, null);
        this.rightViewText.setOnClickListener(new blsd(this));
      }
      if ((this.mUIStyle.mCRulesFromUrl & 0x40) != 0L)
      {
        this.leftView.setVisibility(4);
        RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.centerContainer.getLayoutParams();
        localLayoutParams.addRule(15);
        localLayoutParams.addRule(9);
        localLayoutParams.leftMargin = DisplayUtil.dip2px(this.centerContainer.getContext(), 15.0F);
        this.centerContainer.setLayoutParams(localLayoutParams);
      }
      if (this.mUIStyle.mInitTitleAlpha != -1) {
        break label601;
      }
      if (((this.mUIStyle.mRulesFromUrl & 0x1000000) <= 0L) && ((this.mUIStyle.mCRulesFromUrl & 1L) <= 0L)) {
        break label591;
      }
      setTitleBarAlpha(0);
    }
    for (;;)
    {
      this.leftView.setShadowLayer(0.0F, 0.0F, 0.0F, 0);
      this.centerView.setShadowLayer(0.0F, 0.0F, 0.0F, 0);
      this.rightViewText.setShadowLayer(0.0F, 0.0F, 0.0F, 0);
      if (this.mUIStyleHandler.mLoadingProgressBar != null) {
        this.mUIStyleHandler.mLoadingProgressBar.setVisibility(8);
      }
      return;
      bool = false;
      break;
      label579:
      bool = false;
      break label113;
      label585:
      bool = false;
      break label137;
      label591:
      setTitleBarAlpha(255);
      continue;
      label601:
      setTitleBarAlpha(this.mUIStyle.mInitTitleAlpha);
    }
  }
  
  public void setTitleBarStyle(boolean paramBoolean)
  {
    super.setTitleBarStyle(paramBoolean);
    if (paramBoolean)
    {
      if (this.a) {
        setTitleBarButtonColor(-1);
      }
      if (this.b) {
        setTitleBarTextColor(-1);
      }
      if (this.mTopSubTabView != null)
      {
        this.mTopSubTabView.setButtonBackgroundResource(2130850871, 2130850872, 2130850873);
        this.mTopSubTabView.setButtonTextColorStateList(2131167349);
        this.mTopSubTabView.setLeftAndRightPaddingByDp(14);
      }
    }
    do
    {
      return;
      if (this.a) {
        setTitleBarButtonColor(-16777216);
      }
      if (this.b) {
        setTitleBarTextColor(-16777216);
      }
    } while (this.mTopSubTabView == null);
    this.mTopSubTabView.setButtonBackgroundResource(2130850888, 2130850889, 2130850890);
    this.mTopSubTabView.setButtonTextColorStateList(2131167360);
    this.mTopSubTabView.setLeftAndRightPaddingByDp(14);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blsc
 * JD-Core Version:    0.7.0.1
 */