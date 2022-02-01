import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.troop.homework.entry.ui.PublishHomeWorkFragment;
import com.tencent.mobileqq.troop.homework.logic.WeiKeEntranceHelper.1;
import com.tencent.mobileqq.troop.homework.xmediaeditor.XMediaEditor;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class bfsa
  implements View.OnClickListener, bfrz
{
  protected int a;
  protected View a;
  public LinearLayout a;
  protected TextView a;
  protected PublishHomeWorkFragment a;
  protected Boolean a;
  protected String a;
  protected JSONObject a;
  protected int b;
  protected View b;
  protected String b;
  protected String c = "";
  
  public bfsa(PublishHomeWorkFragment paramPublishHomeWorkFragment, String paramString)
  {
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(false);
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkEntryUiPublishHomeWorkFragment = paramPublishHomeWorkFragment;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  private void c(View paramView)
  {
    a(false);
    if (this.jdField_a_of_type_AndroidWidgetLinearLayout != null) {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkEntryUiPublishHomeWorkFragment.a(1);
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkEntryUiPublishHomeWorkFragment.a(2131373379);
    bfpx localbfpx = (bfpx)aqxe.a().a(605);
    if (localbfpx != null)
    {
      if (!localbfpx.a()) {
        break label164;
      }
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
      if (this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkEntryUiPublishHomeWorkFragment.a() != 1) {
        break label153;
      }
      this.jdField_a_of_type_AndroidViewView.setClickable(true);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkEntryUiPublishHomeWorkFragment.a(2131379484));
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener(this);
      if (!this.jdField_a_of_type_JavaLangBoolean.booleanValue()) {
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      }
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkEntryUiPublishHomeWorkFragment.a(2131379491));
      this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkEntryUiPublishHomeWorkFragment.a(2131379625);
      this.jdField_b_of_type_AndroidViewView.setOnClickListener(this);
      return;
      label153:
      this.jdField_a_of_type_AndroidViewView.setClickable(false);
      continue;
      label164:
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    }
  }
  
  public void a(int paramInt)
  {
    Bundle localBundle;
    if ((this.jdField_a_of_type_JavaLangBoolean.booleanValue()) && (paramInt == 1))
    {
      localBundle = this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkEntryUiPublishHomeWorkFragment.a();
      if (this.jdField_a_of_type_JavaLangString != null) {
        break label75;
      }
    }
    label75:
    for (String str = "";; str = this.jdField_a_of_type_JavaLangString)
    {
      bhbu.a("Grp_edu", "homework", "createHW_lele", 0, 0, new String[] { str, localBundle.getString("reportIdentity", ""), localBundle.getString("reportCourse", "") });
      return;
    }
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 != 264) {
      return;
    }
    if (paramIntent == null)
    {
      QLog.e("DocsEntranceHelper", 2, "onActivityResult data == null");
      return;
    }
    paramIntent = paramIntent.getStringExtra("params");
    if (paramIntent.isEmpty())
    {
      QLog.e("DocsEntranceHelper", 2, "onActivityResult strData.isEmpty");
      return;
    }
    Object localObject;
    try
    {
      paramIntent = new JSONObject(paramIntent);
      if (paramIntent == null)
      {
        QLog.e("DocsEntranceHelper", 2, "onActivityResult argsJson == null");
        return;
      }
    }
    catch (JSONException paramIntent)
    {
      for (;;)
      {
        paramIntent = null;
      }
      this.jdField_b_of_type_JavaLangString = paramIntent.optString("title");
      this.jdField_a_of_type_Int = paramIntent.optInt("num", 0);
      localObject = anvx.a(2131697166) + " (" + this.jdField_a_of_type_Int + anvx.a(2131697167) + ")\n" + anvx.a(2131697168) + "\n" + this.jdField_b_of_type_JavaLangString;
      this.c = paramIntent.optString("course_name");
      this.jdField_b_of_type_Int = paramIntent.optInt("exam_id", -1);
    }
    try
    {
      paramIntent = new JSONObject();
      paramIntent.put("type", "str");
      paramIntent.put("text", localObject);
      localObject = new JSONArray();
      ((JSONArray)localObject).put(paramIntent);
      if (this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkEntryUiPublishHomeWorkFragment.a() != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkEntryUiPublishHomeWorkFragment.a().setDataByEdit((JSONArray)localObject);
        this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkEntryUiPublishHomeWorkFragment.f();
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_b_of_type_JavaLangString);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      a(true);
      this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkEntryUiPublishHomeWorkFragment.a(1);
      return;
    }
    catch (JSONException paramIntent)
    {
      for (;;)
      {
        paramIntent.printStackTrace();
      }
    }
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    if (paramInt != 1)
    {
      if (paramBoolean) {
        this.jdField_a_of_type_AndroidViewView.setEnabled(false);
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_AndroidViewView.setEnabled(true);
  }
  
  protected void a(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DocsEntranceHelper", 2, "onJumpToWeiKe");
    }
    bkxz.a(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkEntryUiPublishHomeWorkFragment.getActivity());
    paramView = new Intent(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkEntryUiPublishHomeWorkFragment.getActivity(), QQBrowserActivity.class);
    StringBuilder localStringBuilder = new StringBuilder(((bfpx)aqxe.a().a(605)).a());
    localStringBuilder.append("?gc=").append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append("&appid=").append("101036803");
    localStringBuilder.append("&_wwv=128&_wv=3");
    paramView.putExtra("url", localStringBuilder.toString());
    this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkEntryUiPublishHomeWorkFragment.getActivity().startActivityForResult(paramView, 264);
    if (this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkEntryUiPublishHomeWorkFragment.a() != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkEntryUiPublishHomeWorkFragment.a().b();
    }
  }
  
  public void a(JSONArray paramJSONArray)
  {
    if (this.jdField_a_of_type_JavaLangBoolean.booleanValue())
    {
      if (this.jdField_a_of_type_OrgJsonJSONObject != null) {
        paramJSONArray.put(this.jdField_a_of_type_OrgJsonJSONObject);
      }
    }
    else {
      return;
    }
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("type", "exam");
      localJSONObject.put("exam_type", "1");
      localJSONObject.put("appid", "101036803");
      localJSONObject.put("exam_id", String.valueOf(this.jdField_b_of_type_Int));
      localJSONObject.put("course_name", this.c);
      localJSONObject.put("exam_count", String.valueOf(this.jdField_a_of_type_Int));
      localJSONObject.put("title", this.jdField_b_of_type_JavaLangString);
      paramJSONArray.put(localJSONObject);
      return;
    }
    catch (JSONException paramJSONArray)
    {
      paramJSONArray.printStackTrace();
    }
  }
  
  public void a(JSONObject paramJSONObject)
  {
    String str1 = paramJSONObject.optString("type");
    String str2 = paramJSONObject.optString("exam_type");
    String str3 = paramJSONObject.optString("appid");
    if ((str1 != null) && (str1.equals("exam")) && (str2 != null) && (!str2.equals("0")) && (str3 != null) && (str3.equals("101036803")))
    {
      this.jdField_a_of_type_OrgJsonJSONObject = paramJSONObject;
      str1 = paramJSONObject.optString("exam_id");
      paramJSONObject = paramJSONObject.optString("title");
      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramJSONObject);
      this.jdField_b_of_type_Int = Integer.valueOf(str1).intValue();
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setClickable(false);
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
      a(true);
      this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkEntryUiPublishHomeWorkFragment.a(1);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(paramBoolean);
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_JavaLangBoolean.booleanValue();
  }
  
  protected void b(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DocsEntranceHelper", 2, "onClickWeiKeLink");
    }
    paramView = ((bfpx)aqxe.a().a(605)).b();
    if (paramView.isEmpty()) {}
    do
    {
      return;
      paramView = new StringBuilder(paramView);
      paramView.append("?gc=").append(this.jdField_a_of_type_JavaLangString);
      paramView.append("&appid=").append("101036803");
      paramView.append("&examid=").append(this.jdField_b_of_type_Int);
      paramView.append("&_wwv=128&_wv=3");
      paramView = paramView.toString();
      Intent localIntent = new Intent(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkEntryUiPublishHomeWorkFragment.getActivity(), QQBrowserActivity.class);
      localIntent.putExtra("url", paramView);
      this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkEntryUiPublishHomeWorkFragment.startActivity(localIntent);
    } while (this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkEntryUiPublishHomeWorkFragment.a() == null);
    this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkEntryUiPublishHomeWorkFragment.a().b();
  }
  
  public void b(boolean paramBoolean)
  {
    if (!this.jdField_a_of_type_JavaLangBoolean.booleanValue()) {
      return;
    }
    if (paramBoolean)
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      return;
    }
    ThreadManager.getUIHandler().postDelayed(new WeiKeEntranceHelper.1(this), 20L);
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      a(paramView);
      continue;
      b(paramView);
      continue;
      c(paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfsa
 * JD-Core Version:    0.7.0.1
 */