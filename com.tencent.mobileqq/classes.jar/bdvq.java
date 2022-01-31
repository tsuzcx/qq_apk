import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.qphone.base.util.QLog;
import cooperation.plugin.PluginBaseActivity;
import mqq.app.AppRuntime;
import org.json.JSONObject;

public class bdvq
  extends Dialog
  implements View.OnClickListener
{
  private int jdField_a_of_type_Int;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private SharedPreferences jdField_a_of_type_AndroidContentSharedPreferences;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private bdvt jdField_a_of_type_Bdvt;
  private CustomWebView jdField_a_of_type_ComTencentBizPubaccountCustomWebView;
  private String jdField_a_of_type_JavaLangString;
  private int jdField_b_of_type_Int = 2;
  private Button jdField_b_of_type_AndroidWidgetButton;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private String jdField_b_of_type_JavaLangString;
  
  public bdvq(Activity paramActivity, bdvt parambdvt, int paramInt1, String paramString, int paramInt2)
  {
    super(paramActivity, 2131755801);
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_Bdvt = parambdvt;
    this.jdField_b_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
    a();
  }
  
  public bdvq(Activity paramActivity, CustomWebView paramCustomWebView, String paramString1, int paramInt1, String paramString2, int paramInt2)
  {
    super(paramActivity, 2131755801);
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView = paramCustomWebView;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_JavaLangString = paramString2;
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
    a();
  }
  
  private void a()
  {
    setContentView(2131558911);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131363072));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131370205));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131364946));
    this.jdField_b_of_type_AndroidWidgetButton = ((Button)findViewById(2131364804));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131363907));
    this.jdField_a_of_type_AndroidContentSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("CUKingCardFile_" + BaseApplicationImpl.getApplication().getRuntime().getAccount(), 4);
    Object localObject1 = this.jdField_a_of_type_AndroidContentSharedPreferences.getString("guidePopupImgUrl_v2", "");
    if (QLog.isColorLevel()) {
      QLog.i("CUKingCardDialog", 2, "SP_KEY_GUIDE_POPUP_IMG_URL: " + (String)localObject1);
    }
    Object localObject2 = new ColorDrawable(this.jdField_a_of_type_AndroidAppActivity.getResources().getColor(2131167184));
    Object localObject3;
    if (!TextUtils.isEmpty((CharSequence)localObject1))
    {
      localObject3 = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject3).mLoadingDrawable = ((Drawable)localObject2);
      ((URLDrawable.URLDrawableOptions)localObject3).mFailedDrawable = ((Drawable)localObject2);
      localObject1 = URLDrawable.getDrawable((String)localObject1, (URLDrawable.URLDrawableOptions)localObject3);
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject1);
    }
    for (;;)
    {
      localObject1 = this.jdField_a_of_type_AndroidContentSharedPreferences.getString("guidePopupText_v2", "");
      localObject2 = this.jdField_a_of_type_AndroidContentSharedPreferences.getString("guideJumpText_v2", "");
      localObject3 = this.jdField_a_of_type_AndroidContentSharedPreferences.getString("guideContinueText_v2", "");
      if (QLog.isColorLevel()) {
        QLog.i("CUKingCardDialog", 2, String.format("popUpType: %d, mSceneId: %d, popUpStr: %s, guideBtnStr: %s, continueBtnStr: %s", new Object[] { Integer.valueOf(this.jdField_b_of_type_Int), Integer.valueOf(this.jdField_a_of_type_Int), localObject1, localObject2, localObject3 }));
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject1);
      this.jdField_a_of_type_AndroidWidgetButton.setText((CharSequence)localObject2);
      this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
      this.jdField_b_of_type_AndroidWidgetButton.setText((CharSequence)localObject3);
      this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(this);
      this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
      return;
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject2);
    }
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_Bdvt != null) {
      this.jdField_a_of_type_Bdvt.callback(3);
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView != null) {}
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("result", 3);
      this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.callJs(this.jdField_a_of_type_JavaLangString, new String[] { localJSONObject.toString() });
      if (this.jdField_b_of_type_Int == 2)
      {
        VasWebviewUtil.reportCommercialDrainage("", "wkclub", "P2-3", this.jdField_b_of_type_JavaLangString, 1, 0, 0, "", "", "");
        return;
      }
    }
    catch (Exception localException)
    {
      do
      {
        for (;;)
        {
          QLog.e("CUKingCardDialog", 1, "onClick exception e = ", localException);
        }
      } while (this.jdField_b_of_type_Int != 3);
      VasWebviewUtil.reportCommercialDrainage("", "wkclub", "P3-3", this.jdField_b_of_type_JavaLangString, 1, 0, 0, "", "", "");
    }
  }
  
  public void onBackPressed()
  {
    super.onBackPressed();
    b();
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
    case 2131364946: 
    case 2131364804: 
      label114:
      do
      {
        return;
        paramView = bdvr.a(this.jdField_b_of_type_JavaLangString);
        Object localObject;
        if (!TextUtils.isEmpty(paramView)) {
          if ((this.jdField_a_of_type_AndroidAppActivity instanceof PluginBaseActivity))
          {
            localObject = (PluginBaseActivity)this.jdField_a_of_type_AndroidAppActivity;
            Intent localIntent = new Intent(((PluginBaseActivity)localObject).getOutActivity(), QQBrowserActivity.class);
            localIntent.putExtra("url", paramView);
            localIntent.setFlags(268435456);
            ((PluginBaseActivity)localObject).getOutActivity().startActivity(localIntent);
            if (this.jdField_b_of_type_Int != 2) {
              break label270;
            }
            VasWebviewUtil.reportCommercialDrainage("", "wkclub", "P2-1", this.jdField_b_of_type_JavaLangString, 1, 0, 0, "", "", "");
          }
        }
        for (;;)
        {
          if (this.jdField_a_of_type_Bdvt != null) {
            this.jdField_a_of_type_Bdvt.callback(4);
          }
          dismiss();
          if (this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView == null) {
            break;
          }
          try
          {
            paramView = new JSONObject();
            paramView.put("result", 4);
            this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.callJs(this.jdField_a_of_type_JavaLangString, new String[] { paramView.toString() });
            return;
          }
          catch (Exception paramView)
          {
            QLog.e("CUKingCardDialog", 1, "onClick exception e = ", paramView);
            return;
          }
          localObject = new Intent(this.jdField_a_of_type_AndroidAppActivity, QQBrowserActivity.class);
          ((Intent)localObject).putExtra("url", paramView);
          this.jdField_a_of_type_AndroidAppActivity.startActivity((Intent)localObject);
          break label114;
          QLog.e("CUKingCardDialog", 1, "onClick cuGuideBtn url = null");
          break label114;
          if (this.jdField_b_of_type_Int == 3) {
            VasWebviewUtil.reportCommercialDrainage("", "wkclub", "P3-1", this.jdField_b_of_type_JavaLangString, 1, 0, 0, "", "", "");
          }
        }
        if (this.jdField_a_of_type_Bdvt != null) {
          this.jdField_a_of_type_Bdvt.callback(1);
        }
        dismiss();
        if (this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView != null) {}
        try
        {
          paramView = new JSONObject();
          paramView.put("result", 1);
          this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.callJs(this.jdField_a_of_type_JavaLangString, new String[] { paramView.toString() });
          if (this.jdField_b_of_type_Int == 2)
          {
            VasWebviewUtil.reportCommercialDrainage("", "wkclub", "P2-2", this.jdField_b_of_type_JavaLangString, 1, 0, 0, "", "", "");
            return;
          }
        }
        catch (Exception paramView)
        {
          for (;;)
          {
            QLog.e("CUKingCardDialog", 1, "onClick exception e = ", paramView);
          }
        }
      } while (this.jdField_b_of_type_Int != 3);
      label270:
      VasWebviewUtil.reportCommercialDrainage("", "wkclub", "P3-2", this.jdField_b_of_type_JavaLangString, 1, 0, 0, "", "", "");
      return;
    }
    dismiss();
    b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdvq
 * JD-Core Version:    0.7.0.1
 */