import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.teamwork.TeamWorkFileImportInfo;
import com.tencent.mobileqq.teamwork.TeamWorkShareActionSheetBuilder.1;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.widget.share.ShareActionSheet.IShareActionSheetV2BottomBar;
import com.tencent.mobileqq.widget.share.ShareActionSheet.OnItemClickListener;
import com.tencent.smtt.sdk.WebView;

public class bcvp
  extends ShareActionSheetBuilder
  implements ShareActionSheet.IShareActionSheetV2BottomBar
{
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private bctv jdField_a_of_type_Bctv;
  private QQBrowserActivity jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity;
  private TeamWorkFileImportInfo jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo;
  private WebView jdField_a_of_type_ComTencentSmttSdkWebView;
  private TextView b;
  private TextView c;
  
  public bcvp(Context paramContext)
  {
    super(paramContext, false, 2);
    setBottomBarInterface(this);
    if ((paramContext instanceof QQBrowserActivity))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity = ((QQBrowserActivity)paramContext);
      this.jdField_a_of_type_ComTencentSmttSdkWebView = ((QQBrowserActivity)paramContext).getHostWebView();
    }
    paramContext = new Intent();
    paramContext.putExtra("forward_type", -3);
    paramContext.putExtra("key_share_data_line_support_type", 1);
    setIntentForStartForwardRecentActivity(paramContext);
    setRowVisibility(0, 0, 0);
  }
  
  private View a()
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity != null)
    {
      localObject1 = localObject2;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.a() != null)
      {
        this.jdField_a_of_type_Bctv = this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.a().getShare().a();
        localObject1 = (RelativeLayout)LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity).inflate(2131562875, null);
        if ((this.jdField_a_of_type_Bctv == null) || (!this.jdField_a_of_type_Bctv.jdField_a_of_type_Boolean)) {
          break label413;
        }
        ((RelativeLayout)localObject1).setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)((RelativeLayout)localObject1).findViewById(2131379479));
        this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(new bcvq(this));
        if (this.jdField_a_of_type_Bctv.c != 1) {
          break label304;
        }
        this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.getText(2131690199));
        this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)((RelativeLayout)localObject1).findViewById(2131376751));
        this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)((RelativeLayout)localObject1).findViewById(2131379479));
        this.b = ((TextView)((RelativeLayout)localObject1).findViewById(2131379477));
        this.b.setTextColor(Color.parseColor("#777777"));
        if (this.jdField_a_of_type_Bctv.c == 2) {
          this.b.setTextColor(Color.parseColor("#fe6c6c"));
        }
        this.b.setText(this.jdField_a_of_type_Bctv.jdField_a_of_type_JavaLangString);
        this.c = ((TextView)((RelativeLayout)localObject1).findViewById(2131379478));
        this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)((RelativeLayout)localObject1).findViewById(2131369158));
        if (2 != this.jdField_a_of_type_Bctv.c) {
          break label359;
        }
        if (!TextUtils.isEmpty(this.jdField_a_of_type_Bctv.b)) {
          break label334;
        }
        this.c.setVisibility(8);
      }
    }
    label413:
    for (;;)
    {
      ((RelativeLayout)localObject1).setLayoutParams(new ViewGroup.LayoutParams(-1, UIUtils.dip2px(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity, 70.0F)));
      return localObject1;
      label304:
      if (this.jdField_a_of_type_Bctv.c != 2) {
        break;
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.getText(2131689667));
      break;
      label334:
      this.c.setVisibility(0);
      this.c.setText(this.jdField_a_of_type_Bctv.b);
      continue;
      label359:
      if (TextUtils.isEmpty(this.jdField_a_of_type_Bctv.f))
      {
        this.c.setVisibility(8);
      }
      else
      {
        this.c.setVisibility(0);
        a(this.jdField_a_of_type_Bctv.f, this.jdField_a_of_type_Bctv.d);
        continue;
        ((RelativeLayout)localObject1).setVisibility(8);
      }
    }
  }
  
  public void a(TeamWorkFileImportInfo paramTeamWorkFileImportInfo)
  {
    this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo = paramTeamWorkFileImportInfo;
  }
  
  public void a(String paramString, int paramInt)
  {
    String str = this.jdField_a_of_type_Bctv.g;
    if (paramInt == 0)
    {
      this.c.setText(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.getString(2131718842));
      return;
    }
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.post(new TeamWorkShareActionSheetBuilder.1(this, paramString, str));
  }
  
  public View createBottomBar()
  {
    return a();
  }
  
  public void setItemClickListenerV2(ShareActionSheet.OnItemClickListener paramOnItemClickListener)
  {
    super.setItemClickListenerV2(new bcvr(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity, this.jdField_a_of_type_ComTencentSmttSdkWebView, this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo, paramOnItemClickListener));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcvp
 * JD-Core Version:    0.7.0.1
 */