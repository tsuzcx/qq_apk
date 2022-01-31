import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.QQBrowserDelegationActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ThemeImageView;
import java.net.MalformedURLException;
import java.net.URL;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class avxz
  implements View.OnClickListener
{
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private View jdField_a_of_type_AndroidViewView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private String jdField_a_of_type_JavaLangString;
  private final View[] jdField_a_of_type_ArrayOfAndroidViewView = new View[3];
  private final TextView[] jdField_a_of_type_ArrayOfAndroidWidgetTextView = new TextView[3];
  private final String[] jdField_a_of_type_ArrayOfJavaLangString = new String[3];
  private int jdField_b_of_type_Int;
  private View jdField_b_of_type_AndroidViewView;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private String jdField_b_of_type_JavaLangString;
  private final String[] jdField_b_of_type_ArrayOfJavaLangString = new String[3];
  private int jdField_c_of_type_Int;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private String jdField_c_of_type_JavaLangString;
  private int jdField_d_of_type_Int;
  private String jdField_d_of_type_JavaLangString;
  private String e;
  private String f;
  private String g;
  
  public avxz(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  private void a(String paramString, ImageView paramImageView)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.e("RichTemplateOneSearchResultView", 2, "setImageUrl " + paramString);
      }
      paramImageView.setImageDrawable(URLDrawable.getDrawable(new URL(paramString), 0, 0, new ColorDrawable(-1315339), new ColorDrawable(-1315339), true));
      return;
    }
    catch (MalformedURLException paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.e("RichTemplateOneSearchResultView", 2, "setImageUrl error " + paramString.toString());
      }
      paramImageView.setImageDrawable(new ColorDrawable(-1315339));
    }
  }
  
  private void b(String paramString)
  {
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserDelegationActivity.class);
    localIntent.putExtra("param_force_internal_browser", true);
    localIntent.putExtra("url", paramString);
    acgk.a(this.jdField_a_of_type_AndroidContentContext, localIntent, paramString);
  }
  
  void a()
  {
    int i = 0;
    this.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_JavaLangString = null;
    this.jdField_b_of_type_JavaLangString = null;
    this.jdField_c_of_type_JavaLangString = null;
    this.jdField_d_of_type_JavaLangString = null;
    this.e = null;
    this.f = null;
    this.jdField_a_of_type_Int = 0;
    this.jdField_c_of_type_Int = 0;
    this.jdField_d_of_type_Int = 0;
    this.g = null;
    while (i < 3)
    {
      this.jdField_a_of_type_ArrayOfJavaLangString[i] = null;
      this.jdField_b_of_type_ArrayOfJavaLangString[i] = null;
      i += 1;
    }
  }
  
  void a(View paramView)
  {
    if (paramView != null)
    {
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131302064));
      this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131297595));
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131304986));
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131299484));
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131304061));
      this.jdField_a_of_type_ArrayOfAndroidWidgetTextView[0] = ((TextView)paramView.findViewById(2131298187));
      this.jdField_a_of_type_ArrayOfAndroidWidgetTextView[1] = ((TextView)paramView.findViewById(2131298188));
      this.jdField_a_of_type_ArrayOfAndroidWidgetTextView[2] = ((TextView)paramView.findViewById(2131298189));
      this.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131297596);
      this.jdField_a_of_type_ArrayOfAndroidViewView[0] = paramView.findViewById(2131297773);
      this.jdField_a_of_type_ArrayOfAndroidViewView[1] = paramView.findViewById(2131297775);
      this.jdField_a_of_type_ArrayOfAndroidViewView[2] = paramView.findViewById(2131297774);
      this.jdField_b_of_type_AndroidViewView = paramView.findViewById(2131298190);
      if ((this.jdField_a_of_type_AndroidWidgetImageView instanceof ThemeImageView)) {
        ((ThemeImageView)this.jdField_a_of_type_AndroidWidgetImageView).setMaskShape(beog.jdField_c_of_type_Int);
      }
      if ((this.jdField_b_of_type_AndroidWidgetImageView instanceof ThemeImageView)) {
        ((ThemeImageView)this.jdField_b_of_type_AndroidWidgetImageView).setMaskShape(beog.jdField_c_of_type_Int);
      }
      this.jdField_b_of_type_AndroidWidgetImageView.getViewTreeObserver().addOnGlobalLayoutListener(new avya(this));
      paramView.setOnClickListener(new avyb(this));
    }
  }
  
  void a(String paramString)
  {
    for (;;)
    {
      JSONObject localJSONObject1;
      int i;
      try
      {
        localJSONObject1 = new JSONObject(paramString).optJSONObject("data");
        if (localJSONObject1 != null)
        {
          paramString = localJSONObject1.get("serverdata");
          if (paramString != null) {
            if ((paramString instanceof String))
            {
              paramString = new JSONObject((String)paramString);
              this.jdField_b_of_type_Int = paramString.optInt("appid");
              this.jdField_a_of_type_JavaLangString = paramString.optString("thumbnail");
              this.jdField_b_of_type_JavaLangString = paramString.optString("title");
              this.jdField_c_of_type_JavaLangString = paramString.optString("sub_title");
              this.jdField_d_of_type_JavaLangString = paramString.optString("bg_pic_url");
              this.e = paramString.optString("bg_main_btn_text");
              this.f = paramString.optString("bg_main_btn_url");
              paramString = paramString.optJSONArray("bottom_btn_list");
              if (paramString != null)
              {
                int j = paramString.length();
                i = 0;
                if (i < j)
                {
                  JSONObject localJSONObject2 = paramString.optJSONObject(i);
                  if ((localJSONObject2 == null) || (i >= 3)) {
                    break label314;
                  }
                  this.jdField_a_of_type_ArrayOfJavaLangString[i] = localJSONObject2.optString("bottom_btn_text");
                  this.jdField_b_of_type_ArrayOfJavaLangString[i] = localJSONObject2.optString("bottom_btn_url");
                  break label314;
                }
              }
            }
            else
            {
              if ((paramString instanceof JSONObject))
              {
                paramString = (JSONObject)paramString;
                continue;
              }
              paramString = new JSONObject();
              continue;
            }
          }
        }
        else
        {
          return;
        }
      }
      catch (JSONException paramString)
      {
        if (QLog.isColorLevel()) {
          QLog.e("RichTemplateOneSearchResultView", 2, "initData error " + paramString.toString());
        }
      }
      do
      {
        paramString = localJSONObject1.getJSONObject("extradata");
      } while (paramString == null);
      this.jdField_c_of_type_Int = paramString.getInt("entry");
      this.jdField_d_of_type_Int = paramString.getInt("match");
      this.g = paramString.getString("keyword");
      this.jdField_a_of_type_Int = paramString.optInt("nightmode", 0);
      return;
      label314:
      i += 1;
    }
  }
  
  void b()
  {
    label36:
    label58:
    String str;
    label92:
    label117:
    int i;
    if (this.jdField_b_of_type_JavaLangString != null)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_b_of_type_JavaLangString);
      if (this.jdField_c_of_type_JavaLangString == null) {
        break label260;
      }
      this.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_c_of_type_JavaLangString);
      if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
        break label273;
      }
      a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_AndroidWidgetImageView);
      if (TextUtils.isEmpty(this.jdField_d_of_type_JavaLangString)) {
        break label292;
      }
      this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
      View localView = this.jdField_a_of_type_AndroidViewView;
      if (this.e != null) {
        break label284;
      }
      str = "";
      localView.setContentDescription(str);
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      a(this.jdField_d_of_type_JavaLangString, this.jdField_b_of_type_AndroidWidgetImageView);
      if (TextUtils.isEmpty(this.e)) {
        break label312;
      }
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_c_of_type_AndroidWidgetTextView.setText(this.e);
      label146:
      i = 0;
      label148:
      if (i >= 3) {
        break label363;
      }
      if (TextUtils.isEmpty(this.jdField_a_of_type_ArrayOfJavaLangString[i])) {
        break label324;
      }
      this.jdField_a_of_type_ArrayOfAndroidWidgetTextView[i].setVisibility(0);
      this.jdField_a_of_type_ArrayOfAndroidWidgetTextView[i].setText(this.jdField_a_of_type_ArrayOfJavaLangString[i]);
      this.jdField_a_of_type_ArrayOfAndroidWidgetTextView[i].setOnClickListener(this);
      this.jdField_a_of_type_ArrayOfAndroidViewView[i].setVisibility(0);
      label210:
      if (this.jdField_a_of_type_Int != 1) {
        break label349;
      }
      this.jdField_a_of_type_ArrayOfAndroidViewView[i].setBackgroundColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131101200));
    }
    for (;;)
    {
      i += 1;
      break label148;
      this.jdField_a_of_type_AndroidWidgetTextView.setText("");
      break;
      label260:
      this.jdField_b_of_type_AndroidWidgetTextView.setText("");
      break label36;
      label273:
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(null);
      break label58;
      label284:
      str = this.e;
      break label92;
      label292:
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(null);
      break label117;
      label312:
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      break label146;
      label324:
      this.jdField_a_of_type_ArrayOfAndroidWidgetTextView[i].setVisibility(8);
      this.jdField_a_of_type_ArrayOfAndroidViewView[i].setVisibility(8);
      break label210;
      label349:
      this.jdField_a_of_type_ArrayOfAndroidViewView[i].setBackgroundColor(-1315339);
    }
    label363:
    this.jdField_b_of_type_AndroidViewView.setOnClickListener(new avyc(this));
  }
  
  public void onClick(View paramView)
  {
    int i;
    switch (paramView.getId())
    {
    default: 
      paramView = null;
      i = 0;
      if (this.jdField_d_of_type_Int == 1) {
        avsv.a(null, this.jdField_c_of_type_Int, 0, "0X8009D2D", this.jdField_b_of_type_Int, i, this.g);
      }
      break;
    }
    for (;;)
    {
      if (paramView != null)
      {
        if (QLog.isColorLevel()) {
          QLog.e("RichTemplateOneSearchResultView", 2, "onClick " + paramView);
        }
        if (!paramView.startsWith("http")) {
          break label203;
        }
        b(paramView);
      }
      return;
      paramView = this.f;
      i = 4;
      break;
      paramView = this.jdField_b_of_type_ArrayOfJavaLangString[0];
      i = 1;
      break;
      paramView = this.jdField_b_of_type_ArrayOfJavaLangString[1];
      i = 2;
      break;
      paramView = this.jdField_b_of_type_ArrayOfJavaLangString[2];
      i = 3;
      break;
      avsv.a(null, this.jdField_c_of_type_Int, 0, "0X8009D41", this.jdField_b_of_type_Int, i, this.g);
    }
    label203:
    bacn localbacn = bade.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), this.jdField_a_of_type_AndroidContentContext, paramView);
    if (localbacn != null)
    {
      localbacn.c();
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.e("RichTemplateOneSearchResultView", 2, "wrong url " + paramView);
    }
    b(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avxz
 * JD-Core Version:    0.7.0.1
 */