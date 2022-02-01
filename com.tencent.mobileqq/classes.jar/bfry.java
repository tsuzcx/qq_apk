import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.troop.homework.entry.ui.PublishHomeWorkFragment;
import com.tencent.mobileqq.troop.homework.logic.DocsEntranceHelper.1;
import com.tencent.mobileqq.troop.homework.logic.DocsEntranceHelper.2;
import com.tencent.mobileqq.troop.homework.logic.DocsEntranceHelper.3;
import com.tencent.mobileqq.troop.homework.xmediaeditor.XMediaEditor;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class bfry
  implements View.OnClickListener, bfrz
{
  protected int a;
  protected View a;
  public LinearLayout a;
  protected TextView a;
  public PublishHomeWorkFragment a;
  protected Boolean a;
  protected String a;
  protected JSONObject a;
  protected boolean a;
  protected View b;
  protected TextView b;
  protected String b;
  public boolean b;
  protected View c;
  protected String c;
  protected boolean c;
  protected String d;
  protected boolean d;
  
  public bfry(PublishHomeWorkFragment paramPublishHomeWorkFragment, String paramString)
  {
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(false);
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_c_of_type_JavaLangString = "";
    this.jdField_d_of_type_JavaLangString = "";
    this.jdField_c_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkEntryUiPublishHomeWorkFragment = paramPublishHomeWorkFragment;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  private String a()
  {
    QQAppInterface localQQAppInterface;
    Object localObject;
    if (this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkEntryUiPublishHomeWorkFragment.getActivity() == null)
    {
      localQQAppInterface = null;
      if (localQQAppInterface != null) {
        break label61;
      }
      localObject = BaseApplicationImpl.getApplication().getRuntime();
      if (!(localObject instanceof QQAppInterface)) {
        break label86;
      }
      localQQAppInterface = (QQAppInterface)localObject;
    }
    label61:
    label86:
    for (;;)
    {
      localObject = localQQAppInterface;
      if (localQQAppInterface == null)
      {
        return "publish_hw_docs_guide_counts";
        localQQAppInterface = (QQAppInterface)this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkEntryUiPublishHomeWorkFragment.getActivity().getAppInterface();
        break;
        localObject = localQQAppInterface;
      }
      return "publish_hw_docs_guide_counts" + ((QQAppInterface)localObject).getCurrentAccountUin();
    }
  }
  
  private void a(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DocsEntranceHelper", 2, "onJumpToDocs");
    }
    paramView = (bfpx)aqxe.a().a(605);
    if (paramView != null)
    {
      paramView = paramView.c();
      if (paramView.isEmpty()) {
        return;
      }
      paramView = new StringBuilder(paramView);
      paramView.append("?gc=").append(this.jdField_a_of_type_JavaLangString);
      paramView.append("&appid=").append("101458937");
      paramView.append("&_wwv=128&_wv=3");
      paramView = paramView.toString();
      localObject = new Intent(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkEntryUiPublishHomeWorkFragment.getActivity(), QQBrowserActivity.class);
      ((Intent)localObject).putExtra("url", paramView);
      this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkEntryUiPublishHomeWorkFragment.getActivity().startActivityForResult((Intent)localObject, 265);
      if (this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkEntryUiPublishHomeWorkFragment.a() != null) {
        this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkEntryUiPublishHomeWorkFragment.a().b();
      }
      if (this.jdField_a_of_type_AndroidWidgetTextView.getVisibility() == 0)
      {
        a(false, 3);
        c(false);
        d(false);
      }
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkEntryUiPublishHomeWorkFragment.a();
    if (this.jdField_a_of_type_JavaLangString == null) {}
    for (paramView = "";; paramView = this.jdField_a_of_type_JavaLangString)
    {
      bhbu.a("Grp_edu", "homework", "createHW_doc_clk", 0, 0, new String[] { paramView, ((Bundle)localObject).getString("reportIdentity", ""), ((Bundle)localObject).getString("reportCourse", "") });
      return;
    }
  }
  
  private void a(boolean paramBoolean, int paramInt)
  {
    ThreadManager.postImmediately(new DocsEntranceHelper.3(this, paramBoolean, paramInt), null, false);
  }
  
  private void b(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DocsEntranceHelper", 2, "onClickDocsLink");
    }
    paramView = (bfpx)aqxe.a().a(605);
    if (paramView != null)
    {
      paramView = paramView.d();
      if (!paramView.isEmpty()) {
        break label44;
      }
    }
    label44:
    do
    {
      return;
      paramView = new StringBuilder(paramView);
      paramView.append("?gc=").append(this.jdField_a_of_type_JavaLangString);
      paramView.append("&appid=").append("101458937");
      paramView.append("&examid=").append(this.jdField_d_of_type_JavaLangString);
      paramView.append("&_wwv=128&_wv=3");
      paramView = paramView.toString();
      Intent localIntent = new Intent(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkEntryUiPublishHomeWorkFragment.getActivity(), QQBrowserActivity.class);
      localIntent.putExtra("url", paramView);
      this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkEntryUiPublishHomeWorkFragment.startActivity(localIntent);
    } while (this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkEntryUiPublishHomeWorkFragment.a() == null);
    this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkEntryUiPublishHomeWorkFragment.a().b();
  }
  
  private boolean b()
  {
    bfpx localbfpx = (bfpx)aqxe.a().a(605);
    if ((localbfpx != null) && (!localbfpx.b())) {
      return false;
    }
    int i = PreferenceManager.getDefaultSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkEntryUiPublishHomeWorkFragment.getActivity()).getInt(a(), 0);
    if (QLog.isColorLevel()) {
      QLog.d("DocsEntranceHelper", 2, String.format("needShow guide count: %s", new Object[] { Integer.valueOf(i) }));
    }
    if (i < 3) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  private void c(View paramView)
  {
    a(false);
    if (this.jdField_a_of_type_AndroidWidgetLinearLayout != null) {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkEntryUiPublishHomeWorkFragment.a(2);
  }
  
  private void c(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_AndroidWidgetTextView != null)
    {
      if (paramBoolean)
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetTextView.setText("");
        this.jdField_a_of_type_AndroidWidgetTextView.setBackgroundResource(0);
        this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(2130838000, 0, 0, 0);
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
  }
  
  private void d(boolean paramBoolean)
  {
    if (this.jdField_b_of_type_AndroidViewView != null)
    {
      if ((paramBoolean) && (!this.jdField_a_of_type_Boolean))
      {
        this.jdField_b_of_type_AndroidViewView.setVisibility(0);
        this.jdField_a_of_type_Boolean = true;
      }
    }
    else {
      return;
    }
    this.jdField_b_of_type_AndroidViewView.setVisibility(8);
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkEntryUiPublishHomeWorkFragment.a(2131373351);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkEntryUiPublishHomeWorkFragment.a(2131373353));
    this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkEntryUiPublishHomeWorkFragment.a(2131372581);
    bfpx localbfpx = (bfpx)aqxe.a().a(605);
    if (localbfpx != null)
    {
      if (!localbfpx.b()) {
        break label225;
      }
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
      if (this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkEntryUiPublishHomeWorkFragment.a() != 1) {
        break label214;
      }
      this.jdField_a_of_type_AndroidViewView.setClickable(true);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkEntryUiPublishHomeWorkFragment.a(2131379482));
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener(this);
      if (!this.jdField_a_of_type_JavaLangBoolean.booleanValue()) {
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      }
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131379628));
      this.jdField_c_of_type_AndroidViewView = this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131379443);
      this.jdField_c_of_type_AndroidViewView.setOnClickListener(this);
      this.jdField_d_of_type_Boolean = b();
      if (!this.jdField_d_of_type_Boolean) {
        break;
      }
      c(true);
      a(true, 1);
      return;
      label214:
      this.jdField_a_of_type_AndroidViewView.setClickable(false);
      continue;
      label225:
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    }
    c(false);
    d(false);
  }
  
  public void a(int paramInt)
  {
    Bundle localBundle;
    if ((this.jdField_a_of_type_JavaLangBoolean.booleanValue()) && (paramInt == 1))
    {
      localBundle = this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkEntryUiPublishHomeWorkFragment.a();
      if (this.jdField_a_of_type_JavaLangString != null) {
        break label76;
      }
    }
    label76:
    for (String str = "";; str = this.jdField_a_of_type_JavaLangString)
    {
      bhbu.a("Grp_edu", "homework", "createHW_doc", 0, 0, new String[] { str, localBundle.getString("reportIdentity", ""), localBundle.getString("reportCourse", "") });
      return;
    }
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 != 265) {
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
      this.jdField_c_of_type_JavaLangString = paramIntent.optString("course_name");
      this.jdField_d_of_type_JavaLangString = paramIntent.optString("exam_id");
      this.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_b_of_type_JavaLangString);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      a(true);
      this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkEntryUiPublishHomeWorkFragment.a(2);
    }
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    if (paramInt != 2)
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
      localJSONObject.put("appid", "101458937");
      localJSONObject.put("exam_id", this.jdField_d_of_type_JavaLangString);
      localJSONObject.put("course_name", this.jdField_c_of_type_JavaLangString);
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
    if ((str1 != null) && (str1.equals("exam")) && (str2 != null) && (!str2.equals("0")) && (str3 != null) && (str3.equals("101458937")))
    {
      this.jdField_a_of_type_OrgJsonJSONObject = paramJSONObject;
      str1 = paramJSONObject.optString("title");
      this.jdField_b_of_type_AndroidWidgetTextView.setText(str1);
      this.jdField_d_of_type_JavaLangString = paramJSONObject.optString("exam_id");
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setClickable(false);
      this.jdField_c_of_type_AndroidViewView.setVisibility(8);
      a(true);
      this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkEntryUiPublishHomeWorkFragment.a(2);
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
  
  public void b(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
    if (!paramBoolean) {
      d(false);
    }
    while (!this.jdField_a_of_type_JavaLangBoolean.booleanValue())
    {
      return;
      if (this.jdField_c_of_type_Boolean)
      {
        this.jdField_c_of_type_Boolean = false;
        if (this.jdField_d_of_type_Boolean) {
          ThreadManager.getUIHandler().postDelayed(new DocsEntranceHelper.1(this), 500L);
        }
      }
    }
    if (paramBoolean)
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      d(false);
      return;
    }
    ThreadManager.getUIHandler().postDelayed(new DocsEntranceHelper.2(this), 20L);
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
 * Qualified Name:     bfry
 * JD-Core Version:    0.7.0.1
 */