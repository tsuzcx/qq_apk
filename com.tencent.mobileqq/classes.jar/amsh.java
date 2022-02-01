import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.QQSettingMe;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

public class amsh
  extends amsf
{
  public long a;
  public String a;
  public WeakReference<QQSettingMe> a;
  public int b;
  public String b;
  public int c;
  public String c;
  public int d;
  public String d;
  public int e;
  public int f;
  int g = 7;
  private int h;
  private int i;
  private int j;
  
  public amsh(QQAppInterface paramQQAppInterface, JSONObject paramJSONObject, QQSettingMe paramQQSettingMe)
  {
    super(paramQQAppInterface);
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_a_of_type_Int = 98;
    this.jdField_b_of_type_Int = paramJSONObject.optInt("entry_id", 1);
    this.jdField_a_of_type_Long = paramJSONObject.optLong("seq", 0L);
    this.jdField_a_of_type_JavaLangString = paramJSONObject.optString("wording");
    this.jdField_b_of_type_JavaLangString = paramJSONObject.optString("jump_url");
    this.jdField_c_of_type_Int = paramJSONObject.optInt("is_red", 0);
    this.jdField_c_of_type_JavaLangString = paramJSONObject.optString("icon_url");
    this.jdField_d_of_type_Int = paramJSONObject.optInt("action_id", 0);
    this.e = paramJSONObject.optInt("bubble_id", 0);
    this.jdField_d_of_type_JavaLangString = paramJSONObject.optString("scheme");
    this.f = paramJSONObject.optInt("show_sum", 1);
    this.i = paramJSONObject.optInt("msg_id", 0);
    this.j = paramJSONObject.optInt("cmshow_module", 1);
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramQQSettingMe);
  }
  
  public void a(anct paramanct, Context paramContext, QQAppInterface paramQQAppInterface)
  {
    QLog.d("ExploreDrawerStatus", 1, "[onBubbleClick] " + this.jdField_d_of_type_JavaLangString + "|" + this.jdField_b_of_type_JavaLangString);
    if (2 == this.j) {}
    for (int k = 1;; k = 0)
    {
      VipUtils.a(null, "cmshow", "Apollo", "DrawerBubble_clk", 0, k, new String[] { this.e + "", String.valueOf(this.i) });
      ((amme)paramQQAppInterface.getManager(QQManagerFactory.APOLLO_MANAGER)).a(paramQQAppInterface, paramContext, this.jdField_d_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, "drawer");
      return;
    }
  }
  
  public void a(anct paramanct, Context paramContext, QQAppInterface paramQQAppInterface, int paramInt)
  {
    QLog.d("ExploreDrawerStatus", 1, "[onBubbleShow] showCount： " + this.h + ", showSum: " + this.f + ", content: " + this.jdField_a_of_type_JavaLangString);
    if (this.h >= this.f) {
      return;
    }
    this.h += 1;
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      anck.a(paramanct, this.jdField_a_of_type_JavaLangString, 9, this.e);
      if (2 != this.j) {
        break label202;
      }
    }
    label202:
    for (paramInt = 1;; paramInt = 0)
    {
      VipUtils.a(null, "cmshow", "Apollo", "DrawerBubble_show", 0, paramInt, new String[] { this.e + "", String.valueOf(this.i) });
      if ((TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)) || (this.jdField_a_of_type_JavaLangRefWeakReference == null)) {
        break;
      }
      paramanct = (QQSettingMe)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (paramanct == null) {
        break;
      }
      paramanct.a(this.jdField_c_of_type_JavaLangString);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amsh
 * JD-Core Version:    0.7.0.1
 */