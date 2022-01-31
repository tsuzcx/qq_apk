import android.app.Activity;
import android.app.Fragment;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.qqmini.sdk.core.MiniAppEnv;
import com.tencent.qqmini.sdk.core.proxy.ChannelProxy;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import java.util.List;

public class bddu
  extends Fragment
  implements View.OnClickListener, CompoundButton.OnCheckedChangeListener
{
  public static boolean a;
  private static final String jdField_b_of_type_JavaLangString = bddu.class.getName();
  private ProgressDialog jdField_a_of_type_AndroidAppProgressDialog;
  private ListView jdField_a_of_type_AndroidWidgetListView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  bdde jdField_a_of_type_Bdde;
  private bddt jdField_a_of_type_Bddt;
  String jdField_a_of_type_JavaLangString;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  
  public static void a(Activity paramActivity, String paramString1, String paramString2, int paramInt)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("key_appid", paramString1);
    localIntent.putExtra("key_name", paramString2);
    paramActivity.startActivityForResult(localIntent, paramInt);
  }
  
  private void a(String paramString)
  {
    List localList;
    if (this.jdField_a_of_type_Bdde != null)
    {
      localList = this.jdField_a_of_type_Bdde.a(6);
      this.jdField_a_of_type_Bddt = new bddt(getActivity(), this);
      if ((localList == null) || (localList.size() <= 0)) {
        break label125;
      }
      this.jdField_a_of_type_AndroidWidgetListView.setVisibility(0);
      if (!TextUtils.isEmpty(paramString))
      {
        this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_b_of_type_AndroidWidgetTextView.setText("允许\"" + paramString + "\"使用我的");
      }
      this.jdField_a_of_type_Bddt.a(localList);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetListView.setAdapter(this.jdField_a_of_type_Bddt);
      return;
      localList = null;
      break;
      label125:
      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString + "未使用你任何信息");
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    }
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    String str = (String)paramCompoundButton.getTag();
    if (!TextUtils.isEmpty(str))
    {
      if ((!paramBoolean) && (!jdField_a_of_type_Boolean))
      {
        jdField_a_of_type_Boolean = true;
        bdik localbdik = new bdik(getActivity(), 2131690144);
        localbdik.setContentView(2131493726);
        localbdik.a("权限设置").a("关闭授权后可能会影响使用小程序的部分功能，请确认").b("关闭授权", Color.parseColor("#5B6B92"), new bddx(this, str, paramBoolean)).a("取消", Color.parseColor("#000000"), new bddw(this, paramCompoundButton));
        localbdik.show();
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_Bddt.a(str, paramBoolean);
    this.jdField_a_of_type_Bdde.a(str, paramBoolean);
  }
  
  public void onClick(View paramView) {}
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = LayoutInflater.from(getActivity()).inflate(2131493735, null);
    if (bdyn.jdField_a_of_type_Boolean)
    {
      paramLayoutInflater.setFitsSystemWindows(true);
      paramLayoutInflater.setPadding(0, bdyn.d(getActivity()), 0, 0);
    }
    paramLayoutInflater.setBackgroundColor(Color.parseColor("#EFEFF4"));
    return paramLayoutInflater;
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    this.jdField_a_of_type_JavaLangString = getActivity().getIntent().getStringExtra("key_appid");
    paramBundle = getActivity().getIntent().getStringExtra("key_name");
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      getActivity().finish();
      return;
    }
    this.jdField_a_of_type_AndroidWidgetListView = ((ListView)paramView.findViewById(2131305683));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131305684));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131304657));
    this.jdField_a_of_type_Bdde = MiniAppEnv.g().getAuthSate(this.jdField_a_of_type_JavaLangString);
    if (this.jdField_a_of_type_Bdde == null)
    {
      bdnw.d(jdField_b_of_type_JavaLangString, "getAuthorizeCenter(appId), authState is null?!");
      return;
    }
    if (this.jdField_a_of_type_Bdde.a())
    {
      a(paramBundle);
      return;
    }
    if (this.jdField_a_of_type_AndroidAppProgressDialog == null) {
      this.jdField_a_of_type_AndroidAppProgressDialog = new ProgressDialog(getActivity());
    }
    this.jdField_a_of_type_AndroidAppProgressDialog.setMessage("正在获取权限信息，请稍候...");
    this.jdField_a_of_type_AndroidAppProgressDialog.show();
    ((ChannelProxy)ProxyManager.get(ChannelProxy.class)).getAuthList(this.jdField_a_of_type_JavaLangString, new bddv(this, paramBundle));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bddu
 * JD-Core Version:    0.7.0.1
 */